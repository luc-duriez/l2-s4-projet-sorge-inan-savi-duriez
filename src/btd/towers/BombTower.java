package btd.towers;

import btd.boards.Cell;
import btd.towers.projectiles.*;

public class BombTower extends DamageTower {
    
    public BombTower(Cell pos){
        super(pos, 150, 1800, new ExplosiveProjectile("Bomb", 2), 600);
    }
}
