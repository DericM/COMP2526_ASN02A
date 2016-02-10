package ca.bcit.comp2526.a2a;

import java.awt.Color;
import java.awt.Point;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Cell extends JPanel{

    private int row;
    
    private int col;
    /* 
     * An array of cells that are next to this cell.
     * Borders are handled by setting the cells that would be there to null.
     */
    private Cell[] adjecent;
    
    
    private Tile contains;
    
    Color color;
    
    
    Cell(int r, int c){
        row = r;
        col = c;
        color = Color.gray;
        contains = null;
    }
    
    
    
    /**
     * Sets up the layout????
     */
    public void init(){
        setBackground(Color.red);
    }
    
    public Color getColor(){
        if (contains != null){
            return contains.getColor();
        }
        return color;
    }
    
    public Tile contains(){
        return contains;
    }
    
    public void moveTo(Tile l){
        contains = l;
    }
    
    public Cell[] getAdjecent(){
        return adjecent;
    }
    
    public void setAdjecent(Cell[] cells){
        adjecent = cells;
    }
    
    public Point getLocation(){
        return new Point(col, row);
    }
    
}
