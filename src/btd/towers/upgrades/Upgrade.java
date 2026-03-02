package btd.towers.upgrades;


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
    default int getDamageIncrease() {
        return 0;
    }

    /**
     * Gets the fire rate 
     * @return fire rate
     */
    default double getFireRate() {
        return 1.0;
    }
}
