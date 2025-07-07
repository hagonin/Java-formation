package fr.boucles;

public class ExerciceBouclesEtTests {
    public static void main(String[] args) {
        int[] array = {1, 15, -3, 0, 8, 7, 4, -2, 28, 7, -1, 17, 2, 3, 0, 14, -4};

        //Affiche tous les élements du tableau
        System.out.println("\n\n--- Tous les élements ---");
        for (int val:array){
            System.out.println(val + "");
        }
        /*for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }*/

        //Affiche les élements dans l'ordre inverse
        System.out.println("\n\n--- Ordre inverse ---");
        for (int i = array.length - 1; i >= 0; i--) {
            System.out.println(array[i]);
        }

        //Affiche uniquement les entiers supérieurs à 3
        System.out.println("\n\n--- Supérieurs à 3 ---");
       /* for (int i = 0; i < array.length; i++) {
            if(array[i] > 3) {
                System.out.println(array[i]);
            }
        }*/
        for(int val : array){
            if(val > 3) System.out.println(val + "");
        }

        //Affiche les entiers pairs
        System.out.println("\n\n--- Nombres pairs ---");
     /*   for (int i=0 ; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                System.out.println(array[i]);
            }
        }*/

        for(int val : array){
            if(val % 2 ==0) System.out.println(val + "");
        }
        //Affiche les valeurs aux index pairs
        System.out.println("\n\n--- Valeurs des index pairs ---");
        for (int i = 0; i < array.length; i++) {
            if (i % 2 == 0) {
                System.out.println(array[i]);
            }

        }

        //Affiche uniquement les entiers impairs
        System.out.println("\n\n--- Nombres impairs ---");
      /*  for (int i = 0; i < array.length; i++) {
            if(array[i] % 2 != 0) {
                System.out.println(array[i]);
            }
        }*/
        for (int val : array) {
            if ( val % 2 != 0 ) System.out.println(val + "");
        }
    }
}
