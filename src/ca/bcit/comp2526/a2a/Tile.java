package ca.bcit.comp2526.a2a;

import java.awt.Color;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Tile extends JPanel{

    
    private Color color;
    
    protected Cell cell;

    Tile(Cell c, Color cl){
        color = cl;
        setBackground(color);
        cell = c;
        cell.setTile(this);
        cell.add(this);
    }
    
}
