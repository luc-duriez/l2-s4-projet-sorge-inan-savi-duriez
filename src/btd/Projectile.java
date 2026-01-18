package btd;

public class Projectile {
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
    
    
}
