package btd.towers;

import java.util.ArrayList;
import java.util.List;

import btd.boards.Cell;
import btd.towers.projectiles.*;
import btd.utils.Balloon;
import btd.utils.Game;

public class BombTower extends DamageTower {
    
    public BombTower(Cell pos){
        super(pos, 150, 1800, new ExplosiveProjectile("Bomb", 2,Cell.SIZE), 600);
        this.projectile = this.getProjectile();
    }
   
    
    @Override
    public List<Balloon> shoot(List<Balloon> inRange){
        List<Balloon> touchedBalloons = new ArrayList<>();

        if (this.cooldown >= this.getFinalRate()) {
            List<Balloon> targets = super.selectBalloon(inRange);
            if (targets != null && !targets.isEmpty()) {
                Balloon mainTarget = targets.get(0);
                
                if (this.getProjectile() instanceof ExplosiveProjectile) {
                
                    double radius = this.getFinalExplosionRadius();
                    double explosionRangeSq = radius * radius;
                    displayShoot(mainTarget);
                    for (Balloon b : inRange) {
                        if (Game.distanceSquaredOf(mainTarget.getCurrentCell(), b.getCurrentCell()) <= explosionRangeSq) {
                            b.decreaseHealth(this.getFinalDamage());
                            touchedBalloons.add(b);
                            b.displayTouched();
                        }
                    }
                    
                    
                    this.cooldown = 0;
                }
            }
        } else {
            this.cooldown += Game.TICK;
        }
        return touchedBalloons;
    }
    /**
     * Calculate the final explosion radius for this Tower
     * @return double the final explosion radius for this Tower
     */
    private double getFinalExplosionRadius() {
        return ((ExplosiveProjectile) this.projectile).getExplosionRadius();
    }


    @Override
    public void displayShoot(Balloon b){
        System.out.println(toString() + " fires a " + projectile + " at " + b );
    }
}
