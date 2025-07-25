package fr.algorithmie;

import java.util.Random;
import java.util.Scanner;

/**
 * Cette classe implémente le jeu des 21 bâtons où un joueur et l'ordinateur retirent
 * chacun leur tour 1 à 3 bâtons. Celui qui prend le dernier bâton a perdu.
 * Le programme gère l'alternance des tours, la saisie utilisateur et l'IA de l'ordinateur.
 */
public class Interactif21Batons {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int batons = 21;
        boolean playerTurn = random.nextBoolean(); // Tirage au sort du premier joueur

        System.out.println("=========== Jeu des 21 bâtons ===========");
        System.out.println("--------DÉPART--------");
        System.out.println((playerTurn ? " Vous" : "L'ordinateur") + " commencez ");

        while (batons > 0) {
            if (playerTurn) {
                // Tour du joueur
                System.out.println("Il reste " + batons + " bâton(s). Combien en prenez-vous ? (1-3) :");

                int prise = sc.nextInt();
                // Vérification de la validité du choix
                while (prise < 1 || prise > 3 || prise > batons){
                    System.out.println("Choix invalide. Saisissez 1, 2 ou 3 bâtons, sans dépasser le reste");
                    prise = sc.nextInt();
                }
                batons -= prise;
                if ( batons <= 0) {
                    System.out.println("Vous avez pris le dernier bâton. Vous avez perdu !");
                    break;
                }
            } else {
                // Tour de l'ordinateur
                int prise = Math.min(random.nextInt(3)+1, batons);
                System.out.println("L'ordinateur prend " + prise + " bâton(s).");
                batons -= prise;
                if (batons <= 0) {
                    System.out.println("L'ordinateur a pris le dernier bâton. Il a perdu !");
                    break;
                }
            }
            // Changement de joueur
            playerTurn = !playerTurn;
        }
        sc.close();
    }
}



