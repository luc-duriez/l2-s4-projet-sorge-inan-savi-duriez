package btd;

import java.util.List;

public class Balloon {

    // The health of the baloon
    private int health;
    // The speed of the baloon
    private double speed;
    // Distance travelled by the baloon
    private int distanceTravelled;
    // The next Cell of the baloon
    private Cell nextCell;
    // the path that the baloon have to respect
    private List<Cell> path;
    //the currentt celle of the baloon
    private Cell currentCell;
    
    // Construct a new Baloons object 
    public Balloon(int health, int speed , List<Cell> path ){
        this.health= health;
        this.speed = speed;
        this.path = path;
        this.distanceTravelled = 0;
    }
    /**
     * returns the health of the baloon
     * @return int 
     */

    public int getHealth(){
        return this.health;
    }
    /**
     * returns the speed of the baloon
     * @return float 
     */

    public int getSpeed(){
        return this.speed;
    }

    /**
     * returns the distance travelled by the baloon
     * @return int 
     */

    public int getDistanceTravelled(){
        return this.distanceTravelled;
    }
    
    // /**
    //  * returns the current cell of the baloon
    //  */
    // public Cell current_cell(){
    //     int index = this.distance_travelled / 100;
    //     return this.path.get(index);
    // }

    /**
     * Soustrac the amount of damages to the baloon
     * @param damage
     */

    public void decreaseHealth(int damage){
        this.health -= damage;
    }


    /**
     * Soustrac a amount of speed to the baloon to the baloon
     * @param malus
     * 
     */

    public void decreaseSpeed(int malus){
        this.speed -= malus;
    }


    /**
     * Verify if the health of the baloon is lower than zero
     * @return a boolean
     */

    public boolean isDead(){
        return this.health > 0;
    }


    /**
     * Increase the speed of the baloon
     * @param speed
     */

    public void increaseSpeed(int bonus){
        this.speed += bonus;
    }


    /**
     * move the baloon
     * @param 
     */

    public void move(int nb_pixels){
        this.distanceTravelled += nb_pixels;
    }
}
