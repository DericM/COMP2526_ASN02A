package ca.bcit.comp2526.a2a;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Point;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Cell extends JPanel{

    
    private int col;
    private int row;
    
    private World world;
    
    private Tile tile;
    

    
    
    Cell(int r, int c, World w){
        row = r;
        col = c;
        world = w;
        tile = null;
    }
    

    
    
    /**
     * Sets up the layout????
     */
    public void init(){
     
        setLayout(new GridLayout(1,1));
        setBorder(BorderFactory.createLineBorder(Color.black)); 
    }
    
    
    public Tile getTile(){
        return tile;
    }
   
    
    
    public void setTile(Tile t){
        tile = t;
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
                if(cellInBounds(adjCol, adjRow)){
                    adjCells[index] = world.getCellAt(adjCol, adjRow);
                    index++;
                }
            }
        }
        return adjCells;
    }
    

    public Cell[] getAdjecentCells(Movable m){
        
        
        Cell[] adjCells = getAdjecentCells();
        Cell[] adjEatableFirst = new Cell[adjCells.length];
        int startIndex = 0;
        int endIndex = adjCells.length;
        for(int i=0;i<adjCells.length;i++){
            if(m.eatable(adjCells[i].getTile())){
                adjEatableFirst[startIndex++] = adjCells[i];
            } else {
                adjEatableFirst[endIndex++] = adjCells[i];
            }
        }

        return adjEatableFirst;
    }
    
    private boolean cellInBounds(int adjCol, int adjRow){
        return  
            !   ( adjCol <  0 
              ||  adjRow <  0 
              ||  adjCol >= world.getColumnCount() 
              ||  adjRow >= world.getRowCount() 
              || (adjCol == row  &&  adjRow == col)
                );
    }
    
    public Point getLocation(){
        return new Point(col, row);
    }
    
}
