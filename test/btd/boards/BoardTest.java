package btd.boards;

import static org.junit.jupiter.api.Assertions.*; 
import org.junit.jupiter.api.*;

import btd.towers.towers.IceTower;

import java.util.ArrayList;
import java.util.List;


public class BoardTest {
    
    public Board b;

    @BeforeEach
    public void before(){
        Board b = new ClassicBoard(10, 10);
    }

    @Test
    public void testIfNeighborsWorking(){
        
        Cell c1 = new Cell(1, 1);
        Cell c2 = new Cell(0, 0);
        List<Cell> neighbors = new ArrayList<>();
        neighbors.add(b.getCell(0, 1));
        neighbors.add(b.getCell(2, 1));
        neighbors.add(b.getCell(1, 0));
        neighbors.add(b.getCell(1, 2));
        assertEquals(neighbors, b.getNeighbours(c1));
        neighbors = new ArrayList<>();
        neighbors.add(new Cell(1, 0));
        neighbors.add(new Cell(0, 1));
        assertEquals(neighbors, b.getNeighbours(c2));
    }

    @Test
    public void testAddTower(){
        assertEquals(b.getTowers().size(), 0);
        IceTower t = new IceTower(null);
        b.addTower(t);
        assertEquals(b.getTowers().size(), 1);
    }
}
