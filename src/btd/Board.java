package btd;

public class Board {

    /*This Board list of lists of Cells */
    protected Cell[][] board;

    /*This Board cells' size */
    public static final int CELLSIZE = 100;

    /**
     * Build a board of a given size x, y
     * 
     * @param y this board's number of lines
     * @param x this board's number of columns
     */
    public Board(int sizex, int sizey){
        this.board = new Cell[sizey][sizex];
        for(int y = 0; y < sizey; y++){
            for(int x = 0; x < sizex; x++){
                Cell c = new Cell(x, y, cellSize);
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

}
