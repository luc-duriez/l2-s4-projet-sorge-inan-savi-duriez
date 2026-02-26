package btd.towers;

import btd.boards.Cell;
import btd.towers.projectiles.*;

/** A super tower */
public class SuperTower extends DamageTower {

    /**
     * Creates a super tower
     * @param pos position
     */
    public SuperTower(Cell pos) {
        super(pos, 200, 300, new LinearProjectile("sharp dart", 2), 1200);
    }
}
