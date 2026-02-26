package btd.boards;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

public class LinearBoardTest {

    private LinearBoard board;

    @BeforeEach
    public void before() {
        board = new LinearBoard(10, 10,2);
    }

    @Test
    public void createPathTest() {
        List<List<Cell>> allPaths = board.getPath();
        
        assertFalse(allPaths.isEmpty());
        
        List<Cell> mainPath = allPaths.get(0);
        assertFalse(mainPath.isEmpty());
    }

    @Test
    public void randomCellTest() {
        List<Cell> usedCells = new ArrayList<>();
        usedCells.add(board.getCell(0, 0));
        
        Cell[] result = board.randomCell(usedCells);
        
        assertNotNull(result);
        assertEquals(2, result.length); 
        
        assertNotEquals(result[0], result[1]);
        assertFalse(usedCells.contains(result[0]));
        assertFalse(usedCells.contains(result[1]));
    }
}