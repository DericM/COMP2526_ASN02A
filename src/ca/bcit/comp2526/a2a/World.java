package ca.bcit.comp2526.a2a;

import java.util.ArrayList;

import tiles.Carnivore;
import tiles.Herbivore;
import tiles.Movable;
import tiles.Plant;

/**
 * Represents a World that contains a grid of Cells.
 * Contains a list of movable tiles that are in the Cells on the grid.
 * Contains cols and rows which represent the size of the grid.
 * @author Deric
 * @version 1.0
 */
public class World {
    
    /* The number of columns in the grid */
    private int cols;
    /* The number of rows in the grid */
    private int rows;
    /* A grid of cells that can contain tiles. */
    private Cell[][] cells;
    /* A List of movable tiles contained by cells in the grid. */
    private ArrayList<Movable> moveable;
    
    
    /**
     * builds a new world with a width and height.
     * @param width columns in the world.
     * @param height rows in the world.
     */
    World (int width, int height){
        cols = width;
        rows = height;
        cells = new Cell[cols][rows];
        moveable = new ArrayList<Movable>();
    }
    
    
    /**
     * Initialize the world, creates cells, spawns Tiles.
     */
    public void init(){
        Cell c;
        for(int i=0; i < cols;i++){
            for(int j=0; j < rows;j++){
                c = new Cell(i, j, this);
                cells[i][j] = c;
                c.init();
                spawn(c);
            }
        }
    }
    
    
    /*
     * Spawns a Random tile.
     * See SpawnType for spawn rates.
     * @param c the cell in which to spawn the tile.
     */
    private void spawn(Cell c){
        switch (SpawnType.spawn()) {
        case PLANT:
            new Plant(c);
            break;
        case HERBIVORE:
            moveable.add(new Herbivore(c));
            break;   
        case CARNIVORE:
            moveable.add(new Carnivore(c));
            break;
        default:
            break;//blank
        }
    }
    
    /*
     * Gets all the empty cells and pick one at random.
     * @return the random empty cell.
     */
    private Cell getRandomEmptyCell(){
        ArrayList<Cell> empty  = new ArrayList<Cell>();
        Cell c;
        for(int i=0; i < cols;i++){
            for(int j=0; j < rows;j++){
                c = cells[i][j];
                if (c.getTile()==null)
                    empty.add(c);
            }
        }
        return empty.get(RandomGenerator.nextNumber(empty.size()));
    }
    
    
    
    
    /**
     * Returns a cell at a specified row and column.
     * @param col to return.
     * @param row to return.
     * @return the cell at the specified location.
     */
    public Cell getCellAt(int col, int row){
        return cells[col][row];
    }
    
    
    /**
     * Takes a turn for every movable, if the movable dosn't move,
     * then we remove it from the movable list.
     */
    public void takeTurn(){
        Movable m;
        for(int i = 0;i < moveable.size();i++ ){
            m = moveable.get(i);
            if(m == null || !m.takeTurn()) 
                moveable.remove(i);
        }
        spawn(getRandomEmptyCell());
    }
    
    
    
    /**
     * returns the number of rows.
     * @return the number of rows in the grid.
     */
    public int getRowCount(){
        return rows;
    }
    
    /**
     * returns the number of columns.
     * @return the number of cols in the grid.
     */
    public int getColumnCount(){
        return cols;
    }
}



