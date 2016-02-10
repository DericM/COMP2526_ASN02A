package ca.bcit.comp2526.a2a;

import java.util.ArrayList;

public class World {
    
    
    private int cols;
    private int rows;
    
    private Cell[][] cells;
    
    private ArrayList<Tile> life;
    
    
    /**
     * builds a new world with a width and height.
     * @param width columns in the world.
     * @param height rows in the world.
     */
    World (int width, int height){
        cols = width;
        rows = height;
        
        cells = new Cell[cols][rows];
        life = new ArrayList<Tile>();
    }
    
    
    /**
     * Initialize the world
     */
    public void init(){
        initCells();
        setAdjCells();
        makePlants(100);
        makeHerbivores(10);
        
    }
    
    
    /*
     * Instantiates all the cells
     */
    private void initCells(){
        for(int i=0; i < cols;i++){
            for(int j=0; j < rows;j++){
                cells[i][j] = new Cell(i,j);
            }
        }
    }
    
    /*
     * Connects all the cells to their adjacent cells.
     */
    private void setAdjCells(){
        Cell [] adjCells;
        //for every cell in the array
        for(int cellCol=0; cellCol < cols;cellCol++){
            for(int cellRow=0; cellRow < rows;cellRow++){
                
                adjCells = new Cell [9];
                int index = 0;
                
                int outerCol = cellCol - 1;
                int outerRow = cellRow - 1;
                
                
                //for every adjacent cell of each individual cell.
                for (int adjCol=outerRow; adjCol < outerCol+3;adjCol++){
                    for (int adjRow=outerCol; adjRow < outerRow+3;adjRow++){
                        if(!(adjCol < 0 || adjRow < 0 ||
                                adjCol >= rows || adjRow >= cols || 
                                (adjCol == cellRow && adjRow == cellCol))){
                            //System.out.println("SAVED -- index:"+index+" adjrow:"+adjRow+" adjCol:"+adjCol);
                            adjCells[index] = cells[adjCol][adjRow];
                        }
                        
                        else {
                            //System.out.println("OUT BOUNDS -- index:"+index+" adjrow:"+adjRow+" adjCol:"+adjCol);
                            adjCells[index] = null;
                        }
                        index++;
                    }
                }
                cells[cellCol][cellRow].setAdjecent(adjCells);
            }
        }
    }
    
    private void makePlants(int number){
        for(int i=0;i<number;i++){
            Plant p = new Plant();
            life.add(p);
            Cell c = getEmptyCell();
            c.moveTo(p);
        }
    }
    

    private void makeHerbivores(int number){
        for(int i=0;i<number;i++){
            Herbivore h = new Herbivore();
            life.add(h);
            Cell c = getEmptyCell();
            c.moveTo(h);
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
        for(Tile l:life){
            l.takeTurn();
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



