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

    // Création d'une classe TestTower afin de tester les méthodes propres a tower
    public class TestTower extends Tower{
        public TestTower(Cell pos, double range, int attackSpeed, int basePrice){
            super(pos, range, attackSpeed,basePrice);
        }


        @Override
        public List<Balloon> shoot(List<Balloon> balloonsInRange) { return new ArrayList<>(); }

        @Override
        public void displayShoot(Balloon b){};

        @Override
        protected List<Balloon> selectBalloon(List<Balloon> inRangeBalloons) { return new ArrayList<>();}


        public Integer getTotalValue() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'getTotalValue'");
        }
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
