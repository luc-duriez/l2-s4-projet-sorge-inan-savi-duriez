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
}
