package fr.algorithmie;

import java.util.Scanner;

/**
 * Cette classe demande à l'utilisateur de saisir un nombre, puis affiche
 * les 10 nombres suivants. Elle utilise une boucle pour générer et afficher
 * les nombres consécutifs à partir du nombre saisi.
 */
public class InteractifChiffresSuivants {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Entrez un nombre : ");

        int n  = sc.nextInt();

        for ( int i =1 ; i <=10; i++){
            System.out.println(n+i);
        }

        sc.close();
    }
}
