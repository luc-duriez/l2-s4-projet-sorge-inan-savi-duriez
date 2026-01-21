package btd;

import java.util.List;

public class Bloon {

    // The health of the bloon
    protected int heath;
    // The speed of the bloon
    protected int speed;
    // Distance travelled by the bloon
    protected int distance_travelled;
    // The next Cell of the bloon
    protected Cell next_cell;
    // the path that the :!!;!!bloon have to respect
    protected List<Cell> path;
    //the currentt celle of the bloon
    protected Cell current_cell;
    // the amount of pixels
    protected int pixel;

    // Construct a new Bloons object 
    public Bloon(int health, int speed , List<Cell> path ){
        this.heath= health;
        this.speed = speed;
        this.path = path;
        this.distance_travelled = 0;
    }
    /**
     * returns the heath of the vloon
     * @return int 
     */

    public int get_heath(){
        return this.heath;
    }
    /**
     * returns the speed of the bloon
     * @return float 
     */

    public int get_speed(){
        return this.speed;
    }
    
    // /**
    //  * returns the current cell of the bloon
    //  */
    // public Cell current_cell(){
    //     int index = this.distance_travelled / 100;
    //     return this.path.get(index);
    // }

    /**
     * Soustrac the amount of damages to the bloon
     * @param damage
     */

    public void decreaseLife(int damage){
        this.heath -= damage;
    }


    /**
     * Soustrac a amount of speed to the bloon to the bloon
     * @param malus
     * 
     */

    public void decreaseSpeed(int malus){
        this.speed -= malus;
    }


    /**
     * Verify if the heath of the bloon is lower than zero
     * @return a boolean
     */

    public boolean isDead(){
        return this.heath > 0;
    }


    /**
     * Increase the speed of the bloon
     * @param speed
     */

    public void IncreaseSpeed(int bonus){
        this.speed += bonus;
    }


    /**
     * move the bloon
     * @param 
     */

    public void move(int nb_pixels){
        this.distance_travelled += nb_pixels;
    }
}
