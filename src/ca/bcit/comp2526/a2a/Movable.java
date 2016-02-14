package ca.bcit.comp2526.a2a;

import java.awt.Color;

@SuppressWarnings("serial")
public abstract class Movable extends Tile {


    private int movement;
    
    Movable(Cell c, Color cl, int m) {
        super(c, cl);
        movement = m;
    }
    
    
    
    public void takeTurn(){
        for(int i=0;i < movement;i++){
            Cell [] adjCells = cell.getAdjecentCells(this);
            moveTo(adjCells[0]);
        }
    }
    
    
    
    private void moveTo(Cell c){
        cell.setTile(new Blank(cell));
        c.setTile(this);
    }
    
    abstract boolean eatable(Tile t);

}
