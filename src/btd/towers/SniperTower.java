package btd.towers;

import btd.boards.Board;
import btd.boards.Cell;
import btd.towers.projectiles.*;

/** A sniper tower with long range */
public class SniperTower extends DamageTower {
    
    /** Creates a sniper tower */
    public SniperTower(Cell pos) {
        super(pos, Board.sizeBoard, 2000, new LinearProjectile("very sharp dart", 4), 500);
    }
}
