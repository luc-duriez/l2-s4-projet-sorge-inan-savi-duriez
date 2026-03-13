package btd.towers.upgrades;

import btd.towers.towers.*;

public class AttackSpeedUpgrade implements Upgrade {

    /*This upgrade's multiplier */
    private double multiplier;
    /*This upgrade's cost */
    private int cost;

    /**
     * Build an Attack speed upgrade of a given multiplier and cost.
     * 
     * @param multiplier this upgrade's multiplier the multiplier must be between 0 and 1
     * @param cost this upgrade's cost
     */
    public AttackSpeedUpgrade(double multiplier, int cost) {
        this.multiplier = multiplier;
        this.cost = cost;
    }

    @Override
    public void apply(DamageTower tower) {
        tower.multiplyBonusAttackSpeed(multiplier);
    }

    @Override
    public void remove(DamageTower tower) {
        tower.multiplyBonusAttackSpeed(1.0 / multiplier);
    }

    @Override
    public int getCost() {
        return cost;
    }

    @Override
    public String toString(){
        return "AttackSpeed x" + multiplier + " (cost " + cost + ")";
    }

    @Override
    public String displayAppliedUpgrade(DamageTower tower){
        return String.format("Applying upgrade Increase attack speed by %.0f%% %nAttackSpeed:%.0f ratefactor:%.2f", (multiplier-1)*100, tower.getRate(), multiplier);
    }
}

