package btd;

import btd.boards.Board;
import btd.towers.*;
import btd.Balloon;
public class Main {

    public static void main(String[] args) {
        Player player= new Player();
        Board board = new Board(4, 12);
        int round = 1;
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
            while (!board.activeBalloonsIsEmpty() && player.getLives() > 0){
                
                // TODO: finir la boucle mais est ce que les ballons spawn 1 à 1 ou tous en même temps comme dans la trace ? 
                
                time += 100;
            }

        }
    }
}
