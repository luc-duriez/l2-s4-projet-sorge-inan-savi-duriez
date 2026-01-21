package btd;

import java.util.List;

public class Baloon {

    // The health of the baloon
    private int health;
    // The speed of the baloon
    private int speed;
    // Distance travelled by the baloon
    private int distance_travelled;
    // The next Cell of the baloon
    private Cell next_cell;
    // the path that the baloon have to respect
    private List<Cell> path;
    //the currentt celle of the baloon
    private Cell current_cell;
    
    // Construct a new Baloons object 
    public Baloon(int health, int speed , List<Cell> path ){
        this.health= health;
        this.speed = speed;
        this.path = path;
        this.distance_travelled = 0;
    }
    /**
     * returns the health of the baloon
     * @return int 
     */

    public int get_health(){
        return this.health;
    }
    /**
     * returns the speed of the baloon
     * @return float 
     */

    public int get_speed(){
        return this.speed;
    }

    /**
     * returns the distance travelled by the baloon
     * @return int 
     */

    public int get_distance_travelled(){
        return this.distance_travelled;
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

    public void IncreaseSpeed(int bonus){
        this.speed += bonus;
    }


    /**
     * move the baloon
     * @param 
     */

    public void move(int nb_pixels){
        this.distance_travelled += nb_pixels;
    }
}
