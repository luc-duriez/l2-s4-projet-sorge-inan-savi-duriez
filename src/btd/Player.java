package btd;

public class Player {
    /* Remains credits of player */
    private int credits;
    /* Remains lives of player */
    private int lives;

    /* Constructor of Player with 0 parameter*/
    public Player(){
        this.credits=2000;
        this.lives=20;
    }
    /**
     * Constructor of Player with 2 parameters
     * @param credits : int
     * @param lives : int 
     */
    public Player(int credits, int lives){
        this.credits=credits;
        this.lives=lives;
    }
}
