package btd.towers;

import btd.boards.Cell;
import btd.utils.Balloon;
import btd.utils.Game;


public class IceTower extends SlowTower  {
    
    public IceTower(Cell pos){
        super(pos, 400);
        this.slowPower = 0.0;
        this.countdown = 5;
    }

    @Override
    public void displayShoot(Balloon b){
        System.out.printf("%s frozen for %dms %n", b, this.countdown * Game.TICK);
    }
}
