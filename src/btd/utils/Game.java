package btd.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import btd.boards.Board;

public class Game {
    
    /* This Game's Player */
    private Player player;

    /* This Game's board */
    private Board board;

    /* This Game's numbers of rounds */
    public int round;

    /* List of balloons waiting in a specific round */
    private List<Balloon> waitingBalloons;

    /* List of active balloons in a specific round */
    private List<Balloon> activeBalloons;

    /**
     * Build a Game with a given board
     * 
     * @param board this game's board
     */
    public Game(Board board){
        this.player = new Player();
        this.board = board;
        this.round = 1;
        this.waitingBalloons = new ArrayList<Balloon>();
        this.activeBalloons = new ArrayList<Balloon>();
    }

    /**
     * Build a Game with a given board and player
     * 
     * @param board this game's board
     * @param player this game's board
     */
    public Game(Board board, Player player){
        this.player = player;
        this.board = board;
        this.round = 1;
        this.waitingBalloons = new ArrayList<Balloon>();
        this.activeBalloons = new ArrayList<Balloon>();
    }

    /**
     * This function updates the waiting balloons. 
     * @param round : int
     */
    private void actualizeBalloons(int nbBalloons) {
        this.waitingBalloons = new ArrayList<Balloon>();
        double speed = 25;
        int health = 1 + (this.round / 5);

        Random r = new Random();
        
        for (int i = 0; i < nbBalloons; i++) {
            int nbPath = r.nextInt(this.board.getPath().size());
            Balloon b = new Balloon(health, speed, this.board.getPath().get(nbPath), i+1);
            this.waitingBalloons.add(b);
        }
    }
    
    /**
     * Play a round
     */
    public void playRound(int nbBalloons){
        System.out.println("=== Round " + this.round + " ===");
        this.actualizeBalloons(nbBalloons);
        int i=0;
        int time = 0;
        while (i < this.waitingBalloons.size() || !this.activeBalloons.isEmpty()) {
            System.out.println("---- time: " + time);
            System.out.println("---- balloons positions");
            if (i < this.waitingBalloons.size()) {
                Balloon b = this.waitingBalloons.get(i);
                this.activeBalloons.add(b);
                i++;
                System.out.print("Balloon Incoming !!!  " + b + " speed: " + b.getSpeed() + " health: " + b.getHealth() + "\n");
            }
            

            displayActiveBalloons();
            for (int j = 0; j < this.activeBalloons.size(); j++){
                Balloon b = this.activeBalloons.get(j);
                if (b.hasFinished()){
                    this.activeBalloons.remove(j);
                    this.player.removeLife(b.getHealth());
                    j--;
                }
                b.move();
            }
            time += 100;
        }
        this.round++;
        System.out.println("\n-- Round cleared --");
        System.out.println("Money after round: " + this.player.getCredits());
        System.out.println("Lives after round: " + this.player.getLives());
    }

    /**
     * Display this game's list of active balloons.
     */
    public void displayActiveBalloons(){
        for (Balloon b: this.activeBalloons){
            System.out.println( b.toString());
        }
    }
}
