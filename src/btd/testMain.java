package btd;

import btd.Boards.Board;

public abstract class testMain {

    public static void main(String[] args) {
        Board board = new LinearBoard(20,20);
        board.show();
    }
}
