package btd.towers;

import btd.*;
import java.util.List;

public abstract class Tower{
    /* The position of this Tower */
    protected Cell pos;
    /* The range of this Tower */
    protected double range;
    /* The attack speed of this Tower */
    protected int attackSpeed;
    /* The projectile for this Tower */
    protected Projectile projectile;
    /* The remaining upgrades for this Tower */
    protected List<Upgrade> remainingUpgrades;
    /* The applied upgrades on this Tower */
    protected List<Upgrade> appliedUpgrades;
    /* The base price of this upgrade */
    protected int basePrice;

    /**
     * Build a new Tower
     * @param pos The position of this Tower
     * @param range The range of this Tower
     * @param attackSpeed The attack speed of this Tower
     * @param projectile The projectile of this Tower
     * @param basePrice THe base price of this Tower
     */
    public Tower(Cell pos, double range, int attackSpeed, Projectile projectile, int basePrice){
        this.pos = pos;
        this.range = range;
        this.attackSpeed = attackSpeed;
        this.projectile = projectile;
        this.basePrice = basePrice;
    }

    /**
     * Returns the total value of this Tower
     * @return The total value of this Tower
     */
    public int getTotalValue(){
        int totalCost = basePrice;
        for (Upgrade u : appliedUpgrades){
            totalCost += u.getCost();
        }
        return totalCost;
    }


}