package btd.boards;

import btd.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class ClassicBoard extends Board {
    
    public ClassicBoard(int sizex, int sizey) {
        super(sizex, sizey);
        Cell[] cells = this.randomCell();
        this.createPath(cells[0],cells[1],new ArrayList<>());
    }
    
    @Override
    public List<Cell> createPath(Cell curr, Cell finale, List<Cell> list){
        list.add(curr);
        if (curr.equals(finale)) return list;
        List<Cell> neighbor = this.getNeighbors(curr);
        Collections.shuffle(neighbor);
        for(Cell next: neighbor){
            if (!(list.contains(next)) && (super.countPathNeighbors(next, list) == 1)){
                List<Cell> result = createPath(next, finale, list);
                if (result != null) return result;  
            }
        }
        list.remove(curr);
        return null;
    }
    @Override
    public Cell[] randomCell(){
        Random r= new Random();
        int x1 = r.nextInt(this.board.length);
        int x2 = r.nextInt(this.board.length);
        Cell[] cells = new Cell[2];
        cells[0] = new Cell(x1, 0);
        cells[1] = new Cell(x2, this.board.length-1); 
    }
}
