package btd;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;


public class BoardTest {
    private Board b1;

    @BeforeEach
    public void before(){
        Board b1 = new Board(10, 10);
    }

    @Test
    public void testIfAllNeighborsAreReturned(){
        Cell c1 = new Cell(1, 1);
        List<Cell> neighbors = new ArrayList<>();
        neighbors.add(new Cell(1, 0));
        neighbors.add(new Cell(0, 1));
        neighbors.add(new Cell(1, 2));
        neighbors.add(new Cell(2, 1));
        assertEquals(neighbors, this.b1.getNeighbors(c1));
    }
}
