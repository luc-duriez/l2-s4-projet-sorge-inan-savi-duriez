package btd.towers;

import btd.boards.Cell;
import btd.towers.projectiles.*;

/** A dart tower */
public class DartTower extends DamageTower {
    
    /** Creates a dart tower */
    public DartTower(Cell pos) {
        super(pos, 100, 1000, new LinearProjectile("Dart", 1), 200);
    }
}
