package btd.towers;

import btd.boards.Cell;
import btd.towers.upgrades.*;
import btd.utils.Balloon;
import btd.utils.Player;
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
    public abstract void shoot(List<Balloon> balloonsInRange);


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
     * Returns all the baloons in range of the tower
     * @param activeBalloons all the actives ballons 
     * @return list of the ballons in the towers range
     */
    public List<Balloon> getBalloonsInRange(List<Balloon> activeBalloons){
        List<Balloon> res = new ArrayList<>();
        if (this.range < 0) { 
            return new ArrayList<>(activeBalloons);
        }
        double rangeCarre = this.range * this.range;
        for(Balloon b : activeBalloons){
            double dx = b.getCurrentCell().getX() - this.pos.getX();
            double dy = b.getCurrentCell().getY() - this.pos.getY();
            double distance = (dx * dx) + (dy * dy);

            if (distance<= rangeCarre) {
                res.add(b);
            }
        }
        return res;
    }

    /**
     * Adds a new upgrade to appliedUpgrade
     * @param u The upgrade to apply
     * @param p The player who upgrades this Tower
     * @return true if upgraded. False otherwise
     */
    public boolean upgrade(Upgrade u, Player p){
        boolean upgradable = true;
        if(u.getCost() > p.getCredits()){
            upgradable = false;
        }
        for (Upgrade u2: this.appliedUpgrades){
            if (u2.equals(u)){
                upgradable = false;
            }
        }
        if(upgradable){
            this.appliedUpgrades.add(u);
            return upgradable;
        }
        return upgradable;
    }

    /**
     * Revert the latest upgrade of this Tower
     * @param p The player to refund to gold
     */
    public void revertUpgrade(Player p){
        p.addCredits(this.appliedUpgrades.get(this.appliedUpgrades.size() - 1).getCost());
        this.appliedUpgrades.remove(this.appliedUpgrades.size() - 1);
    }

     /* Return a representation of Tower
     */
    public String toString(){
        return  getClass().getSimpleName() + "tower at (" + pos.getY() + ", " + pos.getX() +")";
    }

    /**
     * Display the Tower's shot to a Balloon
     * 
     * @param b the balloon being shooted 
     */
    public abstract void displayShoot(Balloon b);

    public Cell getCell(){
        return this.pos;
    }
}