package btd;

public class Bloons {

    // The health of the bloon
    protected int heath;
    // The speed of the bloon
    protected int speed;
    // Distance travelled by the bloon
    protected float distance_travelled;
    // The next Cell of the bloon
    protected Cell next_cell;
    // the path that the bloon have to respect
    protected List<Cell> path;
    //the currentt celle of the bloon
    protected Cell current_cell;

    // Construct a new Bloons object 
    public Bloons(int health, float speed , List<Cell> path ){
        this.heath= health;
        this.speed = speed;
        this.path = path;
        this.distance_travelled = 0;
        this.current_cell = this.path;
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
    
    
}
