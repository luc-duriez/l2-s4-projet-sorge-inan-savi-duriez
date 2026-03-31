package btd.boards;
import java.util.List;
import java.util.ArrayList;
import btd.towers.towers.*;

/**
 * Create a abstract class Board
 */
public abstract class Board {

    /** This Board list of lists of Cells */
    protected Cell[][] board;

    /** This Board's path(s) for balloons */
    protected List<List<Cell>> path;

    /** This Board's list of towers */
    protected List<Tower> towers;

    public Object isPlaceable;

    /** This board's size */
    public static int sizeBoard;
    
    /**
     * Build a board of a given size x, y
     * 
     * @param sizey this board's number of columns
     * @param sizex this board's num ber of lines
     */
    protected Board(int sizex, int sizey) {
        this.towers = new ArrayList<>();
        this.path = new ArrayList<List<Cell>>();
        this.board = new Cell[sizex][sizey];
        for (int x = 0; x < sizex; x++) {
            for (int y = 0; y < sizey; y++) {
                Cell c = new Cell(x, y);
                this.board[x][y] = c;
            }
        }
        Board.sizeBoard = (sizex + sizey) * Cell.SIZE;
    }

    /**
     * Return the Cell at the given position of this Board's grid
     * X and Y must be valid.
     * 
     * @param x this Cell's line
     * @param y this Cell's column
     * @return the Cell at the given position of this Board's grid
     */
    public Cell getCell(int x, int y) {
        return this.board[x][y];
    }

    /**
     * Returns the neighbors of a gives cell
     * 
     * @param c The cell to get its neighbors
     * @return The neighbors of the cell
     */
    protected List<Cell> getNeighbours(Cell c) {
        List<Cell> neighbors = new ArrayList<>();
        int x = c.getX();
        int y = c.getY();
        if (x >= 1) {
            neighbors.add(this.getCell(x - 1, y));
        }
        if (x <= this.board.length - 2) {
            neighbors.add(this.getCell(x + 1, y));
        }
        if (y >= 1) {
            neighbors.add(this.getCell(x, y - 1));
        }
        if (y <= this.board[0].length - 2) {
            neighbors.add(this.getCell(x, y + 1));
        }
        return neighbors;
    }
    
    /**
     * Return this board's list of tower
     * @return this board's list of tower
     */
    public List<Tower> getTowers() {
        return towers;
    }
   
    /**
     * Return the Board's path
     * @return this Board's path
     */
    public List<List<Cell>> getPath() {
        return this.path;
    }

    /**
     * Return a list of Cell that represent the path for the bloons for this board.
     * curr must be the first cell of the path.
     * 
     * @param curr the current Cell.
     * @param finale the last Cell of the path.
     * @param list the path
     * @return the list of Cell that represent the path. Cell[]
     */
    public abstract List<Cell> createPath(Cell curr, Cell finale, List<Cell> list);
 
    /**
     * Adds a tower to the board
     * @param t the tower to add
     */
    public void addTower(Tower t) {
        towers.add(t);
    }

    /**
     * Return true if the cell at position (x,y) can be used to place a tower.
     * X and Y must be valid.
     * 
     * @param x this Cell's column
     * @param y this Cell's line
     * @return true if the cell at position (x,y) can be used to place a tower.
     */
    public boolean isPlaceable(int x, int y) {
        if ( (0 <= x) && (x < board.length) && (0 <= y) && (y<board[0].length) ){
            return !(this.getCell(x, y).isOccupied());
        }
        return false;
    
    }
   
        /**
     * This function return 2 random Cell in array
     * @param cellAlreadyUsed contains all the cells already used
     * @return Cell[]
     */
    public abstract Cell[] randomCell(List<Cell> cellAlreadyUsed);
    
    /**
     * Count the number of neighbors of a cell that are in a given list
     * @param c the cell we want to know the neighbours
     * @param listCurr the current list
     * @return int
     */
    protected int countPathNeighbors(Cell c, List<Cell> listCurr) {
        int count = 0;
        for (Cell neighbor : getNeighbours(c)) {
            if (listCurr.contains(neighbor)) {
                count++;
            }
        }
        return count;
    }
    /**
     * Show the board
     */
    
    public void displayBoard() {
        System.out.println();
        String strLineSeparator = "   +";
        for (int c = 0; c < this.board[0].length; c++) {
            strLineSeparator += "-----+";
        }

        System.out.print("    "); // Numero en haut
        for (int i = 0; i < this.board[0].length; i++) {
            if (i < 10) {
                System.out.print("  " + i + "   ");
            } else {
                System.out.print("  " + i + "  ");
            }
        }
        System.out.println();

        System.out.println(strLineSeparator);

        for (int j = 0; j < this.board.length; j++) { // Toutes les lignes
            if (j < 10) {
                System.out.print(j + "  |");
            } else {
                System.out.print(j + " |");
            }
            for (int k = 0; k < this.board[0].length; k++) {
                StateCell state = this.board[j][k].getState();
                System.out.print("  " + state + "  |");
            }
            System.out.println();

            System.out.println(strLineSeparator);
        }
    }

    public abstract void removeTower(Tower t);
}
