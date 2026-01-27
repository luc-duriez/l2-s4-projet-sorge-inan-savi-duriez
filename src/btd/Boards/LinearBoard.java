package btd.boards;

import btd.*;
import java.util.ArrayList;
import java.util.List;

public class LinearBoard extends Board {
    

    public LinearBoard(int sizex, int sizey){
        super(sizex, sizey);
            this.createPath(new ArrayList<>());
    }


    @Override
    public List<Cell> createPath(Cell curr, Cell finale, List<Cell> list){
        list.add(curr);
        curr.switchIsOccupied();

        if (curr.getX() == finale.getX()) {
            int diffY = finale.getY() - curr.getY();
            int distance = Math.abs(diffY); 
            int step = (diffY > 0) ? 1 : -1; 
            
            for (int i = 1; i < distance; i++) {
                list.add(getCell(curr.getX(), curr.getY() + (i * step)));
                this.getCell(curr.getX() + (i * step), curr.getY()).switchIsOccupied();
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
        
        this.path.add(list);
    }

}
