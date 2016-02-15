package ca.bcit.comp2526.a2a;

import java.awt.Color;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public abstract class Tile extends JPanel{
    
    private Color color;
    
    protected Cell cell;

    Tile(Cell c, Color cl){
        color = cl;
        setBackground(color);
        cell = c;
        cell.setTile(this);
    }

    
    
    
    
    public static boolean spawn(int rate, int spawnMin, int spawnMax){
        System.out.println("Spawnmin: " + spawnMin + "SpawnMax: " + spawnMax);
        if(rate >= spawnMin && rate <= spawnMax)
            return true;
        return false;
    }
    
}
