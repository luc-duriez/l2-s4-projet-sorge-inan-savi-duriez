package btd.towers;

import java.util.ArrayList;
import java.util.List;

import btd.boards.Cell;
import btd.utils.Balloon;
import btd.utils.Game;

/** A slow tower */
public class SlowTower extends UtilityTower {

    /**
     * Creates a slow tower
     * @param pos position
     */
    public SlowTower(Cell pos) {
        super(pos, 100, 1500, 500);
        this.slowPower = 0.5;
        this.countdown = 5;
    }

    /**
     * Protected constructor
     * @param pos       position
     * @param basePrice base price
     */
    protected SlowTower(Cell pos, int basePrice) {
        super(pos, 100, 1500, basePrice);
        this.slowPower = 0.5;
    }

    public List<Balloon> shoot(List<Balloon> inRange) {
        List<Balloon> touched = new ArrayList<>();

        if (this.cooldown >= this.getFinalRate()) {
            if (!inRange.isEmpty()) {
                for (Balloon b : inRange) {
                    b.applyMovementEffect(this.slowPower, this.countdown);

                    touched.add(b);
                    displayShoot(b);
                }
                this.cooldown = 0;
            }
        } else {
            this.cooldown += Game.TICK;
        }
        return touched;
    }

    @Override
    public void displayShoot(Balloon b) {
        System.out.printf("%s slowed for %dms %n", b, this.countdown * Game.TICK);
    }
}
