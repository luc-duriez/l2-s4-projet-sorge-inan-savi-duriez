package btd.towers;

import btd.boards.Cell;
import btd.utils.Balloon;


public class SlowTower extends UtilityTower {

    public SlowTower(Cell pos){
        super(pos, 100, 1500, 500);
        this.slowPower = 0.5;
    }

    protected SlowTower(Cell pos,int basePrice){
        super(pos, 100, 1500, basePrice);
        this.slowPower = 0.5;
    }

    @Override
    public void displayShoot(Balloon b){
        System.out.printf("%s slowed for %dms %n", b, this.attackSpeed);
    }
}
