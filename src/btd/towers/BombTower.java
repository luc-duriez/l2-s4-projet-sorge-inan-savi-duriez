package btd.towers;

import java.util.ArrayList;
import java.util.List;

import btd.boards.Cell;
import btd.towers.projectiles.*;
import btd.utils.Balloon;
import btd.utils.Game;

public class BombTower extends DamageTower {
    
    public BombTower(Cell pos){
        super(pos, 150, 1800, new ExplosiveProjectile("Bomb", 2), 600);
    }

    /**
     * Return the cells that the BombTower should shoot
     * @param inRangeBalloons list of the cells in the range of the tower
     * @return the cell that would be shooted 
     */
    private List<Balloon> selectBalloons(List<Balloon> inRangeBalloons){
        List<Balloon> balloonsToHit = new ArrayList<Balloon>();
        List<Balloon> targets = super.selectBalloon(inRangeBalloons);

        if (targets == null || targets.isEmpty()) {
        return balloonsToHit; 
        }
        for (Balloon b : inRangeBalloons) { // tri + tard
            if (b.getDistanceTravelled() == targets.get(0).getDistanceTravelled()){
                balloonsToHit.add(b);
            }
        }
        return balloonsToHit;
    }
    
    
    @Override
    public void shoot(List<Balloon> inRange, List<Balloon> touchedBalloons){
        if (cooldown >= attackSpeed){
            List<Balloon> balloons = selectBalloons(inRange);
            for(Balloon b : balloons){
                b.decreaseHealth(this.getFinalDamage());
                touchedBalloons.add(b);
                displayShoot(b);
                b.displayTouched();

            }
            if (!balloons.isEmpty()) {
                cooldown = 0;
            }
        }else{
            cooldown += Game.TICK;
        }
    }
}
