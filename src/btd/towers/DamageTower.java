package btd.towers;

import btd.boards.Cell;
import btd.towers.projectiles.Projectile;
import btd.towers.upgrades.Upgrade;
import btd.utils.Balloon;

public class DamageTower extends Tower{
    
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

    @Override
    public void shoot(Balloon b){
        b.decreaseHealth(this.getFinalDamage());
    }
}
