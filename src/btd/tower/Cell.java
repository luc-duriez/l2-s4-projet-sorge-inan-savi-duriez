package btd.tower;

public class Cell {
    public static final int SIZE =Board.CELLSIZE;
    private int x;
    private int y;
    private boolean isOccupied;
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
    public void SwitchIsOccupied(){
        this.isOccupied=!this.isOccupied;
    }
    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }
}
