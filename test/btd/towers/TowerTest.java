package btd.towers;

import btd.boards.Cell;
import btd.towers.upgrades.*;
import btd.utils.Balloon;
import btd.utils.Game;
import btd.utils.Player;
import java.util.List;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.util.ArrayList;
import java.util.List;

public class TowerTest {
    public class TestTower extends Tower{
        public TestTower(Cell pos, double range, int attackSpeed, int basePrice){
            super(pos, range, attackSpeed,basePrice);
        }
    }
}
