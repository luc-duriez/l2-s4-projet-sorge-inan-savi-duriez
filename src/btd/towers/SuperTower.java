package btd.towers;

import btd.boards.Cell;
import btd.towers.projectiles.*;

public class SuperTower extends DamageTower {
    
    public SuperTower(Cell pos){
        super(pos, 200, 300, new LinearProjectile("sharp dart", 2), 1200);
    }
}
