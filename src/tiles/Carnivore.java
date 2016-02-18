package tiles;

import java.awt.Color;
import ca.bcit.comp2526.a2a.Cell;
import interfaces.EatenByCarnivore;

@SuppressWarnings("serial")
public class Carnivore extends Movable{

    /** The default movements. */
    static private final int defaultMovement = 5;
    /** Randomly generated shade of yellow. */
    static private final Color defaultColor = Color.red;
    
    /**
     * Constructor.
     * @param c
     */
    public Carnivore(Cell c) {
        super(c, newShade(defaultColor), defaultMovement);
    }

    /**
     * Returns true if this tile can eat t.
     * @param t the tile to be eaten.
     */
    @Override
    public boolean eat(Tile t) {
        if (t instanceof EatenByCarnivore)
            return true;
        return false;
    }
    
}
