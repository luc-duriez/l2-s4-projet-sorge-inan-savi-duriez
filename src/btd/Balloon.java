package btd;

import java.util.List;

public class Balloon {

    // The health of the balloon
    private int health;
    // The speed of the balloon
    private double speed;
    // Distance travelled by the balloon
    private int distanceTravelled;
    // The next cell of the balloon
    private Cell nextCell;
    // the path of the balloon
    private List<Cell> path;
    // the current cell of the balloon
    private Cell currentCell;

    // Constructer of Balloon object
    public Balloon(int health, double speed, List<Cell> path) {
        this.health = health;
        this.speed = speed;
        this.path = path;
        this.distanceTravelled = 0;
    }

    /**
     * Return the health of the balloon
     * 
     * @return int
     */
    public int getHealth() {
        return this.health;
    }

    /**
     * Return the speed of the balloon
     * 
     * @return float
     */
    public double getSpeed() {
        return this.speed;
    }

    /**
     * Return the distance travelled of the balloon
     * 
     * @return int
     */
    public int getDistanceTravelled() {
        return this.distanceTravelled;
    }

    // /**
    // * Returns the current cell of the balloon
    // */
    // public Cell current_cell(){
    // int index = this.distance_travelled / 100;
    // return this.path.get(index);
    // }

    /**
     * Soustract the amount of damages of the balloon
     * 
     * @param damage
     */
    public void decreaseHealth(int damage) {
        this.health -= damage;
    }

    /**
     * Soustract a amount of speed to the balloon 
     * 
     * @param malus
     * 
     */
    public void decreaseSpeed(int malus) {
        this.speed -= malus;
    }

    /**
     * Verify if the health of the balloon is lower than zero
     * 
     * @return a boolean
     */
    public boolean isDead() {
        return this.health <= 0;
    }

    /**
     * Increase the speed of the balloon
     * 
     * @param speed
     */
    public void increaseSpeed(int bonus) {
        this.speed += bonus;
    }

    /**
     * Move the balloon
     * 
     * @param nb_pixels
     */
    public void move(int nb_pixels) {
        this.distanceTravelled += nb_pixels;
    }
}
