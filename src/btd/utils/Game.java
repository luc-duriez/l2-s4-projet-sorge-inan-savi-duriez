package btd.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import btd.boards.*;
import btd.towers.towers.Tower;

/**
 * Manages the game logic including rounds, balloons and towers.
 */
public class Game {
    /** Tick rate */
    public static final int TICK = 100;
    /** This Game's Player */
    private Player player;

    /** This Game's board */
    private Board board;

    /** This Game's numbers of rounds */
    public int round;

    /** List of balloons waiting in a specific round */
    private List<Balloon> waitingBalloons;

    /** List of active balloons in a specific round */
    private List<Balloon> activeBalloons;

    /**
     * Build a Game with a given board
     * @param board this game's board
     */
    public Game(Board board) {
        this.player = new Player();
        this.board = board;
        this.round = 1;
        this.waitingBalloons = new ArrayList<Balloon>();
        this.activeBalloons = new ArrayList<Balloon>();

    }

    /**
     * Build a Game with a given board and player
     * @param board this game's board
     * @param player this game's player
     */
    public Game(Board board, Player player) {
        this.player = player;
        this.board = board;
        this.round = 1;
        this.waitingBalloons = new ArrayList<Balloon>();
        this.activeBalloons = new ArrayList<Balloon>();
    }

    /**
     * Return player
     * @return Player 
     */
    public Player getPlayer(){
        return this.player;
    }

     /**
     * Return the square of distance of two points
     * @param c1 The first Cell
     * @param c2 The second Cell
     * @return double
     */
    public static double distanceSquaredOf(Cell c1, Cell c2) {
        int dx = (c2.getX() - c1.getX()) * Cell.SIZE;
        int dy = (c2.getY() - c1.getY()) * Cell.SIZE;
        return dx * dx + dy * dy;
    }
    
    /**
     * Add t in board.
     * @param t Tower
     */
    public void addTower(Tower t) {
        board.addTower(t);
        board.getCell(t.getCell().getX(), t.getCell().getY()).setState(StateCell.TOWER);
    }
    
    /**
     * This function updates the waiting balloons.
     * @param nbBalloons the number of balloons to update
     */
    private void actualizeBalloons(int nbBalloons) {
        this.waitingBalloons = new ArrayList<Balloon>();
        double speed = 25;
        int health = 2 + (this.round / 2);
        Random r = new Random();

        for (int i = 0; i < nbBalloons; i++) {
            int nbPath = r.nextInt(this.board.getPath().size());
            Balloon b = new Balloon(health, speed, this.board.getPath().get(nbPath), i + 1);
            this.waitingBalloons.add(b);
        }
    }

    /**
     * Make all tower shoot and display the shot.
     */
    private void towerShoot() {
        for (Tower t : board.getTowers()) {
            List<Balloon> touchedBallon = t.shoot(t.getBalloonsInRange(activeBalloons));
            for (Balloon b : touchedBallon) {
                if (b.getHealth() <= 0) {
                    activeBalloons.remove(b);
                    b.displayPopped();
                }
            }
        }
    }
    
    /**
     * Play a round
     * @param nbBalloons the number of balloons to spawn in this round
     */
    public void playRound(int nbBalloons) {
        
        System.out.println("=== Round " + this.round + " ===");
        this.actualizeBalloons(nbBalloons);
        int i = 0;
        int time = 0;
        while (i < this.waitingBalloons.size() || !this.activeBalloons.isEmpty()) { // Mouvement des ballons
            System.out.println("\n---- time: " + time);
            Balloon newBalloon = null;
            if (i < this.waitingBalloons.size()) {
                newBalloon = this.waitingBalloons.get(i);
                Balloon b = this.waitingBalloons.get(i);
                this.activeBalloons.add(b);
                i++;
            }
            for (int j = 0; j < this.activeBalloons.size(); j++) { // Verification si ballons ont fini parcours
                Balloon b = this.activeBalloons.get(j);
                if (b.hasFinished()) {
                    b.displayFinished();
                    this.activeBalloons.remove(j);
                    this.player.decreaseLife(b.getHealth());
                    j--;
                } else {
                    b.move();
                }
            }
            System.out.println("---- balloons positions");
            if (newBalloon != null) {
                newBalloon.displaySpawn();
            }
            this.displayActiveBalloons();
            System.out.println("---- towers shots");
            towerShoot();
            time += Game.TICK;
            if (player.isDead()){
                System.out.println("GAME OVER !!"); // BREAK ?
            }
        }
        this.round++;

        if (player.isDead()){
            System.out.println("\n=== Game Finished ===");
        }
        else{
            System.out.println("\nRound cleared !");
        
        System.out.println("Player Lives: " + this.player.getLives());
        System.out.println("Player Credits: " + this.player.getCredits());
        }
    }

    /**
     * Display this game's list of active balloons.
     */
    public void displayActiveBalloons() {
        for (Balloon b : this.activeBalloons) {
            String status = "";
            if (b.getSlowValue() == 0) {
                status = " [FREEZE]";
            } else if (b.getSlowValue() < 1.0) {
                status = " [SLOW]";
            }
            System.out.println(b + " (health: " + b.getHealth() + ")" + status);
        }
    }
}
