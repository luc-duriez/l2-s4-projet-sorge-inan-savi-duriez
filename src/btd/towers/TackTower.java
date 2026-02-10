package btd.towers;

import btd.boards.Cell;
import btd.towers.projectiles.*;

public class TackTower extends DamageTower {
    
    public TackTower(Cell pos){
        super(pos, 80, 1200, new LinearProjectile("tack", 1), 350);
    }
}
