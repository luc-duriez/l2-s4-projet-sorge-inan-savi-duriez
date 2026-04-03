
package btd.utils;

import java.util.Random;

import btd.boards.*;
import btd.exceptions.NotEnoughCreditsException;
import btd.towers.towers.*;

public class MainLinear {
    private static Cell findUnusedCell(Board board, int w, int h) throws RuntimeException {
        int x, y;
        Random r = new Random();
        int a = 100;
        do {
            if (a == 0) {
                throw new RuntimeException("Board cannot accommodate more towers");
            }
            x = r.nextInt(w);
            y = r.nextInt(h);
            a--;
        } while (!board.isPlaceable(x, y));
        return board.getCell(x, y);
    }
    public static void main(String[] args) {
        if (args.length != 4) {
            System.out.println(
                    "Le programme nécessite 4 arguments <x> <y> <b> <n>\n\t<x> Largeur du plateau\n\t<y> Hauteur du plateau\n\t<b> Nombre de Ballons \n\t<n> Nombre de chemin");
            return;
        }
        Board board = new LinearBoard(Integer.parseInt(args[0]), Integer.parseInt(args[1]), Integer.parseInt(args[3]));
        Game game = new Game(board);
        game.play();
    }
}
