package ca.bcit.comp2526.a2a;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JComponent;

@SuppressWarnings("serial")
public class Cell extends JComponent{

    private int row;
    
    private int col;
    /* 
     * An array of cells that are next to this cell.
     * Borders are handled by setting the cells that would be there to null.
     */
    private Cell[] adjecent;
    
    
    private Life contains;
    
    Color color;
    
    
    Cell(int r, int c){
        row = r;
        col = c;
        color = Color.gray;
        contains = null;
    }
    
    
    
    
    public void paint(Graphics g) {
        g.setColor(getColor());
        g.fillRect (0, 0, 20, 20);  
    }
    
    /**
     * Sets up the layout????
     */
    public void init(){
        /////////////////////WHAT IS THIS SUPPOSED TO DO???
    }
    
    public Color getColor(){
        if (contains != null){
            return contains.getColor();
        }
        return color;
    }
    
    public Life contains(){
        return contains;
    }
    
    public void moveTo(Life l){
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
