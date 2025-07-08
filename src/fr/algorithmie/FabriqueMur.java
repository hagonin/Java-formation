package fr.algorithmie;

import java.util.Scanner;

public class FabriqueMur {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of small bricks (1m): ");
        int nbSmall = sc.nextInt();

        System.out.println("Enter number of big bricks (5m): ");
        int nbBig = sc.nextInt();

        System.out.println("Enter desired wall length (in meters): ");
        int longeur = sc.nextInt();

        int maxBig = Math.min(nbBig, longeur / 5);
        int rest = longeur - maxBig * 5;
        boolean result = nbSmall >= rest;

        System.out.println("Can we build the wall: " + result);
        sc.close();

    }
}
