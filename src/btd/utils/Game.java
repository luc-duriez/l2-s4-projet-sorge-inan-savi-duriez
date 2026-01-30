package btd.utils;

import btd.boards.Board;

public class Game {
    
    /*This Game's Player */
    private Player player;

    /*This Game's board */
    private Board board;

    /*This Game's numbers of rounds */
    private int round;

    /**
     * Build a Game with a given board
     * 
     * @param board this game's board
     */
    public Game(Board board){
        this.player = new Player();
        this.board = board;
        this.round = 1;
    }

    /**
     * Build a Game with a given board and player
     * 
     * @param board this game's board
     * @param palyer this game's board
     */
    public Game(Board board, Player player){
        this.player = player;
        this.board = board;
        this.round = 1;
    }

    /**
     * Spawn balloons in this game's board using this game's number of rounds
     */
    public void spawnBalloons(){
        this.board.spawnBalloons(this.round);
    }
    
    /**
     * Play a round
     */
    public void playRound(){
        spawnBalloons();
        while(!(this.board.getBalloons().isEmpty())){
            for(Balloon b: this.board.getBalloons()){
                b.move();
                if (b.hasFinished()){
                    this.board.getBalloons().remove(b);
                }
            }
        }
        this.round++;
    }
}

/*
-> Spawn des balloons en continue ? ou en un seul bloc.

TO DO:
    balloon -> hasFinished
*/
