package btd.towers.upgrades;

import btd.towers.*;

public class DamageUpgrade implements Upgrade{
    
    /*This upgrade's bonus damage */
    private double damageBonus;

    /*This upgrade's cost */
    private int cost;

    /**
     * Build a Damage upgrade of a given bonus damage and cost.
     * 
     * @param damageBonus this upgrade's bonus damage
     * @param cost this upgrade's cost
     */
    public DamageUpgrade(double damageBonus, int cost) {
        this.damageBonus = damageBonus;
        this.cost = cost;
    }

    @Override
    public void apply(DamageTower tower) {
        tower.increaseDamage(damageBonus);
    }

    @Override
    public void remove(DamageTower tower) {
        tower.increaseDamage(-damageBonus);
    }

    @Override
    public int getCost() {
        return cost;
    }

    @Override
    public String toString(){
        return "Damage +" + damageBonus + " (coût " + cost + ")";
    }
}
