package fr.algorithmie;

/**
 * Cette classe trouve la deuxième plus grande valeur dans un tableau d'entiers.
 * Elle parcourt le tableau une seule fois en gardant en mémoire les deux plus grandes valeurs.
 */


public class RechercheSecond {
    public static void main(String[] args) {
        int[] array = {1, 15, -3, 0, 8, 7, 4, -2, 28, 7, -1, 17, 2, 3, 0, 14, -4} ;
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;

        for (int val:array) {
            if (val > max1) {
                max2 = max1; // L'ancien maximum devient le deuxième maximum
                max1 = val; // Nouveau maximum
            }
            else if (val > max2 && val != max1){
                max2 = val; // Nouveau deuxième maximum (différent du premier)
            }
        }
        System.out.println("Seconde plus grande valeur : " + max2);
    }
}
