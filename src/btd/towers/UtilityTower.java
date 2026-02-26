package btd.towers;

import java.util.List;
import btd.boards.Cell;
import btd.utils.Balloon;


public abstract class UtilityTower extends Tower{

    /*This Tower slow countdown */
    protected int countdown;

    /*This Tower slow power */
    protected double slowPower;

    public UtilityTower(Cell pos, double range, int attackSpeed, int basePrice){
        super(pos, range, attackSpeed, basePrice);
    }

    @Override
    protected List<Balloon> selectBalloon(List<Balloon> inRangeBalloons){
        return inRangeBalloons;
    }
}
