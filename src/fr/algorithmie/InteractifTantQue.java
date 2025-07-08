package fr.algorithmie;

import java.util.Scanner;

public class InteractifTantQue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        do {
            System.out.println("Entrez un nombre entre 1 et 10: ");
            n = sc.nextInt();
        } while ( n < 1 || n > 10);
        System.out.println(("Vous avez saisi: " + n));
    }
}
