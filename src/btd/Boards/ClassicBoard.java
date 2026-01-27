package btd.Boards;

import btd.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ClassicBoard extends Board {
    
    public ClassicBoard(int sizex, int sizey){
        super(sizex, sizey);
        this.createPath(new ArrayList<>());
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
}
