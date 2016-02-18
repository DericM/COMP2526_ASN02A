package tiles;

import java.awt.Color;
import ca.bcit.comp2526.a2a.Cell;
import interfaces.EatenByCarnivore;
import interfaces.EatenByHerbivore;

@SuppressWarnings("serial")
public class Herbivore extends Movable implements EatenByCarnivore {

    /** The default movements. */
    private static final int defaultMovement = 5;
    /** Randomly generated shade of yellow. */
    private static final Color defaultColor = Color.yellow;
    
    /**
     * Constructor.
     * @param c the cell to place this herbivore.
     */
    public Herbivore(Cell c){
        super(c, newShade(defaultColor), defaultMovement);
    }
    

    /**
     * Returns true if this tile can eat t.
     * @param t the tile to be eaten.
     */
    @Override
    public boolean eat(Tile t) {
        if (t instanceof EatenByHerbivore)
            return true;
        return false;
    }
}