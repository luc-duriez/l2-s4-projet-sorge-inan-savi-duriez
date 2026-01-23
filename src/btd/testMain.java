package btd;

import btd.boards.*;

public abstract class testMain {

    public static void main(String[] args) {
        Board board = new LinearBoard(20,20);
        board.show();
    }
}
