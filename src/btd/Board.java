package btd;

import java.util.*;


public abstract class Board {

    /*This Board list of lists of Cells */
    protected Cell[][] board;

    /*This Board path for ballons */
    protected List<List<Cell>> path;

    /**
     * Build a board of a given size x, y
     * 
     * @param y this board's number of columns
     * @param x this board's number of lines
     */
    public Board(int sizex, int sizey){
        this.path= new ArrayList<List<Cell>>();
        this.board = new Cell[sizex][sizey];
        for(int x = 0; x < sizex; x++){
            for(int y = 0; y < sizey; y++){
                Cell c = new Cell(x, y);
                this.board[x][y] = c;
            }
        }
    }

    /**
     * Return the Cell at the given position of this Board's grid
     * X and Y must be valid.
     * 
     * @param x this Cell's line
     * @param y this Cell's column
     * @return the Cell at the given position of this Board's grid
     */
    public Cell getCell(int x, int y){
        return this.board[x][y];
    }

    /**
     * Return true if the cell at position (x,y) can be used to place a tower.
     * X and Y must be valid.
     * 
     * @param x this Cell's column
     * @param y this Cell's line
     * @return true if the cell at position (x,y) can be used to place a tower.
     */
    public boolean isPlaceable(int x, int y){
        return this.board[x][y].isOccupied();
    }
    
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
    /**
     * Show the board
     */
    public void show() {
        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board[y].length; x++) {
                Cell c = board[y][x];
                if (this.path.get(0).contains(c)) {
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

    /**
     * Return a list of Cell that represent the path for the bloons for this board.
     * curr must be the first cell of the path.
     * 
     * @param curr the current Cell.
     * @param finale the last Cell of the path.
     * @param list the path
     * @return the list of Cell that represent the path.
     */
    public List<Cell> createPath(Cell curr, Cell finale, List<Cell> list){
        list.add(curr);
        if (curr.equals(finale)) return list;
        List<Cell> neighbor = this.getNeighbors(curr);
        Collections.shuffle(neighbor);
        for(Cell next: neighbor){
            if (!(list.contains(next)) && (countPathNeighbors(next, list) == 1)){
                List<Cell> result = createPath(next, finale, list);
                if (result != null) return result;  
            }
        }
        list.remove(curr);
        return null;
    }
    
    /**
     * Count the number of neighbors of a cell that are in a given list
     * @param c
     * @param listCurr
     * @return int
     */
    private int countPathNeighbors(Cell c, List<Cell> listCurr) {
        int count = 0;
        for (Cell neighbor : getNeighbors(c)) {
            if (listCurr.contains(neighbor)) {
                count++;
            }
        }
        return count;
    }

    /**
     * Return the Board's path
     * 
     * @return this Board's path
     */
    public List<Cell> getPath(){
        return this.path.get(0);
    }
    /**
     * Spawn the balloons for a given round
     * @param round
     * @return List<Balloon> the list of balloons spawned this round
     */
    public List<Balloon> spawnRoundBalloons(int round) {
        List<Balloon> activeBalloons = new ArrayList<>();

        int count = 3 + (round * 3); 
        double speed = 1.0 + (round * 0.1); 
        int health = 1 + (round / 5);

        for (int i = 0; i < count; i++) {
            activeBalloons.add(new Balloon(health, speed, this.path.get(0)));
        }

        return activeBalloons;
    }
}
