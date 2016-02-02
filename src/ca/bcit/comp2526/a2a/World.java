package ca.bcit.comp2526.a2a;

public class World {
    
    private int rows;
    private int cols;
    
    private Cell[][] cells;
    
    /**
     * builds a new world with a width and height.
     * @param width columns in the world.
     * @param height rows in the world.
     */
    World (int width, int height){
        this.cols = width;
        this.rows = height;
        
        
    }
    
    
    public void init(){
        
    }
    
    
    
    public void getCellAt(){
        
    }
    
    
    
    

    /**
     * returns the number of rows.
     * @return
     */
    public int getRowCount(){
        return rows;
    }
    
    /**
     * returns the number of columns.
     * @return
     */
    public int getColumnCount(){
        return cols;
    }
}



