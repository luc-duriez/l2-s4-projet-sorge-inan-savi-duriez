package btd.boards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import btd.towers.Tower;

/** A classic board with random path generation */
public class ClassicBoard extends Board {

    /** Creates a classic board */
    public ClassicBoard(int sizex, int sizey) {
        super(sizex, sizey);
        Cell[] cells = this.randomCell(new ArrayList<>());
        this.path.add(this.createPath(cells[0], cells[1], new ArrayList<>()));
        cells[0].setState(StateCell.PATH);
        for (List<Cell> tempPath : this.getPath()) {
            for (Cell cell : tempPath) {
                cell.switchIsOccupied();
                cell.setState(StateCell.PATH);
            }
        }
    }

    @Override
    public List<Cell> createPath(Cell curr, Cell finale, List<Cell> list) {
        list.add(curr);
        if (curr.equals(finale))
            return list;
        List<Cell> neighbor = this.getNeighbours(curr);
        Collections.shuffle(neighbor);
        for (Cell next : neighbor) {
            if (!(list.contains(next)) && (super.countPathNeighbors(next, list) == 1)) {
                List<Cell> result = createPath(next, finale, list);
                if (result != null)
                    return result;
            }
        }
        list.remove(curr);
        return null;
    }
    @Override
    public Cell[] randomCell(List<Cell> cellAlreadyUsed) {
        Random r = new Random();
        int x1 = r.nextInt(this.board.length);
        int x2 = r.nextInt(this.board.length);
        Cell[] cells = new Cell[2];
        cells[0] = this.getCell(x1, 0);
        cells[1] = this.getCell(x2, this.board[0].length - 1);
        return cells;
    }
    @Override
    public void addTower(Tower t) {
        towers.add(t);
        this.getCell(t.getCell().getX(), t.getCell().getY()).switchIsOccupied();
    }
}
