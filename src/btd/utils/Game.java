package btd.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.ErrorManager;

import btd.boards.*;
import btd.towers.towers.*;

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
            throw new NoSuchElementException("ERROR : Invalid input");
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
    public void buyTower(Tower t) {
        if(!player.hasEnoughCredits(t.getTotalValue())){
            throw new NoSuchElementException("pas de thune et sami fais l'exception. Merci");
        }
        board.addTower(t);
        board.getCell(t.getCell().getX(), t.getCell().getY()).setState(StateCell.TOWER);
        player.addCredits(-t.getTotalValue());
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
     * Manage the player's choice
     */
    private void playerChoice(){
        boolean roundStarted = false;
        while (!roundStarted) {
            List<String> actions = displayChoice(0); // A refaire
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
                        player.displayStats();
                        board.displayBoard();
                        break;
                    case 2:
                        buyTowerChoice();
                        break;
                    case 3:
                        sellTowerChoice();
                        break;
                    case 4:
                        //upgradeTowerChoice();
                        break;
                    default:
                        throw new NoSuchFieldError("Warning: Not in the list of actions");              
                }
            }
            catch (NoSuchElementException e) {
                System.out.println(e.getMessage());
            }
            catch (NoSuchFieldError e){
                System.out.println(e.getMessage());
            }
            
        }
    }
    

    private void buyTowerChoice(){
        List<String> actions =displayChoice(1);
        boolean choice = false;
        while (!choice){
            try{
                int input = getInput("\t\tchoice ?\n");
                if (input ==0){
                    choice=true;
                }
                else{
                    if (input >= 0 && input < actions.size()) {
                        int x, y;
                        do{
                            x = getInput("x ? ");
                            y = getInput("y ? ");
                        }while(!board.isPlaceable(x, y));
                        Cell cell = board.getCell(x, y);
                        List<Tower> liste = List.of(
                            new IceTower(cell), new BombTower(cell), new SlowTower(cell),
                            new DartTower(cell), new SniperTower(cell), new SuperTower(cell),
                            new TackTower(cell));
                        Tower t = liste.get(input-1);
                        buyTower(t);
                        choice = true;
                    }else{
                        
                    }
                }
            }catch(NoSuchElementException e){
                System.out.println(e.getMessage());
            }
        }
    }

    private void sellTowerChoice(){
        List<String> actions = displayChoice(2);
        boolean choice = false;
        while (!choice){
            try{
                int input = getInput("\t\tchoice ?\n");
                if (input ==0){
                    choice=true;
                }
                if (input > 0 && input < actions.size()) {
                    Tower t = board.getTowers().get(input-1);
                    System.out.printf("%s has been sold (%d -> %d) ", t, player.getCredits(), player.getCredits()+t.getTotalValue());
                    player.addCredits(t.getTotalValue());
                    board.getTowers().remove(input-1);
                    choice = true;
                    }
            }catch(NoSuchElementException e){
                System.out.println(e.getMessage());
            }
        }
    }
    
    
            
    /**
     * Play a round
     * @param nbBalloons the number of balloons to spawn in this round
     */
    public void playRound(int nbBalloons) {
        int time = 0;
        this.actualizeBalloons(nbBalloons); // waiting balloons
        
        System.out.println("===== Step 2 : spawn ballons");
        int i = 0;
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
        //
        if (!player.isDead()){
            System.out.println("\nRound cleared !");
            player.displayStats();
        }
    }

    /**
     * Play a game of Bloons Tower Defense.
     */
    public void play(){
        while (!player.isDead()){
            System.out.println("\n\n\n=== Starting Round " + this.round + " ===");
            board.displayBoard();
            System.out.println("\n===== Step 1 : player plays");
            playerChoice();
            playRound(round*2);
            this.round++;
        }
        System.out.println("\n=== Game Finished ===");
        player.displayStats();
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
    private List<String> displayChoice(int nb){
        List<String> list = new ArrayList<>();
        switch (nb){
            case 0: //Actions de base
                list.add("start round");
                list.add("view");
                list.add("buy Tower");
                list.add("sell Tower");
                list.add("upgrade Tower");
                break;
            case 1: //Achat Towers
                List<Tower> t1 = List.of(
                new IceTower(null), new BombTower(null), new SlowTower(null),
                new DartTower(null), new SniperTower(null), new SuperTower(null),
                new TackTower(null));
                list.add("return");
                for (Tower t : t1) {
                    list.add("buy a new " + t.getClass().getSimpleName() + " (cost: " + t.getTotalValue() + ")");
                }
                break;
            case 2: //Vente Towers
                List<Tower> t2 = board.getTowers();
                list.add("return");
                for (Tower t : t2) {
                    list.add(String.format("sell %s for %d credits", t, t.getTotalValue()));
                }
                break;
            /*
            case 3: // Upgrade Towers
                for(Towert: board.getTowers()){
                    if (t.)
                }
                List<Tower> t3 = board.getTowers();
                list.add("return");
                for (Tower t : t3) {
                    list.add(String.format("sell %s for %d", t, t.getTotalValue()));
                }*/

        }


        System.out.println("Which action ?");
        for (int i=0; i < list.size();i++){
            System.out.printf("\t%d - %s%n",i , list.get(i));
        }
        return list;
    }
}
