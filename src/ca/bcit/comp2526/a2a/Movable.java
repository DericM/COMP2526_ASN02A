package ca.bcit.comp2526.a2a;

import java.awt.Color;

@SuppressWarnings("serial")
public class Movable extends Tile{


    private int movement;
    
    Movable(Cell c, Color cl, int m) {
        super(c, cl);
        movement = m;
    }
    
    
    void takeTurn(){
    }

}
