package ca.bcit.comp2526.a2a;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Point;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

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
     * @param r row of the cell in the world.
     * @param c column of the cell in the world.
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
    public void init(){
     
        setLayout(new GridLayout(1,1));
        setBorder(BorderFactory.createLineBorder(Color.black)); 
    }
    
    

    
    
    /**
     * returns the number of adjacent tiles.
     * @return integer of adjacent tiles.
     */
    public int numberOfAdjecentCells(){
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
    
    
    
    
    public Cell[] getAdjecentCells(){
        Cell[] adjCells = new Cell[numberOfAdjecentCells()];
        int index = 0;
        
        //for every adjacent cell.
        for (int adjCol = col-1; adjCol <= col+1;adjCol++){
            for (int adjRow = row-1; adjRow <= row+1;adjRow++){
                if(cellExists(adjCol, adjRow)){   
                    adjCells[index++] = world.getCellAt(adjCol, adjRow);
                }
            }
        }
        return adjCells;
    }
    
    
    
    

    public Cell[] getAdjecentCells(Movable m){ 
        Cell[] adjCells = getAdjecentCells();
        Cell[] adjEatableFirst = new Cell[adjCells.length];
        int startIndex = 0;
        int endIndex = adjCells.length-1;
        
        for(int i=0;i < adjCells.length;i++){
            if(m.eatable(adjCells[i].getTile()))
                adjEatableFirst[startIndex++] = adjCells[i];
            else 
                adjEatableFirst[endIndex--] = adjCells[i];
        }

        return adjEatableFirst;
    }
    
    
    
    /**
     * Check if cell at given coordinates is in the world
     * and is not the current cell.
     * @param col
     * @param row
     * @return True if cell exists, false if not.
     */
    private boolean cellExists (int col, int row){
        return  
               !(     col <  0 
                  ||  row <  0 
                  ||  col >= world.getColumnCount() 
                  ||  row >= world.getRowCount() 
                  || (col == this.col  &&  row == this.row)
                );
    }
    
    
    public Tile getTile(){
        return tile;
    }
    
    public void setTile(Tile t){
        if(tile != null)
            remove(tile);
        tile = t;
        add(tile);
    }
    
    
    
    public Point getLocation(){
        return new Point(col, row);
    }
    
}
