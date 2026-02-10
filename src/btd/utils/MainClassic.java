
package btd.utils;

import btd.boards.*;
import btd.towers.*;
public class MainClassic {

    public static void main(String[] args) {
        if (args.length != 3){
            System.out.println("Le programme nécessite 3 arguments: <x> <y> <b>\n\t<x> Largeur du plateau\n\t<y> Hauteur du plateau\n\t<b> Nombre de balloons");
        }else{
            System.out.println();
            Board board2 = new ClassicBoard(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
            board2.show();
            Game game = new Game(board2);
            game.playRound(Integer.parseInt(args[2]));
            /*
            Balloon b = new Balloon(100, 25, board2.getPath().get(0), 0);
            System.out.println(b + " health: " + b.getHealth() + "\n");
            Tower t = new DartTower(null);
            Tower t1 = new TackTower(null);
            Tower t2 = new IceTower(null);
            Tower t3 = new SlowTower(null);
            Tower t4 = new SniperTower(null);
            Tower t5 = new SuperTower(null);
            Tower t6 = new BombTower(null);
            t.shoot(b);
            System.out.print(b + " health: " + b.getHealth() + "\n");
            t1.shoot(b);
            System.out.print(b + " health: " + b.getHealth() + "\n");
            t2.shoot(b);System.out.print(b + " health: " + b.getHealth() + "\n");
            t3.shoot(b);System.out.print(b + " health: " + b.getHealth() + "\n");
            t4.shoot(b);System.out.print(b + " health: " + b.getHealth() + "\n");
            t5.shoot(b);System.out.print(b + " health: " + b.getHealth() + "\n");
            t6.shoot(b);
            System.out.print(b + " health: " + b.getHealth() + "\n"); 
            */
        }
    }
}
