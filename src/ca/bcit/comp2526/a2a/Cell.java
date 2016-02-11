package ca.bcit.comp2526.a2a;

import java.awt.GridLayout;
import java.awt.Point;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Cell extends JPanel{

    
    private int col;
    private int row;
    
    private World world;
    
    private Tile contains;
    

    
    
    Cell(int r, int c, World w){
        row = r;
        col = c;
        world = w;
        contains = null;
    }
    

    
    
    /**
     * Sets up the layout????
     */
    public void init(){
        setLayout(new GridLayout(0,1));
        //setBorder(BorderFactory.createEmptyBorder(0,10,10,10)); 
    }
    
    
    public Tile contains(){
        return contains;
    }
    
    public void moveTo(Tile l){
        contains = l;
    }
    
    
    public int numberOfAdjecentCells(){
        int sides = 0;
        if(row == 0 || row == world.getRowCount())
            sides++;
        if(col == 0 || col == world.getColumnCount())
            sides++;
        if(sides == 1)
            return 5;
        if(sides == 2)
            return 3;
        return 8;
    }
    
    
    
    public Cell[] getAdjecentCells(){
        Cell[] adjCells = new Cell[numberOfAdjecentCells()];
        int index = 0;
        
        //for every adjacent cell.
        for (int adjCol = row-1; adjCol <= col+1;adjCol++){
            for (int adjRow = col-1; adjRow <= row+1;adjRow++){
                if(!(adjCol < 0 || adjRow < 0 ||
                     adjCol >= world.getColumnCount() || adjRow >= world.getRowCount() || 
                     (adjCol == row && adjRow == col))){
                    //System.out.println("SAVED -- index:"+index+" adjrow:"+adjRow+" adjCol:"+adjCol);
                    adjCells[index] = world.getCellAt(adjCol, adjRow);
                    index++;
                }
            }
        }
        return adjCells;
    }
    

    
    
    
    public Point getLocation(){
        return new Point(col, row);
    }
    
}
