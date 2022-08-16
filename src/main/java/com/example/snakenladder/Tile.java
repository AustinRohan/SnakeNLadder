package com.example.snakenladder;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
public class Tile extends Rectangle{

    public Tile(int x,int y){
        setWidth(DiceRole.Tile_size);
        setHeight(DiceRole.Tile_size);

        setFill(Color.YELLOWGREEN);
        setStroke(Color.BLACK);


    }
}
