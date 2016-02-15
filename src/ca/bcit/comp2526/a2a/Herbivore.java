package ca.bcit.comp2526.a2a;

import java.awt.Color;

@SuppressWarnings("serial")
public class Herbivore extends Movable {

    public static final double spawnRate = 10;
    
    private static final int defaultMovement = 1;
    private static final Color defaultColor = Color.yellow;
    
    Herbivore(Cell c){
        super(c, defaultColor, defaultMovement);
    }

    @Override
    boolean eatable(Tile t) {
        if (t instanceof EatenByHerbivore)
            return true;
        return false;
    }
    
}
