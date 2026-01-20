package btd;

import java.util.ArrayList;
import java.util.List;

public class LinearBoard extends Board {
    private List<List<Cell>> listPath;

    public LinearBoard(int sizex, int sizey){
    super(sizex, sizey);
    this.listPath = new ArrayList<>(); 
    List<Cell> p = this.createPath(getCell(0, 0), getCell(19, 0), new ArrayList<>());
    this.path = p; 
    this.listPath.add(p);
}


    @Override
    public List<Cell> createPath(Cell curr, Cell finale, List<Cell> list){
        list.add(curr);

        if (curr.getX() == finale.getX()) {
            int diffY = finale.getY() - curr.getY();
            int distance = Math.abs(diffY); 
            int step = (diffY > 0) ? 1 : -1; 
            for (int i = 1; i < distance; i++) {
                list.add(getCell(curr.getX(), curr.getY() + (i * step)));
            }
        } 
        else {
            int diffX = finale.getX() - curr.getX();
            int distance = Math.abs(diffX);
            int step = (diffX > 0) ? 1 : -1;

            for (int i = 1; i < distance; i++) {
                list.add(getCell(curr.getX() + (i * step), curr.getY()));
            }
        }

        if (!curr.equals(finale)) {
            list.add(finale);
        }
        
        return list;
    }

}
