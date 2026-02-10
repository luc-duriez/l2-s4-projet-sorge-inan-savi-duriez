package btd.towers;

import btd.boards.Cell;
import btd.towers.projectiles.Projectile;

public class BombTower extends DamageTower {
    
    public BombTower(Cell pos, double range, int attackSpeed, Projectile projectile, int basePrice){
        super(pos, range, attackSpeed, projectile, basePrice);
    }
}
