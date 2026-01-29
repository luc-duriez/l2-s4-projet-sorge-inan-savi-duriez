package btd.boards;

import btd.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LinearBoard extends Board {
    

    public LinearBoard(int sizex, int sizey, int numberPath){
        super(sizex, sizey);
        List<Cell> cellAlreadyUsed = new ArrayList<>();
        for (int i=0; i < numberPath; i++){
            Cell[] cells = this.randomCell(cellAlreadyUsed);
            cellAlreadyUsed.add(cells[0]);
            cellAlreadyUsed.add(cells[1]);
            this.path.add(this.createPath(cells[0],cells[1],new ArrayList<>()));
        }
        for (List<Cell> tempPath : this.path){ 
            for (Cell cell : tempPath){
                cell.setState(StateCell.PATH);
            }
        }
    }


    @Override
    public List<Cell> createPath(Cell curr, Cell finale, List<Cell> list) throws IllegalArgumentException {
        if (curr.getX() != finale.getX() && curr.getY() != finale.getY()) {
            throw new IllegalArgumentException("Les cellules doivent être alignées horizontalement ou verticalement."); 
        }
        list.add(curr);
        curr.switchIsOccupied();

        if (curr.getX() == finale.getX()) {
            int diffY = finale.getY() - curr.getY();
            int distance = Math.abs(diffY); 
            int step = (diffY > 0) ? 1 : -1; 
            
            for (int i = 1; i < distance; i++) {
                list.add(getCell(curr.getX(), curr.getY() + (i * step)));
                this.getCell(curr.getX(), curr.getY() + (i * step)).switchIsOccupied();
            }
        } 
        else {
            int diffX = finale.getX() - curr.getX();
            int distance = Math.abs(diffX);
            int step = (diffX > 0) ? 1 : -1;

            for (int i = 1; i < distance; i++) {
                list.add(getCell(curr.getX() + (i * step), curr.getY()));
                this.getCell(curr.getX() + (i * step), curr.getY()).switchIsOccupied();
            }
        }

        if (!curr.equals(finale)) {
            list.add(finale);
            finale.switchIsOccupied();
        }
        
        return list;
    }

    /** Return two random cells from the array that are not used for path.
     * @return Cell[] 
    */
    @Override
    public Cell[] randomCell(List<Cell> cellAlreadyUsed){
        Cell[] cells= new Cell[2];
        Random r = new Random();
        int i = r.nextInt(2);
        Cell c1;
        Cell c2;
        if (i == 1){ // Verticale
            int index = r.nextInt(this.board[0].length);
            if (cellAlreadyUsed.contains(this.board[0][index]) || cellAlreadyUsed.contains(this.board[this.board.length-1][index])){
                return randomCell(cellAlreadyUsed);
            }
            c1 = this.board[0][index]; 
            c2 = this.board[this.board.length-1][index];           
        }
        else{ // Horizontale
            int index = r.nextInt(this.board.length);
            if (cellAlreadyUsed.contains(this.board[index][0]) || cellAlreadyUsed.contains(this.board[index][this.board[0].length-1])){
                return randomCell(cellAlreadyUsed);
            }
            c1 = this.board[index][0];
            c2 = this.board[index][this.board[0].length-1]; 
        }
        i = r.nextInt(2);
        cells[i] = c1;
        cells[1-i] = c2;
        return cells;
    }
    
}
