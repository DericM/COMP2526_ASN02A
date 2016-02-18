package ca.bcit.comp2526.a2a;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Point;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

import tiles.Tile;

/**
 * Represents a Cell that is part of a grid in the world.
 * It has column and a row that determines its position on the grid.
 * It contains a reference to the world it is a part of.
 * It can contain a tile.
 * @author Deric
 * @version 1.0
 */
@SuppressWarnings("serial")
public class Cell extends JPanel{

    /** Cell column in the world.*/
    private int col;
    /** Cell row in the world.*/
    private int row;
    /** The world containing the cell.*/
    private World world;
    /** The tile contained in the cell. */
    private Tile tile;
    
    
    /**
     * Construct a new cell.
     * @param c column of the cell in the world.
     * @param r row of the cell in the world.
     * @param w world containing the cell
     */
    Cell(int c, int r, World w){
        col = c;
        row = r;
        world = w;
        tile = null;
    }
    

    /**
     * Sets up the layout and border of each cell.
     */
    public void init() {
        setLayout(new GridLayout(1,1));
        setBorder(BorderFactory.createLineBorder(Color.black)); 
    }
    
    
    
    
    /**
     * Returns the most desirable adjacent cell.
     * @return the most desirable cell.
     */
    public Cell targetCell() {
        ArrayList<Cell> prey  = new ArrayList<Cell>();
        ArrayList<Cell> pred  = new ArrayList<Cell>();
        ArrayList<Cell> blank = new ArrayList<Cell>();
        ArrayList<Cell> mate  = new ArrayList<Cell>();
        ArrayList<Cell> adj;
        
        adj = getAdjecentCells();

        for(Cell c:adj){
            if (c.getTile() == null)
                blank.add(c);
            else if (c.tileCanEat(tile))
                pred.add(c);
            else if (tileCanEat(c.getTile()))
                prey.add(c);
            else 
                mate.add(c);
        }
        
        if (prey.size() != 0)
            return pickCell(prey);
        if (blank.size() != 0)
            return pickCell(blank);

        return null;
    }
    
    
    /*
     * Returns a list of adjacent tiles.
     * @return a list of the adjacent tiles.
     */
    private ArrayList<Cell> getAdjecentCells(){
        ArrayList<Cell> adj  = new ArrayList<Cell>();
        Cell c;
        
        for (int adjCol = col-1; adjCol <= col+1;adjCol++) {
            for (int adjRow = row-1; adjRow <= row+1;adjRow++) {
                if(cellExists(adjCol, adjRow)) {
                    c = world.getCellAt(adjCol, adjRow);
                    adj.add(c);
                }
            }
        }
        return adj;
    }
    
    
    /*
     * Pick a random cell from a list of cells.
     * @param cells the list to chose from.
     * @return the chosen cell.
     */
    private Cell pickCell(ArrayList<Cell> cells){
        if(cells==null)
            return null;
        return cells.get(RandomGenerator.nextNumber(cells.size()));
    }
    
    
    /*
     * Returns the number of adjacent tiles.
     * @return integer of adjacent tiles.
     */
/*    private int numberOfAdjecentCells(){
        int sides = 0;
        if(row == 0 || row == world.getRowCount()-1)
            sides++;
        if(col == 0 || col == world.getColumnCount()-1)
            sides++;
        if(sides == 0)
            return 8;
        if(sides == 1)
            return 5;
        return 3;
    }
*/    
    
    /*
     * Check if cell at given coordinates is in the world
     * and is not the current cell.
     * @param row
     * @param col
     * @return True if cell exists, false if not.
     */
    private boolean cellExists (int col, int row){
        return  
            !(    col <  0 
              ||  row <  0 
              ||  col >= world.getRowCount() 
              ||  row >= world.getColumnCount() 
              || (col == this.col  &&  row == this.row)
            );
    }
    

    
    /**
     * Return true if t can be eaten this cells tile.
     * @param t the tile that will get eaten.
     * @return True if it can be eaten, False if not.
     */
    public boolean tileCanEat(Tile t){
        if(tile == null)
            return false;
        return tile.eat(t);
    }
    
    
    /**
     * Returns the cells tile.
     * @return the cells tile.
     */
    public Tile getTile(){
        return tile;
    }
    
    /**
     * Set the cells tile, and add it to the JPanel.
     * @param t the new tile to be set.
     */
    public void setTile(Tile t){
        removeAll();
        tile = t;
        if (tile != null)
            add(tile);
    }
    
    
    /**
     * Returns a Point with the coordinates of the cell.
     * @Return a Point with the coordinates of the cell.
     */
    public Point getLocation(){
        return new Point(col, row);
    }
    
}
