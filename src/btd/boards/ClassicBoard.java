package btd.boards;

import btd.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ClassicBoard extends Board {
    
    public ClassicBoard(int sizex, int sizey){
        super(sizex, sizey);
        this.createPath(new ArrayList<>());
    }


    @Override
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
