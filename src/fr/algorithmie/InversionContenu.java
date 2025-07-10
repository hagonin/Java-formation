package fr.algorithmie;

/**
 * Cette classe crée une copie inversée d'un tableau d'entiers.
 * Elle affiche le tableau original puis sa version inversée.
 */


public class InversionContenu {
    public static void main(String[] args) {
        int [] array = {1, 15, -3, 0, 8, 7, 4, -2, 28, 7, -1, 17, 2, 3, 0, 14, -4};

        // Copie les éléments dans l'ordre inverse
        int [] arrayCopy = new int[array.length];
        for (int i = 0; i < array.length; i++)
        {
            arrayCopy[i]= array[array.length - 1 - i]; // Copie l'élément en partant de la fin
        }
        System.out.println("\n--- Tableau original ---");

        for (int val : array ) {
            System.out.print(val + " ");
        }

        System.out.println("\n--- Tableau copie inverse ---");
        for (int val : arrayCopy) {
            System.out.print(val + " ");
        }
    }
}
