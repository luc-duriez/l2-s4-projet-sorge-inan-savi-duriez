package btd.towers.towers;

import btd.boards.Cell;
import btd.towers.upgrades.Upgrade;
import btd.utils.Balloon;
import btd.utils.Player;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class TowerTest {

    // Création d'une classe TestTower afin de tester les méthodes propres a tower
    public class TestTower extends Tower{
        public TestTower(Cell pos, double range, int attackSpeed, int basePrice){
            super(pos, range, attackSpeed,basePrice);
        }

        @Override
        public void upgrade(Upgrade u, Player p) throws NoSuchElementException { };

        @Override
        public List<Balloon> shoot(List<Balloon> balloonsInRange) { return new ArrayList<>(); }

        @Override
        public void displayShoot(Balloon b){};

        @Override
        protected List<Balloon> selectBalloon(List<Balloon> inRangeBalloons) { return new ArrayList<>();}

    }
    private TestTower test;

    @BeforeEach
    public void before(){
        test = new TestTower(new Cell(0, 0), 5.0, 10, 100);
    }

    @Test
    public void getTotalValueTest(){
        assertEquals(100, test.getTotalValue());
    }
}
