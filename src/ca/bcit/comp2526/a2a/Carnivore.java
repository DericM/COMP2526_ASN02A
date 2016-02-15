package ca.bcit.comp2526.a2a;

import java.awt.Color;

@SuppressWarnings("serial")
public class Carnivore extends Movable{

    static public final double spawnRate = 0.1;
    
    static private final int defaultMovement = 1;
    static private final Color defaultColor = Color.yellow;
    
    Carnivore(Cell c) {
        super(c, defaultColor, defaultMovement);
    }

    @Override
    boolean eatable(Tile t) {
        if (t instanceof EatenByCarnivore)
            return true;
        return false;
    }
    
}
