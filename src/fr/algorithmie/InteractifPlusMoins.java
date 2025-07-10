package fr.algorithmie;

import java.util.Scanner;

/**
 * Cette classe implémente un jeu de devinettes où l'utilisateur doit deviner
 * un nombre aléatoire entre 1 et 10. Le programme donne des indices "plus"
 * ou "moins" selon la proposition de l'utilisateur et compte le nombre de tentatives.
 */
public class InteractifPlusMoins {
    public static void main(String[] args) {
        int target = (int) (Math.random()*10)+1;

        Scanner sc = new Scanner(System.in);

        int attempts = 0;
        
        // Variable pour stocker la proposition de l'utilisateur
        int proposition;
        
        // Boucle do-while pour continuer jusqu'à ce que l'utilisateur trouve le bon nombre
        do {
            System.out.println("Guess the number: ");

            proposition = sc.nextInt();

            attempts++;

            if (proposition < target) {
                System.out.println("Too low");
            } else if (proposition > target) {
                System.out.println("Too high");
            }
        } while (proposition != target);

        System.out.println("Congratulations! you found the number after trying " + attempts + " times");

        sc.close();
    }
}
