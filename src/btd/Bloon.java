package btd;

import java.util.List;

public class Bloon {

    // The health of the bloon
    protected int heath;
    // The speed of the bloon
    protected float speed;
    // Distance travelled by the bloon
    protected float distance_travelled;
    // The next Cell of the bloon
    protected Cell next_cell;
    // the path that the bloon have to respect
    protected List<Cell> path;
    //the currentt celle of the bloon
    protected Cell current_cell;
    // the amount of pixels
    protected int pixel;

    // Construct a new Bloons object 
    public Bloon(int health, float speed , List<Cell> path ){
        this.heath= health;
        this.speed = speed;
        this.path = path;
        this.distance_travelled = 0;
        this.current_cell = this.path.get(0);
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

    public float get_speed(){
        return this.speed;
    }
    
    /**
     * returns the current cell of the bloon
     */
    public Cell current_cell(){
        return this.current_cell;
    }

    /**
     * Soustrac the amount of damages to the bloon
     * @param damage
     * @return the remaining heath
     */

    public int decreaseLife(int damage){
        return this.heath - damage;
    }
    
}
