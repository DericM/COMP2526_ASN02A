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
            
            System.out.println("From:"+cell.getLocation().toString());
            for(Cell c:adjCells)
                System.out.println(c.getLocation().toString());
            System.out.println("To:"+adjCells[0].getLocation().toString()+"\n");
            
            moveTo(adjCells[0]);
        }
    }
    
    
    
    private void moveTo(Cell c){
        
        c.setTile(this);

        new Blank(cell);
        cell = c;
    }
    
    abstract boolean eatable(Tile t);

}
