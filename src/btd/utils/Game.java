package btd.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Scanner;

import btd.boards.*;
import btd.towers.towers.*;
import btd.towers.upgrades.Upgrade;

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

    /**
     * Displays a msg and reads an integer input from the console.
     * This method reads the entire input line. If the input cannot be 
     * parsed into a valid integer, a NoSuchElementException is thrown.
     *
     * @param msg The message to be displayed to the player.
     * @return The integer value entered by the player.
     * @throws NoSuchElementException If the input is not a valid integer.
     */
    private int getInput(String msg) throws NoSuchElementException{
        System.out.print(msg);
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
            List<String> list = new ArrayList<>();
            list.add("start round");
            list.add("view");
            list.add("buy Tower");
            list.add("sell Tower"); // a afficher seulement si au moins une tour est placé 
            list.add("buy upgrade Tower"); // a afficher seulement si une tour placé et a au moins une upgrade ou si tt upgrade sont pas deja mise
            list.add("sell upgrade Tower"); // a afficher seulement si une tour placé a au moins une upgrade d'appliqué
            List<String> actions = displayChoice(list);
            try {
                int input = getInput("\t\tchoice ?\n");
                if (input >= 0 && input < actions.size()) {
                    System.out.println("Executing action : " + actions.get(input));
                }
                switch (input) {
                    case 0: // start round
                        roundStarted=!roundStarted;
                        break;
                    case 1: // view
                        player.displayStats();
                        board.displayBoard();
                        break;
                    case 2: // buy Tower
                        buyTowerChoice();
                        break;
                    case 3: // sell Tower
                        sellTowerChoice();
                        break;
                    case 4: // buy upgrade Tower
                        buyUpgradeTowerChoice();
                        break;
                    case 5: // sell upgrade Tower
                        sellUpgradeTowerChoice();
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
        List<String> list = new ArrayList<>();
        List<Tower> placeableTowers = List.of(
            new IceTower(null), new BombTower(null), 
            new SlowTower(null), new DartTower(null),
            new SniperTower(null), new SuperTower(null),
            new TackTower(null));
            list.add("return");
        for (Tower tower : placeableTowers) {
            list.add("buy a new " + tower.getClass().getSimpleName() + " (cost: " + tower.getTotalValue() + ")");
        }
        List<String> actions =displayChoice(list);
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
                        Tower addedTower = placeableTowers.get(input-1);
                        addedTower.setCell(cell);
                        buyTower(addedTower); // Exception sami stp
                        choice = true;
                    }
                    else{
                        throw new NoSuchFieldError("Warning: Not in the list of actions");
                    }
                }
            }catch(NoSuchElementException e){
                System.out.println(e.getMessage());
            }
            catch (NoSuchFieldError e){
                System.out.println(e.getMessage());
            }
        }
    }

    private void sellTowerChoice(){
        List<String> list = new ArrayList<>();
        list.add("return");
        List<Tower> sellableTowers = board.getTowers();
        for (Tower towers : sellableTowers) {
            list.add(String.format("sell %s for %d credits", towers, towers.getTotalValue()));
        }
        List<String> actions = displayChoice(list);
        boolean choice = false;
        while (!choice){
            try{
                int input = getInput("\t\tchoice ?\n");
                if (input ==0){
                    choice=true;
                }
                if (input > 0 && input < actions.size()) {
                    
                    Tower sellTower = sellableTowers.get(input-1);
                    System.out.println(board.getTowers());
                    
                    System.out.printf("%s has been sold (%d -> %d)%n", sellTower, player.getCredits(), player.getCredits()+sellTower.getTotalValue()); // une fonction pr l'affichage ?
                    player.addCredits(sellTower.getTotalValue());
                    board.getTowers().remove(input-1);
                    sellTower.getCell().popState(); 
                    sellTower.getCell().switchIsOccupied(); // Si on est sur un Classic il faut le faire mais pas sur un Linear donc faut faire une fonction board.removeTower(Tower t) -> exception si pas dans la liste au cas ou svp
                    System.out.println(board.getTowers());
                    choice = true;
                }else{
                    throw new NoSuchFieldError("Warning: Not in the list of actions");
                }
            }catch(NoSuchElementException e){
                System.out.println(e.getMessage());
            }catch (NoSuchFieldError e){
                System.out.println(e.getMessage());
            }

        }
    }
    private void buyUpgradeTowerChoice() {
        List<String> list = new ArrayList<>();
        list.add("return");
        List<Tower> upgradableTower = board.getTowers();
        upgradableTower.removeIf(t -> t.getRemainingUpgrade().isEmpty());
        for (int i=0;i< upgradableTower.size();i++){
            list.add(String.format("%s",upgradableTower.get(i)));
        }
        List<String> actions = displayChoice(list);
        boolean choice = false;
        while (!choice){
            try{
                int input = getInput("\t\tchoice ?\n");
                if (input ==0){
                    choice=true;
                }
                if (input > 0 && input < actions.size()) {
                    whichUpgradeApplied(upgradableTower.get(input-1));
                }
                else{
                    throw new NoSuchFieldError("Warning: Not in the list of actions");
                }
            }catch(NoSuchElementException e){
                System.out.println(e.getMessage());
            }catch (NoSuchFieldError e){
                System.out.println(e.getMessage());
            }
        }
    }

    // private void sellUpgradeTowerChoice(){
    //     List<String> actions = displayChoice(4);
    //     boolean choice = false;
    //     while (!choice){
    //         try{
    //             int input = getInput("\t\tchoice ?\n");
    //             if (input ==0){
    //                 choice=true;
    //             }
    //             if (input > 0 && input < actions.size()) {
    //                 Tower t = board.getTowers().get(input-1);
    //                 t.revertUpgrade(t.getRemainingUpgrade().get(input-1),this.player);
    //                 choice = true;
    //                 }
    //         }catch(NoSuchElementException e){
    //             System.out.println(e.getMessage());
    //         }
    //     }
    // }

    // private void upgradeTowerChoice(){
    //     List<String> actions = displayChoice(5);
    //     boolean choice = false;
    //     while (!choice){
    //         try{
    //             int input = getInput("\t\tchoice ?\n");
    //             if (input ==0){
    //                 choice=true;
    //             }
    //             if (input > 0 && input < actions.size()) {
    //                 System.out.println("Executing action : " + actions.get(input));
    //                 switch (input){
    //                 case 1:
    //                     // buyUpgradeTowerChoice();
    //                     choice=true;
    //                     break;
    //                 case 2:
    //                     sellUpgradeTowerChoice();
    //                     choice=true;
    //                     break;
    //                 }
    //             }
    //         }catch(NoSuchElementException e){
    //             System.out.println(e.getMessage());
    //         }
    //     }
    // }
    
    
            
    private void whichUpgradeApplied(Tower tower) {
        // Gère l'upgrade de la tower
        throw new UnsupportedOperationException("Unimplemented method 'whichUpgradeApplied'");
    }


    private void sellUpgradeTowerChoice() {
        List<String> list = new ArrayList<>();
        list.add("return");
        List<Tower> revertableTower = board.getTowers();
        revertableTower.removeIf(t -> t.getAppliedUpgrade().isEmpty() );
        for (int i=0;i< revertableTower.size();i++){
            list.add(String.format("%s",revertableTower.get(i)));
        }
        List<String> actions = displayChoice(list);
        boolean choice = false;
        while (!choice){
            try{
                int input = getInput("\t\tchoice ?\n");
                if (input ==0){
                    choice=true;
                }
                if (input > 0 && input < actions.size()) {
                    whichUpgradeRevert(revertableTower.get(input));
                }
                else{
                    throw new NoSuchFieldError("Warning: Not in the list of actions");
                }
            }catch(NoSuchElementException e){
                System.out.println(e.getMessage());
            }catch (NoSuchFieldError e){
                System.out.println(e.getMessage());
            }
        }
    }
    private void whichUpgradeRevert(Tower tower) {
        // Gère le revert de la tower
        throw new UnsupportedOperationException("Unimplemented method 'whichUpgradeApplied'");
    }

    /**
     * Play a round
     * @param nbBalloons the number of balloons to spawn in this round
     */
    public void playRound(int nbBalloons) {
        int time = 0;
        this.actualizeBalloons(nbBalloons); // waiting balloons
        
        System.out.println("\n\n\n===== Step 2 : spawn ballons");
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
                System.out.println("GAME OVER !!"); // BREAK 
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
            System.out.println("\n\n=== Starting Round " + this.round + " ===");
            board.displayBoard();
            System.out.println("\n===== Step 1 : player plays");
            playerChoice();
            playRound(3);
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
    private List<String> displayChoice(List<String> list){
        switch (0){
            case 3: // select Tower to buy upgrade
                
                break;
            case 4: // select Tower to sell upgrade
                List<Tower> upgradedTower = board.getTowers();
                list.add("return");
                upgradedTower.removeIf(t -> t.getAppliedUpgrade().isEmpty() );
                for (int i=0;i< upgradedTower.size();i++){
                    Tower t = upgradedTower.get(i);
                    list.add(String.format("%s",t));
                }
                break;
            case 5:
                list.add("return");
                list.add("buy Upgrade");
                list.add("sell Upgrade");
        }



        System.out.println("Which action ?");
        for (int i=0; i < list.size();i++){
            System.out.printf("\t%d - %s%n",i , list.get(i));
        }
        return list;
    }
}
