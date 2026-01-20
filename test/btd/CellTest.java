package btd;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;

public class CellTest {
    @Test
    public void testIfTwoCellsAreEquals(){
        Cell c1 = new Cell(1, 0);
        Cell c2 = new Cell(1, 0);

        assertEquals(c1, c2);
    }
}
