package ca.bcit.comp2526.a2a;

import java.awt.Color;

@SuppressWarnings("serial")
public class Blank extends Tile {
    
    static private final Color defaultColor = Color.gray;
    
    Blank(Cell c){
        super(c, defaultColor);
    }
}
