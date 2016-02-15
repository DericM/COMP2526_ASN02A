package ca.bcit.comp2526.a2a;

import java.util.ArrayList;

public class World {
    
    
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
        for(int i=0; i < cols;i++){
            for(int j=0; j < rows;j++){
                
                cells[i][j] = new Cell(i, j, this);
                cells[i][j].init();
                
                switch (SpawnType.spawn()) {
                case PLANT:
                    new Plant(cells[i][j]);
                    break;
                case HERBIVORE:
                    moveable.add(new Herbivore(cells[i][j]));
                    break;   
                case CARNIVORE:
                    moveable.add(new Carnivore(cells[i][j]));
                    break;
                default:
                    new Blank(cells[i][j]);
                    break;
                }
            }
        }
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
        System.out.println("take turn");
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



