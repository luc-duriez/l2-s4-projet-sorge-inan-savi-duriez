package btd.boards;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import java.util.List;
import btd.towers.IceTower;
import btd.towers.Tower;

public class ClassicBoardTest {

    private Board board;

    @BeforeEach
    public void before() {
        board = new ClassicBoard(10, 10);
    }

    @Test
    public void isPlaceableTest() {
        
        assertTrue(board.isPlaceable(2, 2));

        Tower t = new IceTower(board.getCell(2, 2));
        board.addTower(t);

        assertFalse(board.isPlaceable(2, 2));
    }

    @Test
    public void testIfNeighborsWorking() {
        Cell c1 = board.getCell(1, 1);
        Cell c2 = board.getCell(0, 0);

        List<Cell> neighbours = board.getNeighbours(c1);
        assertEquals(4, neighbours.size());
        assertTrue(neighbours.contains(board.getCell(0, 1)));
        assertTrue(neighbours.contains(board.getCell(2, 1)));
        assertTrue(neighbours.contains(board.getCell(1, 0)));
        assertTrue(neighbours.contains(board.getCell(1, 2)));

        List<Cell> neighbours2 = board.getNeighbours(c2);
        assertEquals(2, neighbours2.size());
        assertTrue(neighbours2.contains(board.getCell(1, 0)));
        assertTrue(neighbours2.contains(board.getCell(0, 1)));
    }

    @Test
    public void addTowerTest() {
        assertTrue(board.getTowers().isEmpty());

        Tower tower = new IceTower(board.getCell(3, 3));
        board.addTower(tower);

        assertEquals(1, board.getTowers().size());
        assertTrue(board.getTowers().contains(tower));
    }
}