package btd.towers.upgrades;

import btd.towers.Tower;

/** Interface for upgrades */
public interface Upgrade {

    /**
     * Returns the cost of this Upgrade
     * @return the cost of this Upgrade
     */
    public int getCost();

    /**
     * Returns the name of this Upgrade
     * @return the name of this Upgrade
     */
    public String getName();

    /**
     * Returns the damage of this Upgrade
     * @return the damage of this Upgrade
     */
    public int getDamageIncrease();

    /**
     * Gets the fire rate 
     * @return fire rate
     */
    public double getFireRate();

    /**
    * Return if 2 upgrades are equals
    * @return boolean
    */ 
    public boolean equals(Object o);
}
