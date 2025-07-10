package fr.algorithmie;

import java.util.Arrays;

/**
 * Cette classe calcule la somme élément par élément de deux tableaux d'entiers
 * de même taille. Elle crée un nouveau tableau contenant la somme des éléments
 * correspondants des deux tableaux d'origine.
 */


public class SommeDeTableaux {
    public static void main(String[] args) {
        int[] array1 = {1, 15, -3, 0, 8, 7, 4, -2, 28, 7, -1, 17, 2, 3, 0, 14, -4};

        int [] array2 = {-1, 12, 17, 14, 5, -9, 0, 18, -6, 0, 4, -13, 5, 7, -2, 8, -1};
        
        // Création d'un nouveau tableau pour stocker les sommes
        int [] sum = new int[array1.length];
        
        // Parcours des deux tableaux pour calculer la somme élément par élément
        for (int i = 0; i < array1.length; i++){
            sum[i] = array1[i] + array2[i]; // Somme des éléments à la même position
        }

        System.out.println(Arrays.toString(sum));
    }
}
