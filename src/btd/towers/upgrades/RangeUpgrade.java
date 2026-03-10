package btd.towers.upgrades;

import btd.towers.*;

public class RangeUpgrade implements Upgrade {

    /*This upgrade's multiplier */
    private double multiplier;

    /*This upgrade's cost */
    private int cost;

    /**
     * Build a Range upgrade of a given bonus damage and cost.
     * 
     * @param multiplier this upgrade's multiplier
     * @param cost this upgrade's cost
     */
    public RangeUpgrade(double multiplier, int cost) {
        this.multiplier = multiplier;
        this.cost = cost;
    }

    @Override
    public void apply(DamageTower tower) {
        tower.multiplyRange(multiplier);
    }

    @Override
    public void remove(DamageTower tower) {
        tower.multiplyRange(1.0 / multiplier);
    }

    @Override
    public int getCost() {
        return cost;
    }

    @Override
    public String toString(){
        return "Range x" + multiplier + " (cost " + cost + ")";
    }
}