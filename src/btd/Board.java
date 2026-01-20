package btd;

import java.util.List;
import java.util.ArrayList;

public class Board {

    /*This Board list of lists of Cells */
    protected Cell[][] board;

    /*This Board path for ballons */
    private List<Cell> path;

    /**
     * Build a board of a given size x, y
     * 
     * @param y this board's number of lines
     * @param x this board's number of columns
     */
    public Board(int sizex, int sizey){
        this.board = new Cell[sizey][sizex];
        this.path = new ArrayList<>();
        for(int y = 0; y < sizey; y++){
            for(int x = 0; x < sizex; x++){
                Cell c = new Cell(x, y);
                this.board[y][x] = c;
            }
        }
    }

    /**
     * Return the Cell at the given position of this Board's grid
     * X and Y must be valid.
     * 
     * @param x this Cell's column
     * @param y this Cell's line
     * @return the Cell at the given position of this Board's grid
     */
    public Cell getCell(int x, int y){
        return this.board[y][x];
    }

    /**
     * Return true if the cell at position (y,x) can be used to place a tower.
     * X and Y must be valid.
     * 
     * @param x this Cell's column
     * @param y this Cell's line
     * @return true if the cell at position (y,x) can be used to place a tower.
     */
    public boolean isPlaceable(int x, int y){
        return this.board[y][x].isOccupied();
    }

    /**
     * Create a path for bloons for this board wit a given starting Cell and the final Cell.
     * Doesn't 
     */



    /**
     *  Returns the neighbors of a gives cell
     * @param c The cell to get its neighbors
     * @return The neighbors of the cell
     */
    public List<Cell> getNeighbors(Cell c){
        List<Cell> neighbors = new ArrayList<>();
        int x = c.getX();
        int y = c.getY();
        if(x >= 1){
            neighbors.add(new Cell(x-1, y));
        }
        if(x <= this.board.length-2){
            neighbors.add(new Cell(x+1, y));
        }
        if(y >= 1){
            neighbors.add(new Cell(x, y-1));
        }
        if(y <= this.board[0].length-2){
            neighbors.add(new Cell(x, y+1));
        }
        return neighbors;
    }
    public void show() {
        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board[y].length; x++) {
                Cell c = board[y][x];
                if (path.contains(c)) {
                    System.out.print(" P ");
                } else if (c.isOccupied()) {
                    System.out.print(" T "); 
                } else {
                    System.out.print(" . "); 
                }
            }
            System.out.println();
        }

    }
}
