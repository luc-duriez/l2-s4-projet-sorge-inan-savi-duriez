package btd.utils;

import btd.boards.*;

/** Main classic mode */
public class MainClassic {

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println(
                    "Le programme nécessite 3 arguments: <x> <y> <b>\n\t<x> Largeur du plateau\n\t<y> Hauteur du plateau");
        } else {
            System.out.println();
            Board board = new ClassicBoard(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
            Game game = new Game(board);
            game.play();
        }
    }
}