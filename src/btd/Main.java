
package btd;

import btd.boards.*;
import btd.towers.*;
import btd.Balloon;
public class Main {

    public static void main(String[] args) {
        Player player= new Player();
        Board board = new LinearBoard(4, 12,3);
        board.show();
        System.out.println();
        Board board2 = new ClassicBoard(4, 12);
        board2.show();

        
        /*int round = 1;
        while (0 < player.getLives()){
            System.out.println("=== Début du tour " + round + " ===");
            board.show();
            System.out.println("===== Étape 1 : Tour du joueur");
            boolean startingRound=false;
            while (!startingRound) {
                // showMenu(); 
                int choice; // Le choix du joueur
                if (choice == 0) {
                    startingRound = true;
                } else {
                    // Gestion choix joueur
                }
            }
            System.out.println("===== Étape 2 : Apparition des Ballons");
            // List<Ballon> activeBalloons = board.spawnRoundBalloons(round); 
            // System.out.println("Nombre total de ballons cette manche: "+activeBalloons.size());
            System.out.println("===== Étape 3 : Tour des Ballons");
            int time = 0;
            while (!board.getBallons().isEmpty() && player.getLives() > 0){
                System.out.println("----- time: "+time);
                System.out.println("Position des Ballons");
                
                time += 100;
            }

        }
        */
    }
}
