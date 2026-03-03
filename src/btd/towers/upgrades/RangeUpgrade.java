package btd.towers.upgrades;

import btd.towers.Tower;

public class RangeUpgrade implements Upgrade {
    
    /*This range upgrade's upgrade value */
    private double value;

    /*This range upgrade's cost */
    private int cost;

    /**
     * 
     * @param value this upgrade
     */
    public RangeUpgrade(double value, int cost){
        this.value = value;
        this.cost = cost;
    }


    /**
     * Returns the cost of this Upgrade
     * @return the cost of this Upgrade
     */
    public int getCost(){
        return cost;
    }

    public void apply(Tower t){
        t.increaseRange(this.value);
        t.upgrade(null, null)
    }
}
