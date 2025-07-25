package fr.algorithmie;

import java.util.Arrays;

/**
 * Cette classe additionne deux tableaux d'entiers de tailles différentes.
 * Si un tableau est plus court, il est complété par des zéros pour l'addition.
 * Le résultat est stocké dans un nouveau tableau de la taille du plus grand des deux.
 */


public class SommeDeTableauxDiff {
    public static void main(String[] args) {
        int [] array1 = {1, 15, -3, 0, 8, 7, 4, -2, 28, 7, -1, 17, 2, 3, 0, 14, -4};
        int [] array2 = {-1, 12, 17, 14, 5, -9, 0, 18};

        // Calcul de la taille maximale des deux tableaux
        int maxLength = Math.max(array1.length, array2.length);

        // Création du tableau résultat
        int [] diff = new int[maxLength];

        // Addition des éléments à la même position, en complétant par zéro si besoin
        for (int i = 0; i < maxLength; i++){
            int val1 = i < array1.length ? array1[i] : 0;
            int val2 = i < array2.length ? array2[i] : 0;

            diff[i] = val1 + val2;
        }

        System.out.println(Arrays.toString(diff));
    }
}
