
package btd.utils;

import btd.boards.*;
public class MainClassic {

    public static void main(String[] args) {
        System.out.println();
        Board board2 = new ClassicBoard(4, 12);
        board2.show();
        Game game = new Game(board2);
        game.playRound();
    }
}
