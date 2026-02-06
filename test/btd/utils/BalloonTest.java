package btd.utils;
import btd.boards.*;


import static org.junit.jupiter.api.Assertions.*; 
import org.junit.jupiter.api.*;
import java.util.ArrayList;
import java.util.List;

public class BalloonTest {

    private List<Cell> l; 
    private Balloon b;
    
    @BeforeEach
    public void Before() {
        l = new ArrayList<>();
        Cell c1 = new Cell(2, 5);
        Cell c2 = new Cell(1, 2);
        l.add(c1);
        l.add(c2);
        b = new Balloon(3, 2, l); 
        
    }

    @Test
    public void getHealthTest(){
        assertEquals(3, b.getHealth());
    } 

    @Test
    public void getSpeedTest(){
        assertEquals(2, b.getSpeed());
    } 

    @Test
    public void getDistanceTravelledTest(){
        assertEquals(0, b.getDistanceTravelled());
    } 

    @Test
    public void decreaseHealthTest(){
        b.decreaseHealth(1);
        assertEquals(2, b.getHealth());
    } 

    @Test
    public void decreaseSpeedTest(){
        b.decreaseSpeed(1);
        assertEquals(1, b.getSpeed());
    } 

    @Test
    public void increaseSpeedTest(){
        b.increaseSpeed(1);
        assertEquals(3, b.getSpeed());
    } 

    @Test
    public void isDead(){
        b.decreaseHealth(1);
        assertFalse(b.isDead());
        b.decreaseHealth(3);
        assertTrue(b.isDead());
    } 

    @Test
    public void moveTest(){
        b.move();
        assertEquals(2, b.getDistanceTravelled());
    } 
    
    
}

