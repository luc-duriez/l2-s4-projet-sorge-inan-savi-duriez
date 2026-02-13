package btd.towers.projectiles;

public abstract class Projectile {
    /* The damage of Projectile */
    protected int damage;
    /* Name of Projectile */
    private final String projectileName;

    /**
     * Constructor of Projectile 
     * @param projectileName : String
     * @param damage : int
     */
    public Projectile(String projectileName,int damage){
        this.projectileName = projectileName;
        this.damage = damage;
    }
    /**
     * Getter of damage
     * @return damage : int
     */
    public int getDamage(){
        return this.damage;
    }
    /**
     * Getter of projectile name
     * @return Projectile Name : String
     */
    public String getName(){
        return this.projectileName;
    }

    /**
     * Return a String representation of the projectile
     */
    public String toString(){
        return projectileName + "(" + damage + ")";
    }
    
}
