package btd.towers;

import java.util.List;
import btd.boards.Cell;
import btd.utils.Balloon;

public class UtilityTower extends Tower{
    public UtilityTower(Cell pos, double range, int attackSpeed, int basePrice){
        super(pos, range, attackSpeed, basePrice);
    }

    @Override
    public void shoot(List<Balloon> inRange){
        for (Balloon b : inRange){
            b.changeSpeed(b.getSpeed());
        }
        
    }

    @Override
    public void displayShoot(Balloon b){
        System.out.printf("");
    }
}
