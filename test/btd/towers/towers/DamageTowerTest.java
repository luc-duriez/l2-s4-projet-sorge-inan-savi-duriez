package btd.towers.towers;
import btd.boards.Cell;
import btd.towers.projectiles.LinearProjectile;
import btd.towers.projectiles.Projectile;
import btd.towers.upgrades.AttackSpeedUpgrade;
import btd.towers.upgrades.DamageUpgrade;
import btd.towers.upgrades.RangeUpgrade;
import btd.towers.upgrades.Upgrade;
import btd.utils.Balloon;
import btd.utils.Player;

import java.util.List;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class DamageTowerTest {
    // Création d'un classe de test de Damage test afin de vérifier la multitude tests inhérente à cette fonction
    private class TestDamage extends DamageTower{
        public TestDamage(Cell pos, double range, int attackSpeed, Projectile projectile, int basePrice){
            super(pos, range, attackSpeed, projectile, basePrice);
            Upgrade u1 = new AttackSpeedUpgrade(1.25, 200);
            Upgrade u2 = new DamageUpgrade(2, 300);
            this.remainingUpgrades.add(u1);
            this.remainingUpgrades.add(u2);
        }

        @Override
        public List<Balloon> getBalloonsInRange(List<Balloon> activeBalloons){ return new ArrayList<>();}

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
        test = new TestDamage(new Cell(0, 0), 1.5, 1,new LinearProjectile("aaa", 5),250);
        Player player1 = new Player();
        Upgrade u3 = new RangeUpgrade(1.25, 500);
        test.upgrade(u3, player1);
    }

}
