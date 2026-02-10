package btd.towers;

import btd.boards.Cell;

public class SlowTower extends UtilityTower {

    public SlowTower(Cell pos){
        super(pos, 100, 1500, 500);
    }

    protected SlowTower(Cell pos,int basePrice){
        super(pos, 100, 1500, basePrice);
    }
}
