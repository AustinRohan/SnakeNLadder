package com.example.snakenladder;

import javafx.animation.AnimationTimer;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class DiceRole extends Application {
    public int rand;
    public Label randResult;

    public int cirPos[][]=new int[10][10];
    public int ladderPosition[][]=new int[6][3];


    public Circle player1;
    public Circle player2;

    public int playerPosition1=1;
    public int playerPosition2=1;

    public boolean player1Turn=true;
    public boolean player2Turn=true;

    public static int player1XPos = 25;
    public static int player1YPos = 475;

    public static int player2XPos = 25;
    public static int player2YPos= 475;

    public int posCir1=1;
    public int posCir2=1;


    public boolean gameStart=false;
    public Button gameButton;


    public static final int Tile_size=50;
    public static final int width=10;
    public static final int height=10;

    private Group tileGroup = new Group();

    private Parent createContent() throws FileNotFoundException {
        Pane root=new Pane();
        root.setPrefSize(width*Tile_size,(height * Tile_size)+80);
        root.getChildren().addAll(tileGroup);

        for (int i=0;i<height;i++) {
            for (int j=0;j<width;j++) {
                Tile tile=new Tile(Tile_size,Tile_size);
                tile.setTranslateX(j*Tile_size);
                tile.setTranslateY(i*Tile_size);
                tileGroup.getChildren().add(tile);

                cirPos[i][j]=j*(Tile_size - 25);
            }
        }

        for(int i=0;i<height;i++) {
            for(int j=0;j<width;j++) {
                System.out.print(cirPos[i][j]+" ");
            }
            System.out.println();
        }

        player1=new Circle(20);
        player1.setId("Player1");
        player1.setFill(Color.BLUE);
        //player1.getStyleClass().add("Style.css");
        player1.setTranslateX(player1XPos);
        player1.setTranslateY(player1YPos);

        player2=new Circle(20);
        player2.setId("Player2");
        player2.setFill(Color.RED);
        //player2.getStyleClass().add("Style.css");
        player2.setTranslateX(player2XPos);
        player2.setTranslateY(player2YPos);

        Button button2Player=new Button("Player2");
        button2Player.setTranslateX(400);
        button2Player.setTranslateY(520);
        button2Player.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                    if(gameStart) {
                        if (player2Turn){

                            getDiceValue();
                            randResult.setText(String.valueOf(rand));
                            move2Player();
                            translatePlayer(player2XPos,player2YPos,player2);
                            player2Turn=false;
                            player1Turn=true;
                            playerPosition2+=rand;

                            if(player2XPos==125 && player2YPos==475) {
                                translatePlayer(player2XPos=25,player2YPos=225,player2);
                            }
                            if(player2XPos==275 && player2YPos==475) {
                                translatePlayer(player2XPos=325,player2YPos=375,player2);
                            }
                            if(player2XPos==475 && player2YPos==425) {
                                translatePlayer(player2XPos=475,player2YPos=175,player2);
                            }
                            if(player2XPos==275 && player2YPos==325) {
                                translatePlayer(player2XPos=225,player2YPos=225,player2);
                            }
                            if(player2XPos==125 && player2YPos==175) {
                                translatePlayer(player2XPos=225,player2YPos=25,player2);
                            }
                            if(player2XPos==375 && player2YPos==175) {
                                translatePlayer(player2XPos=375,player2YPos=25,player2);
                            }
                            if(player2XPos==225 && player2YPos==375) {
                                translatePlayer(player2XPos=225,player2YPos=475,player2);
                            }
                            if(player2XPos==175 && player2YPos==325) {
                                translatePlayer(player2XPos=25,player2YPos=475,player2);
                            }
                            if(player2XPos==325 && player2YPos==275) {
                                translatePlayer(player2XPos=425,player2YPos=425,player2);
                            }
                            if(player2XPos==225 && player2YPos==175) {
                                translatePlayer(player2XPos=75,player2YPos=225,player2);
                            }
                            if(player2XPos==325 && player2YPos==75) {
                                translatePlayer(player2XPos=325,player2YPos=225,player2);
                            }
                            if(player2XPos==425 && player2YPos==75) {
                                translatePlayer(player2XPos=425,player2YPos=175,player2);
                            }
                            if(player2XPos==25 && player2YPos==25) {
                                translatePlayer(player2XPos=25,player2YPos=175,player2);
                            }
                        }
                    }
                }

        });



        Button button1Player =new Button("Player1");
        button1Player.setTranslateX(50);
        button1Player.setTranslateY(520);
        button1Player.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(gameStart) {
                    if(player1Turn) {

                        getDiceValue();
                        randResult.setText(String.valueOf(rand));
                        move1Player();
                        translatePlayer(player1XPos, player1YPos,player1);
                        player1Turn=false;
                        player2Turn=true;
                        playerPosition1+=rand;

                        if(player1XPos==125 && player1YPos==475) {

                            translatePlayer(player1XPos=25,player1YPos=225,player1);
                        }
                        if(player1XPos==275 && player1YPos==475) {

                            translatePlayer(player1XPos=325,player1YPos=375,player1);
                        }
                        if(player1XPos==475 && player1YPos==425) {

                            translatePlayer(player1XPos=475,player1YPos=125,player1);
                        }
                        if(player1XPos==275 && player1YPos==325) {

                            translatePlayer(player1XPos=225,player1YPos=225,player1);
                        }
                        if(player1XPos==125 && player1YPos==175) {

                            translatePlayer(player1XPos=225,player1YPos=25,player1);
                        }
                        if(player1XPos==375 && player1YPos==175) {

                            translatePlayer(player1XPos=375,player1YPos=25,player1);
                        }
                        if(player1XPos==225 && player1YPos==375) {

                            translatePlayer(player1XPos=225,player1YPos=475,player1);
                        }
                        if(player1XPos==175 && player1YPos==325) {

                            translatePlayer(player1XPos=25,player1YPos=475,player1);
                        }
                        if(player1XPos==325 && player1YPos==275) {

                            translatePlayer(player1XPos=425,player1YPos=425,player1);
                        }
                        if(player1XPos==225 && player1YPos==175) {

                            translatePlayer(player1XPos=75,player1YPos=225,player1);
                        }
                        if(player1XPos==325 && player1YPos==75) {

                            translatePlayer(player1XPos=325,player1YPos=225,player1);
                        }
                        if(player1XPos==425 && player1YPos==75) {

                            translatePlayer(player1XPos=425,player1YPos=175,player1);
                        }
                        if(player1XPos==25 && player1YPos==25) {

                            translatePlayer(player1XPos=25,player1YPos=175,player1);
                        }

                    }
                }
            }
        });

        gameButton=new Button(("Start Game"));
        gameButton.setTranslateX(200);
        gameButton.setTranslateY(550);
        gameButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                gameButton.setText("Game Started");
                player1XPos =25;
                player1YPos =475;

                player2XPos=25;
                player2YPos=475;

                player1.setTranslateX(player1XPos);
                player1.setTranslateY(player1YPos);
                player2.setTranslateX(player2XPos);
                player2.setTranslateY(player2YPos);
                gameStart=true;
            }
        });

        randResult=new Label("0");
        randResult.setTranslateX(235);
        randResult.setTranslateY(520);

        FileInputStream inputstream = new FileInputStream("C:/Users/austi/Downloads/Snakesss.jpg");
        Image img=new Image(inputstream);
        ImageView bgImage=new ImageView();
        bgImage.setImage(img);
        bgImage.setFitHeight(500);
        bgImage.setFitWidth(500);

        tileGroup.getChildren().addAll(bgImage,player1,player2,button2Player,button1Player,gameButton,randResult);
        return root;

    }

    private void getDiceValue() {
        rand=(int) (Math.random()*6+1);

    }

    private void move1Player() {
        for(int i=0;i<rand;i++) {

           // player1XPos+=50;
            /*if(posCir1 %2==1) {
                player1XPos +=50;
            }
            if(posCir1 % 2==0) {
                player1XPos -=50;
            }
            if(player1XPos >475) {
                player1YPos -=50;
                //player1XPos =25;
                player1XPos -=50;
                posCir1++;
            }
            if(player1XPos <25) {
                player1YPos -=50;
                player1XPos +=50;
                posCir1++;
            }*/

            if(player1XPos>=25){
                player1XPos+=50;
            }
            if(player1XPos > 475) {
                player1YPos -=50;
                player1XPos=25;
            }


            if(player1XPos > 475 || player1YPos < 25) {
                player1XPos =475;
                player1YPos =25;
                gameStart=false;
                randResult.setText("Player 1 Won !");
                gameButton.setText("Start Again");
            }

        }
    }

    private void move2Player() {
        for(int i=0;i<rand;i++) {

            //player2XPos+=50;
            /*if(posCir2 %2==1) {
                player2XPos+=50;
            }
            if(posCir2 % 2==0) {
                player2XPos-=50;
            }
            if(player2XPos>475) {
                player2YPos-=50;
                //player2XPos=25;
                player2XPos-=50;
                posCir2++;
            }
            if(player2XPos<25) {
                player2YPos-=50;
                player2XPos+=50;
                posCir2++;
            }*/

            if(player2XPos>=25){
                player2XPos+=50;
            }
            if(player2XPos > 475) {
                player2YPos -=50;
                player2XPos=25;
            }

            if(player2XPos > 475 || player2YPos < 25) {
                player2XPos=475;
                player2YPos=25;
                gameStart=false;
                randResult.setText("Player 2 Won !");
                gameButton.setText("Start Again");
            }

        }
    }

    private void translatePlayer(int x,int y,Circle b) {
        TranslateTransition animate = new TranslateTransition(Duration.millis(1000),b);
        animate.setToX(x);
        animate.setToY(y);
        animate.setAutoReverse(false);
        animate.play();


    }


    @Override
    public void start(Stage primarystage) throws Exception {
        Scene scene = new Scene(createContent());
        //scene.getStylesheets().add("style.css");
        primarystage.setTitle("Snake and Ladder");
        primarystage.setScene(scene);
        primarystage.show();


    }

    public static void main(String[] args) {
        launch();
    }
}