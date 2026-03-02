package btd.towers.upgrades;

/** Damage upgrade */
public class DamageUpgrade implements Upgrade{
    
    public DamageUpgrade() {
    }
    private String name;
    private int cost;
    private int damageIncrease;

    public DamageUpgrade(String name, int cost, int damageIncrease, double fireRate) {
        this.name = name;
        this.cost = cost;
        this.damageIncrease = damageIncrease;
    }

    /**
     * la doc Kamal par pitié
     * @return 
     */
    public int getCost() { return this.cost; }

    public String getName() { return this.name; }

    public int getDamageIncrease() { return this.damageIncrease; }

    public double getFireRate(){ return 1.0;}
}
