package btd;


import static org.junit.jupiter.api.Assertions.*; 
import org.junit.jupiter.api.*;
import java.util.ArrayList;
import java.util.List;

public class BloonTest {

    private List<Cell> l; 
    private Baloon b;
    
    @BeforeEach
    public void Before() {
        l = new ArrayList<>();
        Cell c1 = new Cell(2, 5);
        Cell c2 = new Cell(1, 2);
        l.add(c1);
        l.add(c2);
        b = new Baloon(3, 2, l); 
        
    }

    @Test
    public void get_healthTest(){
        assertEquals(3, b.get_health());
    } 

    @Test
    public void get_SpeedTest(){
        assertEquals(2, b.get_speed());
    } 

    @Test
    public void get_distance_travelledTest(){
        assertEquals(2, b.get_distance_travelled());
    } 
    
    
}

