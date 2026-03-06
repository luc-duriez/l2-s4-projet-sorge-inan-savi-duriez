package btd.towers;

import java.util.ArrayList;
import java.util.List;

import btd.boards.Cell;
import btd.towers.projectiles.Projectile;
import btd.towers.upgrades.Upgrade;
import btd.utils.Balloon;
import btd.utils.Game;
import btd.utils.Player;

/** Abstract tower that deals damage */
public abstract class DamageTower extends Tower {

    /** The projectile for this Tower */
    protected Projectile projectile;    
    /*This tower's bonus damage */
    protected double bonusDamage = 0;
    /*This tower's range multiplier */
    protected double rangeMultiplier = 1.0;
    /*This tower's fire rate multiplier */
    protected double AttackSpeedMultiplier = 1.0;
    /** The remaining upgrades for this Tower */
    protected List<Upgrade> remainingUpgrades;
    /** The applied upgrades on this Tower */
    protected List<Upgrade> appliedUpgrades;

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
        this.remainingUpgrades = new ArrayList<Upgrade>();
        this.appliedUpgrades = new ArrayList<Upgrade>();
    }

    /**
     * Return the total amount of damage for this Tower
     * @return the total amount of damage for this Tower
     */
    public double getFinalDamage() {
        return projectile.getDamage() + bonusDamage;
    }

    @Override //Changement de la range de la tower pour passer à range * rangeMultiplier
    public List<Balloon> getBalloonsInRange(List<Balloon> activeBalloons){
        List<Balloon> inRangeList = new ArrayList<>();
        if (this.range < 0) { 
            return new ArrayList<>(activeBalloons);
        }
        double newRange = range * rangeMultiplier;
        double rangeCarre = newRange * newRange;
        for (Balloon b : activeBalloons){
            double distance = Game.distanceSquaredOf(this.pos, b.getCurrentCell());
            if (distance <= rangeCarre) {
                inRangeList.add(b);
            }
        }
        return inRangeList;
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

    /**
     * Increase this tower's bonus damge by amount.
     * 
     * @param amount the increase amount
     */
    public void increaseDamage(double amount) {
        bonusDamage += amount;
    }

    /**
     * Increase this tower's range multiplier by multiplier.
     * 
     * @param multiplier the increase amount
     */
    public void multiplyRange(double multiplier) {
        rangeMultiplier *= multiplier;
    }

    /**
     * Increase this tower's fire rate multiplier by multiplier.
     * 
     * @param multiplier the increase amount
     */
    public void multiplyAttackSpeed(double multiplier) {
        AttackSpeedMultiplier *= multiplier;
    }

    /**
     * Adds a new upgrade to appliedUpgrade
     * @param u The upgrade to apply
     * @param p The player who upgrades this Tower
     */
    public void upgrade(Upgrade u, Player p) {
        if (p.hasEnoughCredits(u.getCost())) {
            p.decreaseCredits(u.getCost());
            u.apply(this);
            this.remainingUpgrades.remove(u); 
            this.appliedUpgrades.add(u); 
        }
    }

    /**
     * Revert the latest upgrade of this Tower
     * @param p The player to refund to gold
     */
    public void revertUpgrade(Upgrade u, Player p){
        p.addCredits(u.getCost());
        u.remove(this);
        this.appliedUpgrades.remove(u);
        this.remainingUpgrades.add(u);
    }

    @Override
    public int getTotalValue(){
        int price = basePrice;
        for (Upgrade u: appliedUpgrades){
            price += u.getCost();

        }
        return price;
    }
}
