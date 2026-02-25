package btd.utils;

import btd.boards.Cell;
import java.util.List;
import java.util.Random;

public class Balloon {

    // The index of the balloon used in specifical round
    private int index;
    // The health of the balloon
    private int health;
    // The speed of the balloon
    private double speed;
    // Distance travelled by the balloon
    private double distanceTravelled;
    // the path of the balloon
    private List<Cell> path;
    // the current cell of the balloon
    private Cell currentCell;
    // the current slow value of the balloon
    private double slowValue;
    // the countdown of the balloon when it's slowed or frozen
    private int countdown;

    /**
     * Build a balloon of a given health, speed, path and index
     * 
     * @param health this balloon's health
     * @param speed this balloon's speed
     * @param path this balloon's path
     * @param index this balloon's index
    */ 
    public Balloon(int health, double speed, List<Cell> path, int index) {
        Random r = new Random();
        this.health = health;
        this.speed = speed * (1 + r.nextInt(3));
        this.path = path;
        this.distanceTravelled = 0;
        this.currentCell = path.get(0);
        this.index = index;
        this.countdown = 0;
        this.slowValue = 1;
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
     * Return the index of the balloon
     * 
     * @return int
     */
    public int getIndex() {
        return this.index;
    }

    /**
     * Return the distance travelled of the balloon
     * 
     * @return int
     */
    public double getDistanceTravelled() {
        return this.distanceTravelled;
    }

    /**
     * Return the path of this Balloon
     * @return the path of this Balloon
     */
    public List<Cell> getPath(){
        return this.path;
    }

    /**
     * Return the current cell of this Balloon
     * @return the current cell of this Balloon
     */
    public Cell getCurrentCell(){
        return this.currentCell;
    }

    /**
     * Return the current countdown of the Balloon
     * 
     * @return the current countdown of the Balloon
     */
    public int getCountdown(){
        return this.countdown;
    }

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
     * @param speed the amount of speed decreased
     * 
     */
    public void changeSpeed(double changespeed) {
        this.speed += changespeed;
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
     * Move the balloon
     */
    public void move() {
        if (countdown == 0){
           this.distanceTravelled += this.slowValue * this.speed; 
        }else{
            countdown--;
        }
        if (this.getIndexPosition() < this.path.size()) {
            this.currentCell = this.path.get(this.getIndexPosition());
        } else {
            this.currentCell = this.path.get(this.path.size() - 1); // Si on est sur l'avant derniere case et que l'on avance de plus d'une case
        }
}

    /**
     * Returns the index of this Balloon in the path
     * @return the index of this Balloon in the path
     */
    public int getIndexPosition(){
        return (int) (this.distanceTravelled / Cell.SIZE);
    }

    /**
     * Returns true if the object is equal to this Balloon
     * @param o The object to compare this Balloon with
     * @return true if the object is equal to this Balloon
     */
    public boolean equals(Object o){
        if(!(o instanceof Balloon)){
            return false;
        }
        Balloon b = (Balloon) o;
        return (this.health == b.getHealth()) && (this.speed == b.getSpeed()) && (this.distanceTravelled == b.getDistanceTravelled()) && (this.path.equals(b.getPath())) && (this.currentCell.equals(b.getCurrentCell())) && (this.getIndex() == b.getIndex());
    }

    /**
     * Return a String representation of this Balloon with numbering
     */
    public String toString(){
        return "Balloon " + this.index + " at " + this.currentCell + " hp : " + this.health;
    }

    /**
     * Returns true if the balloon has finished the path
     * @return boolean
     */
    public boolean hasFinished(){
        return this.distanceTravelled >= (this.path.size() * Cell.SIZE);
    }

    /**
     * Display the Balloon at spawn
     */
    public void displaySpawn(){
        System.out.printf("Balloon Incoming !!!  %s speed: %.1f%n", this, getSpeed());
    }

    /**
     * Display the Balloon when touched
     */
    public void displayTouched(){
        System.out.printf( "%s touched %n", this);
    }

    /**
     * Display the Balloon when popped
     */
    public void displayPopped(){
        System.out.printf("%s popped%n", this);
    }

    /**
     * Set this balloon's slow value to slow plower
     */
    public void setSlowValue(double slowPower) {
        this.slowValue = slowPower;
    }

    /**
     * Set this balloon's countdown to countdown2
     */
    public void setCountdown(int countdown2) {
        this.countdown = countdown2;
    }

    /**
     * Display the Balloon when the balloon finish his path.
     */
    public void displayFinished(){
        System.out.printf("%s passed !! -%d Lives\n", this, getHealth());
    }
}
