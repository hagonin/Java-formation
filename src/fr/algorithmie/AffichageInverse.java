package fr.algorithmie;

public class AffichageInverse {
    public static void main(String[] args) {
        int [] array = {1, 15, -3, 0, 8, 7, 4, -2, 28, 7, -1, 17, 2, 3, 0, 14, -4};

        //Affiche l'ensemble des éléments du tableau
        System.out.println("\n--- Affichage des éléments ---");
        for (int val : array){
            System.out.print(val + " ");
        }

        //Affiche les élements dans l'ordre inverse
        System.out.println("\n--- Affichage dans l'ordre inverse ---");
        for (int i = array.length - 1 ; i>= 0; i--){
            System.out.println(array[i]);
        }

        //Copie les élements dans un nouveau tableau
        int [] arrayCopy = new int[array.length];
        for(int i = 0; i < array.length; i++){
            arrayCopy[i] = array[i];
        }

        System.out.println("\n--- Tableau copie ---");
        for (int val : arrayCopy){
            System.out.print(val + " ");
        }
    }
}
