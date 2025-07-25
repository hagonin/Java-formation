package fr.algorithmie;

import java.util.Scanner;

/**
 * Cette classe permet de trouver le plus grand nombre parmi 10 nombres saisis par l'utilisateur.
 * Elle utilise une boucle pour demander 10 entrées à l'utilisateur et garde en mémoire
 * le plus grand nombre rencontré.
 */
public class InteractifPlusGrand {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Declare la valeur minimale possible pour un int
        int max = Integer.MIN_VALUE;

        for(int a = 0; a < 10; a++){
            System.out.println("Please enter 10 numbers one by one. After entering each number, press Enter \nAdd a number:  ");

            int n = sc.nextInt();
            
            // Comparaison avec le maximum actuel
            if (n > max) {
                max = n ; // Mise à jour du maximum si le nouveau nombre est plus grand
            }
        }

        System.out.println("The biggest number is " + max);

        sc.close();
    }

}
