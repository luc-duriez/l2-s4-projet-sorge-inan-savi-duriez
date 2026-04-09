
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
<<<<<<< HEAD
        game.getPlayer().changeCredits(10000);
        game.getPlayer().decreaseLife(-10000);
        try {
            for (int i = 0; i < 2; i++) {
                DamageTower tower= new BombTower(findUnusedCell(board, Integer.parseInt(args[0]), Integer.parseInt(args[1])));
                game.buyTower(tower);
                System.out.println("\nBombTower added");
                tower.upgrade(tower.getRemainingUpgrade().get(0), game.getPlayer());
                tower = new DartTower(findUnusedCell(board, Integer.parseInt(args[0]), Integer.parseInt(args[1])));
                game.buyTower(tower);
                System.out.println("\nDartTower added");
                tower.upgrade(tower.getRemainingUpgrade().get(0), game.getPlayer());                    
                game.buyTower(new IceTower(findUnusedCell(board, Integer.parseInt(args[0]), Integer.parseInt(args[1]))));
                System.out.println("\nIceTower added");
                tower.upgrade(tower.getRemainingUpgrade().get(0), game.getPlayer());     
                game.buyTower(new SlowTower(findUnusedCell(board, Integer.parseInt(args[0]), Integer.parseInt(args[1]))));
                tower.upgrade(tower.getRemainingUpgrade().get(0), game.getPlayer());
                System.out.println("\nSlowTower added");
                tower = new SniperTower(findUnusedCell(board, Integer.parseInt(args[0]), Integer.parseInt(args[1])));
                game.buyTower(tower);
                System.out.println("\nSniperTower added");
                tower.upgrade(tower.getRemainingUpgrade().get(0), game.getPlayer());                   
                tower = new SuperTower(findUnusedCell(board, Integer.parseInt(args[0]), Integer.parseInt(args[1])));
                game.buyTower(tower);
                System.out.println("\nSuperTower added");
                tower.upgrade(tower.getRemainingUpgrade().get(0), game.getPlayer());                    
                tower = new TackTower(findUnusedCell(board, Integer.parseInt(args[0]), Integer.parseInt(args[1])));
                game.buyTower(tower);
                System.out.println("\nTackTower added");
                tower.upgrade(tower.getRemainingUpgrade().get(0), game.getPlayer());  
            }
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        board.displayBoard();
        
        for(int i = 1; i < 6; i++){
            if(game.getPlayer().getLives() <= 0){
                return;
            }
            System.out.printf("%n%n=== Starting Round %d", i);
            game.playRound(Integer.parseInt(args[2]) * i);
        }
        for (int i = 0; i < board.getTowers().size(); i++) {
            if(game.getPlayer().getLives() <= 0){
                return;
            }
            // Copie de la référence de liste de Tower de board
            Tower currentTower = board.getTowers().get(i);
                
            if (currentTower instanceof DamageTower) {
                DamageTower dmgTower = (DamageTower) currentTower;
                try{
                    System.out.println("\nThe upgrade " + dmgTower.getAppliedUpgrade().get(0) + " has been reverted from the " + dmgTower.toString());
                    dmgTower.revertUpgrade(dmgTower.getAppliedUpgrade().get(0), game.getPlayer());
                }
                catch(IndexOutOfBoundsException e){
                    System.out.println("The next upgrade can't be reverted");
                }
                System.out.println("\n");
            }
        }
        for(int i = 6; i < 11; i++){
            if(game.getPlayer().getLives() <= 0){
                return;
            }
            System.out.printf("%n%n=== Starting Round %d", i);
            game.playRound(Integer.parseInt(args[2]) * i);
        }
=======
        game.play();
>>>>>>> e1987b3ccdd8f7fa8df3aa06bd8a267e8f54df5c
    }
}
