package tiles;

import java.awt.Color;
import javax.swing.JPanel;
import ca.bcit.comp2526.a2a.Cell;
import ca.bcit.comp2526.a2a.RandomGenerator;

/**
 * Represents a Tile that is displayed on the grid.
 * It has a color and a tile that it is contained by.
 * @author Deric
 * @version 1.0
 */
@SuppressWarnings("serial")
public abstract class Tile extends JPanel{
    
    /* The color of the Tile. */
    private Color color;
    /* The Cell containing this Tile. */
    private Cell cell;

    /**
     * Constructor.
     * @param c the cell containing this tile.
     * @param cl the color of this tile.
     */
    Tile(Cell c, Color cl){
        color = cl;
        cell = c;
        cell.setTile(this);
        init();
    }
    
    /**
     * Sets the background color.
     */
    public void init(){
        setBackground(color);
    }
    
    /**
     * Returns a random shade of color c.
     * @param c Color to retrieve the shade from.
     * @return the new shade of color c.
     */
    public static Color newShade(Color c){
        int red = randRGB(c.getRed(), 50);
        int green = randRGB(c.getGreen(), 50);
        int blue = randRGB(c.getBlue(), 50);
        return new Color(red,green,blue);
    }
    
    /**
     * Returns RGB number altered by a deviation range.
     * @param min the default RGB value.
     * @param deviation the maximum we can randomly alter the RGB value.
     * @return the altered RGB value.
     */
    private static int randRGB(int min, int deviation){
        int rgb = min - deviation + 2*RandomGenerator.nextNumber(deviation);
        if (rgb > 255)
            return 255;
        if (rgb < 0)
            return 0;
        return rgb;
    }
    
    
    
    /**
     * Set the new cell for this tile.
     * @param c the new cell containing this tile.
     */
    public void setCell(Cell c){
        cell = c;
    }
    
    /**
     * Get the cell containing this tile.
     * @return the cell containing this tile.
     */
    public Cell getCell(){
        return cell;
    }
    
    
    
    /**
     * Check if a Tile t can be eaten.
     * @param t the tile to be eaten.
     * @return True if the tile can be eaten, False if not.
     */
    public abstract boolean eat(Tile t);
}
