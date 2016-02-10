package ca.bcit.comp2526.a2a;

import java.awt.Color;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public abstract class Tile extends JPanel{

    
    Color color;

    
    public Color getColor(){
        return color;
    }
    
    public void setColor(){
        setBackground(color);
    }
    
    public void takeTurn(){
        
    }
    
}
