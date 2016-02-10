package ca.bcit.comp2526.a2a;

@SuppressWarnings("serial")
public abstract class Animal extends Tile{

    int movement;
    
    abstract void move(Cell c);

}
