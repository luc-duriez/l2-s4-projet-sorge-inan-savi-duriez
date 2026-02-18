package btd.towers;

import btd.boards.Board;
import btd.boards.Cell;
import btd.towers.projectiles.*;

public class SniperTower extends DamageTower {
    
    public SniperTower(Cell pos){
        super(pos, Board.sizeBoard, 2000, new LinearProjectile("very sharp dart", 4), 500);
    }
}
