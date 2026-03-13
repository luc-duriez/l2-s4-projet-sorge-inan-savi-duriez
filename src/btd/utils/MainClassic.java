
package btd.utils;

import java.util.List;
import java.util.Random;

import btd.boards.*;
import btd.towers.towers.*;
import btd.towers.upgrades.*;

/** Main classic mode */
public class MainClassic {

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
        if (args.length != 3) {
            System.out.println(
                    "Le programme nécessite 3 arguments: <x> <y> <b>\n\t<x> Largeur du plateau\n\t<y> Hauteur du plateau\n\t<b> Nombre de balloons");
        } else {
            System.out.println();
            Board board = new ClassicBoard(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
            Game game = new Game(board);
            try {
                for (int i = 0; i < 2; i++) {
                    DamageTower tower= new BombTower(findUnusedCell(board, Integer.parseInt(args[0]), Integer.parseInt(args[1])));
                    game.addTower(tower);
                    tower.upgrade(tower.getRemainingUpgrade().get(0), game.getPlayer());
                    System.out.println("BombTower added");
                    tower = new DartTower(findUnusedCell(board, Integer.parseInt(args[0]), Integer.parseInt(args[1])));
                    game.addTower(tower);
                    tower.upgrade(tower.getRemainingUpgrade().get(0), game.getPlayer());
                    System.out.println("DartTower added");
                    game.addTower(new IceTower(findUnusedCell(board, Integer.parseInt(args[0]), Integer.parseInt(args[1]))));
                    tower.upgrade(tower.getRemainingUpgrade().get(0), game.getPlayer());
                    System.out.println("IceTower added");
                    game.addTower(new SlowTower(findUnusedCell(board, Integer.parseInt(args[0]), Integer.parseInt(args[1]))));
                    tower.upgrade(tower.getRemainingUpgrade().get(0), game.getPlayer());
                    System.out.println("SlowTower added");
                    tower = new SniperTower(findUnusedCell(board, Integer.parseInt(args[0]), Integer.parseInt(args[1])));
                    game.addTower(tower);
                    tower.upgrade(tower.getRemainingUpgrade().get(0), game.getPlayer());
                    System.out.println("SniperTower added");
                    tower = new SuperTower(findUnusedCell(board, Integer.parseInt(args[0]), Integer.parseInt(args[1])));
                    game.addTower(tower);
                    tower.upgrade(tower.getRemainingUpgrade().get(0), game.getPlayer());
                    System.out.println("SuperTower added");
                    tower = new TackTower(findUnusedCell(board, Integer.parseInt(args[0]), Integer.parseInt(args[1])));
                    game.addTower(tower);
                    tower.upgrade(tower.getRemainingUpgrade().get(0), game.getPlayer());
                    System.out.println("TackTower added");
                }
                
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
            
            board.displayBoard();
            for(int i = 1; i < 6; i++){
                game.playRound(Integer.parseInt(args[2]) * i);
            }
            for (int i = 0; i < board.getTowers().size(); i++) {
                // Copie de la référence de liste de Tower de board
                Tower currentTower = board.getTowers().get(i);
                
                if (currentTower instanceof DamageTower) {
                    DamageTower dmgTower = (DamageTower) currentTower;

                    System.out.println("The upgrade " + dmgTower.getAppliedUpgrade().get(0) + " has been reverted from the " + dmgTower.toString());
                    dmgTower.revertUpgrade(dmgTower.getAppliedUpgrade().get(0), game.getPlayer());
                }
            }
            // t.displayRemainingUpgrade();
            // t.diplayAppliedUpgrade();
            // t.revertUpgrade(t.getAppliedUpgrade().get(0), game.getPlayer());
            // t.diplayAppliedUpgrade();
            // t.displayRemainingUpgrade();
        }   
    }
}