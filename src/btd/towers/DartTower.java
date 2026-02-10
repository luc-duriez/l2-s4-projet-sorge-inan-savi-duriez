package btd.towers;

import btd.boards.Cell;
import btd.towers.projectiles.*;

public class DartTower extends DamageTower {
    
    public DartTower(Cell pos){
        super(pos, 100, 1000, new LinearProjectile("Dart", 1), 200);
    }
}
