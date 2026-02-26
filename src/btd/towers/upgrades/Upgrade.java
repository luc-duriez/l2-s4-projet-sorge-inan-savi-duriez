package btd.towers.upgrades;

import btd.towers.Tower;

/** Interface for upgrades */
public interface Upgrade {
    /**
     * Apply the upgrade to the tower
     * @param t The tower to apply this upgrade
     */
    public void apply(Tower t);

    /**
     * Revert the upgrade of a tower
     * @param t The tower to revert the upgrade
     */
    public void revert(Tower t);

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

    /** Gets the fire rate */
    public double getFireRate();
}
