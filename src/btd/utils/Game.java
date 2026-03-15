package btd.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Scanner;

import btd.boards.*;
import btd.towers.towers.BombTower;
import btd.towers.towers.DartTower;
import btd.towers.towers.IceTower;
import btd.towers.towers.SlowTower;
import btd.towers.towers.SniperTower;
import btd.towers.towers.SuperTower;
import btd.towers.towers.TackTower;
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

    /** The scanner for input */
    private final Scanner SCANNER;
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
        this.SCANNER = new Scanner(System.in);
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
        this.SCANNER = new Scanner(System.in);
    }

    /**
     * Return player
     * @return Player 
     */
    public Player getPlayer(){
        return this.player;
    }
    private int getInput(String a) throws NoSuchElementException{
        System.out.print(a);
        String var = SCANNER.nextLine();
        try{
            return Integer.parseInt(var);
        }
        catch(NumberFormatException e) {
            throw new NoSuchElementException("Input is not int");
        }
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
        
        System.out.println("=== Starting Round " + this.round + " ===");
        this.actualizeBalloons(nbBalloons);
        int i = 0;
        int time = 0;
        board.displayBoard();
        System.out.println("===== Step 1 : player plays");
        boolean roundStarted = false;
        while (!roundStarted) {
            List<Tower> existingTowers = new ArrayList<>();
            existingTowers.add(new IceTower(null));existingTowers.add(new SlowTower(null));
            existingTowers.add(new BombTower(null));existingTowers.add(new DartTower(null));
            existingTowers.add(new SniperTower(null));existingTowers.add(new SuperTower(null));
            existingTowers.add(new TackTower(null));
            List<String> actions = displayChoice(existingTowers);
            
            try {
                int input = getInput("\t\tchoice ?\n");
                if (input >= 0 && input < actions.size()) {
                    System.out.println("Executing action : " + actions.get(input));
                }
                switch (input) {
                case 0:
                    roundStarted=!roundStarted;
                    break;
                case 1:
                    board.displayBoard();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Warning: Not in the list of actions");
                    break;
                }
            } catch (NoSuchElementException e) {
                System.out.println("ERROR : Invalid input ");
            }
        }
        System.out.println("===== Step 2 : spawn ballons");
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
    /** Display the choice of action for the player
     * function returns the list of labels for the choice, in order to be used in the main function
     * For example, if in the list existingTowers we have a BombTower and a DartTower, the display will be :
     *      0 - start round
     *      1 - view
     *      2 - buy a new BombTower (cost: 500) 
     *      3 - buy a new DartTower (cost: 300)
     *  and function will return the list ["start round", "view", "buy a new BombTower (cost: 500)", "buy a new DartTower (cost: 300)"]
     * @param existingTowers the list of towers already existing in the game
     * @return List<String> the list of labels for the choice, in order to be used in the main function
     */
    private List<String> displayChoice(List<Tower> existingTowers){
        List<String> labels = new ArrayList<>();
        labels.add("start round");
        labels.add("view");
        for (Tower t : existingTowers) {
            labels.add("buy a new " + t.getClass().getSimpleName() + " (cost: " + t.getTotalValue() + ")");
        }
        System.out.println("Which action ?");
        for (int i=0; i < labels.size();i++){
            System.out.printf("\t%d - %s%n",i , labels.get(i));
        }
        return labels;
    }
}
