package btd.towers;

import java.util.List;

import btd.boards.Cell;
import btd.towers.projectiles.*;
import btd.utils.Balloon;

public class TackTower extends DamageTower {
    
    public TackTower(Cell pos){
        super(pos, 80, 1200, new LinearProjectile("tack", 1), 350);
    }

    @Override
    public void shoot(List<Balloon> inRange, List<Balloon> touchedBalloons){
        for (Balloon b : inRange){
            b.decreaseHealth(this.getFinalDamage());
        }
        
    }
}
