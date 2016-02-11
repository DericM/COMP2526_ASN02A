package ca.bcit.comp2526.a2a;

import java.awt.Color;

@SuppressWarnings("serial")
public class Herbivore extends Movable {

    static private final int defaultMovement = 1;
    static private final Color defaultColor = Color.yellow;
    
    Herbivore(Cell c){
        super(c, defaultColor, defaultMovement);
    }
    
}
