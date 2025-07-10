package fr.algorithmie;

import java.util.Scanner;

/**
 * Cette classe demande à l'utilisateur de saisir un nombre, puis calcule la somme
 * des entiers de 1 jusqu'à ce nombre inclus. Elle utilise une boucle pour effectuer
 * l'addition et affiche le résultat.
 * */

public class InteractifSommeArithmetique {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Entrer a number: ");

        int n = sc.nextInt();

        int sum = 0;

        for(int i=1; i<=n; i++){
            sum += i;
        }

        System.out.println("Sum = " + sum);

        sc.close();
    }
}