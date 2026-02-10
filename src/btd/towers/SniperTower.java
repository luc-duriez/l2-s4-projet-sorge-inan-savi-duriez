package btd.towers;

import btd.boards.Cell;
import btd.towers.projectiles.Projectile;

public class SniperTower extends DamageTower {
    
    public SniperTower(Cell pos, double range, int attackSpeed, Projectile projectile, int basePrice){
        super(pos, range, attackSpeed, projectile, basePrice);
    }
}
