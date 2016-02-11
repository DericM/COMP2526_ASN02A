package ca.bcit.comp2526.a2a;

import java.awt.Color;

@SuppressWarnings("serial")
public class Plant extends Tile implements EatenByHerbivore {
    
    static private final Color defaultColor = Color.green;
    
    Plant(Cell c){
        super(c, defaultColor);
        
    }

    
}
