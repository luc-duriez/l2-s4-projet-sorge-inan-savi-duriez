package btd.utils;

/**
 * Represents a player during the game.
 */
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
    /**
     * Getter of credits
     * @return credits : int
     */
    public int getCredits(){
        return this.credits;
    }
    /**
     * Getter of lives
     * @return lives : int
     */
    public int getLives(){
        return this.lives;
    }
    /**
     * Add amount of credits and return this value
     * @param amount : int
     * @return new amount : int
     */
    public int addCredits(int amount){
        return this.credits+=amount;
    }

    /**
     * Remove amount of credits
     * if the player has enough credit, returns true, false otherwise
     * @param amount : int
     * @return boolean 
     */
    public boolean removeCredits(int amount){
        if (0 < amount && this.credits >= amount) {
            this.credits -= amount;
            return true;
        }
        return false;
    }
    /**
     * Remove amount of lives.
     * if the player has enough lives, returns true, false otherwise
     * @param amount : int
     * @return boolean 
     */
    public boolean removeLife(int amount){
        if (0 < amount && this.lives >= amount) {
            this.lives -= amount;
            return true;
        }
        return false;
    }
}
