package fr.algorithmie;

import java.util.Scanner;

/**
 * Cette classe affiche la table de multiplication d'un nombre saisi par l'utilisateur.
 */



public class InteractifTableMult {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Entrez un nombre: ");

        int n = sc.nextInt();
        for (int i = 1; i <= 10; i++) {
            System.out.println(n + "x" + i + " = " + n*i);
        }
        sc.close();
    }
}
