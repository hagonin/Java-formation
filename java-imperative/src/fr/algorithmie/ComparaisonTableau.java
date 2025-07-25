package fr.algorithmie;

/**
 * Cette classe compare deux tableaux d'entiers pour déterminer s'ils sont identiques.
 * Elle vérifie d'abord la longueur, puis compare élément par élément.
 */
public class ComparaisonTableau {
    public static void main(String[] args) {
        int[] array1 = {1, 15, -3, 8, 7, 4, -2, 28, -1, 17, 2, 3, 0, 14, -4};
        int[] array2 = {3, -8, 17, 5, -1, 4, 0, 6, 2, 11, -5, -4, 8};
        //int[] array1 = {3, -8, 17, 5, -1, 4, 0, 6, 2, 11, -5, -4, 8}; // Exemple alternatif

        boolean identique = true; // Variable pour stocker le résultat de la comparaison
        // Vérification de la longueur des tableaux
        if (array1.length != array2.length) {
            identique = false; // Les tableaux ont des longueurs différentes
        } else {
            for (int i = 0; i < array1.length; i++) {
                if (array1[i] != array2[i]) {
                    identique = false;
                    break;
                }
            }
        }
        System.out.println("Tableau identique: " + identique);
    }
}