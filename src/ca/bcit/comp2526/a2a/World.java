package ca.bcit.comp2526.a2a;

import java.util.ArrayList;

public class World {
    
    private final int numberOfPlants = 100;
    private final int numberOfHerbivores = 10;
    
    
    private int cols;
    private int rows;
    
    private Cell[][] cells;
    
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
     * Initialize the world
     */
    public void init(){
        initCells();
        makePlants(numberOfPlants);
        makeHerbivores(numberOfHerbivores);
    }
    
    
    /*
     * Instantiates all the cells
     */
    private void initCells(){
        for(int i=0; i < cols;i++){
            for(int j=0; j < rows;j++){
                cells[i][j] = new Cell(i, j, this);
            }
        }
    }
    

    
    private void makePlants(int number){
        for(int i=0;i<number;i++){
            new Plant(getEmptyCell());
        }
    }
    

    private void makeHerbivores(int number){
        for(int i=0;i<number;i++){
            moveable.add(new Herbivore(getEmptyCell()));
        }
    }
    
    
    private Cell getEmptyCell(){
        Cell c;
        do {
            c = cells[RandomGenerator.nextNumber(25)]
                      [RandomGenerator.nextNumber(25)];
        } while(c.contains() != null);
        return c;
    }
    
    
    
    
    /**
     * Returns a cell at a specified row and column.
     * @param row to return.
     * @param col to return.
     * @return the cell at the specified location.
     */
    public Cell getCellAt(int col, int row){
        return cells[col][row];
    }
    
    
    /**
     * Takes a turn for every Life form.
     */
    public void takeTurn(){
        for(Movable m:moveable){
            m.takeTurn();
        }
    }
    
    
    

    /**
     * returns the number of rows.
     * @return rows
     */
    public int getRowCount(){
        return rows;
    }
    
    /**
     * returns the number of columns.
     * @return cols
     */
    public int getColumnCount(){
        return cols;
    }
}



