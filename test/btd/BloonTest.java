package btd;
import btd.*;

import static org.junit.jupiter.api.Assertions.*; 
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test; 

public class BloonTest {

    private List<Cell> l; 

    @BeforeEach
    public void setUp() {
        l = new ArrayList<>();
        Cell c1 = new Cell(2, 5);
        Cell c2 = new Cell(1, 2);
        l.add(c1);
        l.add(c2);
        
    }
    
    
}

