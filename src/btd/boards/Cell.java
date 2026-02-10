package btd.boards;

import java.util.Stack;

public class Cell {
    /* The size of a cell */
    public static final int SIZE = 100; 
    private int x;
    private int y;
    private boolean isOccupied;
    private Stack<StateCell> state;

    /**
     * Constructor of Cell class
     * @param x the abscisse
     * @param y the ordone
     */
    public Cell(int x,int y){
        this.x=x;
        this.y=y;
        this.isOccupied=false;
        this.state.push(StateCell.EMPTY);
    }

    /**
     * This function return true if cell is occupied, false otherwise
     * @return boolean
     */
    public boolean isOccupied(){
        return this.isOccupied;
    }

    /**
     * This function switch the isOccupied value
     */
    public void switchIsOccupied(){
        this.isOccupied=!this.isOccupied;
    }

    /**
     * Return the position x
     * @return int x 
     */
    public int getX(){
        return this.x;
    }

    /**
     * Return the position y
     * @return int y
     */
    public int getY(){
        return this.y;
    }

    /**
     * Return true if the object is a Cell
     * @return boolean
     */
    public boolean equals(Object o){
        if(!(o instanceof Cell)){
            return false;
        }
        Cell c = (Cell) o;
        return this.x == c.getX() && this.y == c.getY();
    }

    /**
     * Return a String representation of this Cell
     */
    public String toString(){
        return "(" + this.x + ", " + this.y + ")";
    }

    /**
     * Set this cell's state to newState.
     * 
     * @param newState this cell's new state
     */
    public void setState(StateCell newState){
        this.state.push(newState);
    }
    /**
     * Remove the first state of this state.
     */
    public void popState(){
        this.state.pop();
    }

    /**
     * Return this cell's state
     * 
     * @return this cell's state
     */
    public StateCell getState(){
        return this.state.peek();
    }
}
