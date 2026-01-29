package btd.boards;

import btd.Board;
import org.junit.jupiter.api.BeforeEach;

public class ClassicBoardTest {
    private Board b1;

    @BeforeEach
    public void before(){
        this.b1 = new ClassicBoard(10, 10);
    }
}