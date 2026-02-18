
package btd.utils;


import java.util.Random;

import btd.boards.*;
import btd.towers.*;
public class MainClassic {

    public static void main(String[] args) {
        if (args.length != 3){
            System.out.println("Le programme nécessite 3 arguments: <x> <y> <b>\n\t<x> Largeur du plateau\n\t<y> Hauteur du plateau\n\t<b> Nombre de balloons");
        }
        else{
            System.out.println();
            Board board = new ClassicBoard(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
            
            Game game = new Game(board);

            Random r= new Random();
            int x1 = r.nextInt(Integer.parseInt(args[0]));
            int x2 = r.nextInt(Integer.parseInt(args[1]));

            while (!(board.isPlaceable(x1, x2))){
                x1 = r.nextInt(Integer.parseInt(args[0]));
                x2 = r.nextInt(Integer.parseInt(args[1]));
            }
            
            Tower t = new SniperTower(board.getCell(x1, x2));
            game.addTower(t);
            board.show();
            game.playRound(Integer.parseInt(args[2]));
        }
    }
}
