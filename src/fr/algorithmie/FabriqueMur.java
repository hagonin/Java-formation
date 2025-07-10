package fr.algorithmie;

import java.util.Scanner;

/**
 * Cette classe détermine s'il est possible de construire un mur d'une longueur donnée
 * en utilisant un nombre donné de briques de 1m et de 5m.
 */
public class FabriqueMur {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of small bricks (1m): ");
        int nbSmall = sc.nextInt();

        System.out.println("Enter number of big bricks (5m): ");
        int nbBig = sc.nextInt();
        System.out.println("Enter desired wall length (in meters): ");
        int longeur = sc.nextInt();

        // Calcul du nombre maximal de grandes briques utilisables
        int maxBig = Math.min(nbBig, longeur / 5);
        // Calcul du reste à combler avec des petites briques
        int rest = longeur - maxBig * 5;
        // Vérifie si le nombre de petites briques est suffisant
        boolean result = nbSmall >= rest;

        System.out.println("Can we build the wall: " + result);

        sc.close();

    }
}
