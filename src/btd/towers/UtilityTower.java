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
    public void shoot(List<Balloon> balloonsInRange){
        for (Balloon b : balloonsInRange){
            if (cooldown == attackSpeed){
                if (b.getCountdown() == 0)
                    b.setSlowValue(slowPower);
                    b.setCountdown(countdown);
                cooldown = 0;
            }else{
                cooldown += 100;
            }
        }
    }
}
