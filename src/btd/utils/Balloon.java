package btd.utils;

import btd.boards.Cell;
import java.util.List;

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

    // Constructer of Balloon object
    public Balloon(int health, double speed, List<Cell> path, int index) {
        this.health = health;
        this.speed = speed;
        this.path = path;
        this.distanceTravelled = 0;
        this.currentCell = path.get(0);
        this.index = index;
    }

    public Balloon(int health, double speed, int index) {
        this.health = health;
        this.speed = speed;
        this.path = null;
        this.distanceTravelled = 0;
        this.currentCell = null;
        this.index = index;
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
     * @param malus the amount of speed decreased
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
     * @param bonus speed increased
     */
    public void increaseSpeed(int bonus) {
        this.speed += bonus;
    }

    /**
     * Move the balloon
     */
    public void move() {
    this.distanceTravelled += this.speed;
    
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
     * Add the path in ballon
     * @param path the path of the baloons
     */
    public void addPath(List<Cell> path) throws IllegalStateException{
        if (this.path.size()==1){
            throw new IllegalStateException("Un ballon ne peut avoir qu'un seul chemin");
        }
        this.path = path;
    }

    /**
     * Return a String representation of this Balloon with numbering
     */
    public String toString(){
        return "Balloon " + this.index + " at " + this.currentCell;
    }

    /**
     * Returns true if the balloon has finished the path
     * @return boolean
     */
    public boolean hasFinished(){
        return this.distanceTravelled >= (this.path.size() * Cell.SIZE);
    }
}
