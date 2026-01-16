package btd;

public class Tower{
    /* The position of the Tower */
    protected Cell pos;
    /* The range of the Tower */
    protected double range;
    
    protected int attackSpeed;
    protected Projectile projectile;
    protected List<Upgrade> remainingUpgrades;
    protected List<Upgrade> appliedUpgrades;
    protected int basePrice;


}