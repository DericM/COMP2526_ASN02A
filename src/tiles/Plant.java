package tiles;

import java.awt.Color;
import ca.bcit.comp2526.a2a.Cell;
import interfaces.EatenByHerbivore;

@SuppressWarnings("serial")
public class Plant extends Tile implements EatenByHerbivore {
    
    /** Randomly generated shade of green. */
    private static final Color defaultColor = Color.green;
    
    /**
     * Constructor.
     * @param c the cell to place the plant.
     */
    public Plant(Cell c){
        super(c, newShade(defaultColor));
    }

    /**
     * Returns true if this tile can eat t.
     * @param t the tile to be eaten.
     */
    @Override
    public boolean eat(Tile t) {
        return false;
    }

}
