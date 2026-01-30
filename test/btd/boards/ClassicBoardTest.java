package btd.boards;


import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ClassicBoardTest {

    @Test
    public void TestPathStartAndEnd(){
        Cell c1 = new Cell(5, 0);
        Cell c2 = new Cell(5, 9);
        Board b1 = new ClassicBoard(10, 10);
        List<Cell> l = b1.createPath(c1, c2, new ArrayList<Cell>());
        assertEquals(l.get(0), c1);
        assertEquals(l.get(l.size()-1), c2);
    }
}