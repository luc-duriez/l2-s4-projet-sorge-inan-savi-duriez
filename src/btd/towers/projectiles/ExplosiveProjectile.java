package btd.towers.projectiles;

public class ExplosiveProjectile extends Projectile{
    //This Explosive projectile range of explosion
    private int range;

    public ExplosiveProjectile(String projectileName, int damage, int range){
        super(projectileName, damage);
        this.range = range;
    }
}
