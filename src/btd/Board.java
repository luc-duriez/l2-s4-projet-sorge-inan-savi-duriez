package btd;

public class Board {

    /*This Board list of lists of Cells */
    protected Cell[][] grid;

    /*This Board cells' size */
    private static final int cellSize;

    /**
     * Build a board of a given size x, y
     * 
     * @param y this board's number of lines
     * @param x this board's number of columns
     */
    public Board(int sizex, int sizey, int cellSize){
        this.cellSize = cellSize;
        this.grid = new Cell[sizey][sizex];
        for(int y = 0; y < sizey; y++){
            for(int x = 0; x < sizex; x++){
                Cell c = new Cell(x, y, cellSize);
                this.grid[y][x] = c;
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
        return this.grid[y][x];
    }

}
