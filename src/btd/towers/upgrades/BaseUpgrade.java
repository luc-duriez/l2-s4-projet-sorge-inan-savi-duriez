package btd.towers.upgrades;


// Permet de faire toutes les upgrades de bases (dommages, vitesse...)
public class BaseUpgrade implements Upgrade {
    private String name;
    private int cost;
    private int damageIncrease;
    private double fireRate;

    public BaseUpgrade(String name, int cost, int damageIncrease, double fireRate) {
        this.name = name;
        this.cost = cost;
        this.damageIncrease = damageIncrease;
        this.fireRate = fireRate;
    }


    public int getCost() { return this.cost; }

    public String getName() { return this.name; }

    public int getDamageIncrease() { return this.damageIncrease; }

    public double getFireRate() { return this.fireRate; }

    /**
     * On compare si 2 upgrades ont le même nom
     */
    public boolean equals(Object o){
        if (!(o instanceof Upgrade)){
            return false;
        } 
        Upgrade other = (Upgrade) o;
        return this.name.equals(other.getName());
    }
}
