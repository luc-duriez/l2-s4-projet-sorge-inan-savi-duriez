
package btd.utils;

import btd.boards.*;
public class Main {

    public static void main(String[] args) {
        Board board = new LinearBoard(4, 12,3);
        board.show();
        System.out.println();
        Board board2 = new ClassicBoard(4, 12);
        board2.show();
    }
}
