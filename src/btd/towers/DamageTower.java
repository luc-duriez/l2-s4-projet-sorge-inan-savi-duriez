package btd.towers;

import java.util.List;

import btd.boards.Cell;
import btd.towers.projectiles.Projectile;
import btd.towers.upgrades.Upgrade;
import btd.utils.Balloon;
import btd.utils.Game;

public abstract class DamageTower extends Tower{
    
    /* The projectile for this Tower */
    protected Projectile projectile;

    public DamageTower(Cell pos, double range, int attackSpeed, Projectile projectile, int basePrice){
        super(pos, range, attackSpeed, basePrice);
        this.projectile = projectile;
    }

    /**
     * Return the total amount of damage for this Tower
     * @return the total amount of damage for this Tower
     */
    public int getFinalDamage(){
        int finalDmg = this.projectile.getDamage();
        for (Upgrade u : appliedUpgrades){
            finalDmg += u.getDamageIncrease();
        }
        return finalDmg;
    }

    /**
     * Return the cell with the highest travelled distance
     * @param inRangeBalloons list of the cells in the range of the tower
     * @return the cell that would be shooted 
     */
    protected Balloon selectBalloon(List<Balloon> inRangeBalloons){
        if (inRangeBalloons.isEmpty()){
            return null;
        }
        Balloon max = inRangeBalloons.get(0);
        for (Balloon b : inRangeBalloons) { // tri + tard
            if (b.getDistanceTravelled() > max.getDistanceTravelled()){
                max = b;
            }
        }
        return max;
    }
    
    
    @Override
    public void shoot(List<Balloon> inRange, List<Balloon> touchedBalloons){
        if (cooldown == attackSpeed){
            Balloon b = selectBalloon(inRange);
            b.decreaseHealth(this.getFinalDamage());
            cooldown = 0;
        }else{
            cooldown += Game.TICK;
        }
    }

    @Override
    public void displayShoot(Balloon b){
        System.out.println(toString() + " shoots " + projectile + " at " + b);
    }
}
