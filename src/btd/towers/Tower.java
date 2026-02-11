package btd.towers;

import btd.boards.Cell;
import btd.towers.upgrades.*;
import btd.utils.Balloon;

import java.util.List;
import java.util.ArrayList;

public abstract class Tower{
    /* The position of this Tower */
    protected Cell pos;
    /* The range of this Tower */
    protected double range;
    /* The attack speed of this Tower */
    protected int attackSpeed;
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
    public Tower(Cell pos, double range, int attackSpeed, int basePrice){
        this.pos = pos;
        this.range = range;
        this.attackSpeed = attackSpeed;
        
        this.basePrice = basePrice;
        this.remainingUpgrades = new ArrayList<Upgrade>();
        this.appliedUpgrades = new ArrayList<Upgrade>();
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
    
    /**
     * Return the final range after the upgrades
     * @return the final range after the upgrades
     */
    public double getFinalRange(){
        double finalRange = this.range;
        for (Upgrade u : appliedUpgrades){
            finalRange *= u.getDamageIncrease();
        }
        return finalRange;
    }


    /**
     * Return the final fire rate after the upgrades
     * @return the final fire rate after the upgrades
     */
    public int getFinalRate(){
        int finalRate = this.attackSpeed;
        for (Upgrade u : appliedUpgrades){
            finalRate *= u.getFireRate();
        }
        return finalRate;
    }

    /**
     * Shoots the balloon
     * @parameter The balloon to shoot
     */
    public abstract void shoot(Balloon b);


    /**
     * Sells this Tower and return the money from selling it
     * @return the money from selling this Tower
     */
    public int sell(){
        int totalPrice = this.basePrice;
        for(Upgrade u: this.appliedUpgrades){
            totalPrice += u.getCost();
        }
        return totalPrice;
    }

    /**
     * Return the cell with the highest travelled distance
     * @param cellInRange list of the cells in the range of the tower
     * @return the cell that would be shooted 
     */
    public Balloon selectBalloon(List<Balloon> inRangeBalloons){
        if (inRangeBalloons.isEmpty()){
            return null;
        }
        Balloon max = inRangeBalloons.get(0);
        for (Balloon b : inRangeBalloons) {
            if (b.getDistanceTravelled() > max.getDistanceTravelled()){
                max = b;
            }
        }
        return max;
    }
}