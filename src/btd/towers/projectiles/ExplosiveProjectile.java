package btd.towers.projectiles;


public class ExplosiveProjectile extends Projectile{
    //This Explosive projectile range of explosion
    private int range;

    public ExplosiveProjectile(String projectileName, int damage, int radius) {
        super(projectileName, damage);
        this.range = radius / 2; // /2 pour toucher que la case actuelle
    }
    public int getExplosionRadius(){
        return range;
    }
}
