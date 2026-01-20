package btd;

public class Cell {
    public static final int SIZE = 100;
    private int x;
    private int y;
    private boolean isOccupied;
    /**
     * Constructor of Cell class
     * @param x
     * @param y
     */
    public Cell(int x,int y){
        this.x=x;
        this.y=y;
        this.isOccupied=false;
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
     * return void
     */
    public void SwitchIsOccupied(){
        this.isOccupied=!this.isOccupied;
    }
    /**
     * Getters x position.
     * @return int x 
     */
    public int getX(){
        return this.x;
    }
    /**
     * Getters y position.
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
}
