package btd.towers.towers;
import btd.boards.Cell;
import btd.towers.projectiles.Projectile;
import btd.utils.Balloon;
import java.util.List;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class DamageTowerTest {
    // Création d'un classe de test de Damage test afin de vérifier la multitude tests inhérente à cette fonction
    public class TestDamage extends DamageTower{
        public TestDamage(Cell pos, double range, int attackSpeed, Projectile projectile, int basePrice){
            super(pos, range, attackSpeed, projectile, basePrice);
        }
    }
}
