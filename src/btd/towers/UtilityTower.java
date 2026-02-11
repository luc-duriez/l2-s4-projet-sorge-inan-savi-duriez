package btd.towers;

import btd.boards.Cell;
import btd.utils.Balloon;

public class UtilityTower extends Tower{
    public UtilityTower(Cell pos, double range, int attackSpeed, int basePrice){
        super(pos, range, attackSpeed, basePrice);
    }

    @Override
    public void shoot(Balloon b){
        b.changeSpeed(b.getSpeed());
    }
}
