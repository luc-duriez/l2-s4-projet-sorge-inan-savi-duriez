package btd.towers.projectiles;

import btd.boards.Cell;

public class ExplosiveProjectile extends Projectile{
    //This Explosive projectile range of explosion
    private int range;

    public ExplosiveProjectile(String projectileName, int damage){
        super(projectileName, damage);
        this.range = Cell.SIZE;
    }
}
