package btd;
    
import org.junit.jupiter.api.*;

import btd.boards.ClassicBoard;

import static org.junit.jupiter.api.Assertions.*;
import java.util.*;


public class BoardTest {
    private Board b1;

    @BeforeEach
    public void before(){
        this.b1 = new ClassicBoard(10, 10);
    }

    @Test
    public void testIfNeighborsWorking(){
        Cell c1 = new Cell(1, 1);
        Cell c2 = new Cell(0, 0);
        List<Cell> neighbors = new ArrayList<>();
        neighbors.add(this.b1.getCell(0, 1));
        neighbors.add(this.b1.getCell(2, 1));
        neighbors.add(this.b1.getCell(1, 0));
        neighbors.add(this.b1.getCell(1, 2));
        assertEquals(neighbors, this.b1.getNeighbors(c1));
        neighbors = new ArrayList<>();
        neighbors.add(new Cell(1, 0));
        neighbors.add(new Cell(0, 1));
        assertEquals(neighbors, this.b1.getNeighbors(c2));
    }
}
