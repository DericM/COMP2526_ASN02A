package ca.bcit.comp2526.a2a;

import java.awt.Color;

@SuppressWarnings("serial")
public class Plant extends Tile implements EatenByHerbivore {
    
    public static final int spawnRate = 30;
    
    private static final Color defaultColor = Color.green;
    
    Plant(Cell c){
        super(c, defaultColor);
    }

}
