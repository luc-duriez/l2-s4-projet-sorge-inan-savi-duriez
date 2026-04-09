
package btd.utils;

import btd.boards.*;

public class MainLinear {
    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println(
                    "Le programme nécessite 4 arguments <x> <y> <n>\n\t<x> Largeur du plateau\n\t<y> Hauteur du plateau\n\t<n> Nombre de chemin");
            return;
        }
        Board board = new LinearBoard(Integer.parseInt(args[0]), Integer.parseInt(args[1]), Integer.parseInt(args[2]));
        Game game = new Game(board);
        game.play();
    }
}
