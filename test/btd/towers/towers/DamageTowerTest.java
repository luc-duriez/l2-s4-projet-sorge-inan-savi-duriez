package btd.towers.towers;
import btd.boards.Board;
import btd.boards.Cell;
import btd.boards.ClassicBoard;
import btd.towers.projectiles.LinearProjectile;
import btd.towers.projectiles.Projectile;
import btd.towers.upgrades.AttackSpeedUpgrade;
import btd.towers.upgrades.DamageUpgrade;
import btd.towers.upgrades.RangeUpgrade;
import btd.towers.upgrades.Upgrade;
import btd.utils.Balloon;
import btd.utils.Game;
import btd.utils.Player;

import java.util.List;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class DamageTowerTest {

    // initialisation des différentes upgrades 
    Upgrade u1 = new AttackSpeedUpgrade(1.25, 200);
    Upgrade u2 = new DamageUpgrade(1.5, 300);
    Upgrade u3 = new RangeUpgrade( 1.25, 500);
    // Création d'un classe de test de Damage test afin de vérifier la multitude tests inhérente à cette fonction
    private class TestDamage extends DamageTower{
        public TestDamage(Cell pos, double range, int attackSpeed, Projectile projectile, int basePrice){
            super(pos, range, attackSpeed, projectile, basePrice);
            this.remainingUpgrades.add(u1);
            this.remainingUpgrades.add(u2);
            this.remainingUpgrades.add(u3);

        }
        public List<Balloon> getBalloonsInRange(List<Balloon> activeBalloons){ return super.getBalloonsInRange(activeBalloons);}

        @Override
        public int getTotalValue(){return 0;}

        @Override
        public List<Balloon> shoot(List<Balloon> inRange) { return new ArrayList<>();}

        @Override
        public void displayShoot(Balloon b){}
    }

    private TestDamage test;

    @BeforeEach
    public void before(){
        test = new TestDamage(new Cell(0, 0), 2.0, 1,new LinearProjectile("aaa", 5),250);
        Player player1 = new Player();
        test.upgrade(u1, player1);
        test.upgrade(u2, player1);
        test.upgrade(u3, player1);
    }

    @Test
    public void getFinalDamageAfterUpgrade(){
        assertEquals(6.5, test.getFinalDamage());
    }

    @Test
    public void getFinalRateTest(){
        assertEquals(0.75, test.getFinalRate());
    }

    @Test
    public void getFinalRangeTest(){
        assertEquals(1.875, test.getFinalRange());
    }

    @Test
    public void getBalloonsInRangeTest(){
        List<Cell> path1 = List.of(new Cell(1, 0));
        Balloon Ballon1 = new Balloon(2, 1.2, path1, 0);
        List<Cell> path2 = List.of(new Cell(2, 3));
        Balloon Ballon2 = new Balloon(5, 1.2, path2, 1);

        List<Balloon> listeDesBallons = new ArrayList<>();
        listeDesBallons.add(Ballon1);
        listeDesBallons.add(Ballon2);

        List<Balloon> res = test.getBalloonsInRange(listeDesBallons);

        assertEquals(1, res.size());
        assertTrue(res.contains(Ballon1));
        assertFalse(res.contains(Ballon2));

    }


}
