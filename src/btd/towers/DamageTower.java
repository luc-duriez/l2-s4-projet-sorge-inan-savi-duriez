package btd.towers;

import java.util.ArrayList;
import java.util.List;

import btd.boards.Cell;
import btd.towers.projectiles.Projectile;
import btd.towers.upgrades.Upgrade;
import btd.utils.Balloon;
import btd.utils.Game;

/** Abstract tower that deals damage */
public abstract class DamageTower extends Tower {

    /** The projectile for this Tower */
    protected Projectile projectile;

    /**
     * Creates a damage tower
     * @param pos position
     * @param range range
     * @param attackSpeed attack speed
     * @param projectile projectile
     * @param basePrice base price
     */
    public DamageTower(Cell pos, double range, int attackSpeed, Projectile projectile, int basePrice) {
        super(pos, range, attackSpeed, basePrice);
        this.projectile = projectile;
    }

    /**
     * Return the total amount of damage for this Tower
     * @return the total amount of damage for this Tower
     */
    public int getFinalDamage() {
        int finalDmg = this.projectile.getDamage();
        for (Upgrade u : appliedUpgrades) {
            finalDmg += u.getDamageIncrease();
        }
        return finalDmg;
    }

    /**
     * Return the cell with the highest travelled distance
     * @param inRangeBalloons list of the cells in the range of the tower
     * @return the cell that would be shooted
     */
    protected List<Balloon> selectBalloon(List<Balloon> inRangeBalloons) {
        if (inRangeBalloons.isEmpty()) {
            return null;
        }
        Balloon max = inRangeBalloons.get(0);
        for (Balloon b : inRangeBalloons) { // tri + tard
            if (b.getDistanceTravelled() > max.getDistanceTravelled()) {
                max = b;
            }
        }
        return List.of(max);
    }

    @Override
    public List<Balloon> shoot(List<Balloon> inRange) {
        List<Balloon> touchedBalloons = new ArrayList<Balloon>();
        if (cooldown >= attackSpeed) {
            List<Balloon> b = selectBalloon(inRange);
            if (b != null && !b.isEmpty()) {
                Balloon cible = b.get(0);
                cible.decreaseHealth(this.getFinalDamage());
                displayShoot(cible);
                cible.displayTouched();
                touchedBalloons.add(cible);
                cooldown = 0;
            }
        } else {
            cooldown += Game.TICK;
        }
        return touchedBalloons;
    }

    @Override
    public void displayShoot(Balloon b) {
        System.out.println(toString() + " shoots " + projectile + " at " + b);
    }
    
    /**
     * Return the projectile of this Tower
     * @return Projectile the projectile of this Tower
     */
    public Projectile getProjectile() {
        return projectile;
    }
}
