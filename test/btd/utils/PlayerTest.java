package btd.utils;
import btd.boards.*;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.util.ArrayList;
import java.util.List;

public class PlayerTest {
    private Player p;

    @BeforeEach
    public void before() {
        p = new Player(5000, 7);
    }

    @Test
    public void addCreditsTest() {
        p.addCredits(1000);
        assertEquals(6000, p.getCredits());
    }

     @Test
    public void decreaseCreditsTest() {
        p.decreaseCredits(1000);
        assertEquals(4000, p.getCredits());
    }

}
