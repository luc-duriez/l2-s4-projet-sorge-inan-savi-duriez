
package btd.utils;

import btd.boards.*;
public class MainLinear {

    public static void main(String[] args) {
        System.out.println();
        Board board2 = new LinearBoard(4, 12, 3);
        board2.show();
        Game game = new Game(board2);
        game.playRound();
    }
}
