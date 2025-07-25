package fr.algorithmie;

/**
 * Cette classe calcule la moyenne arithmétique d'un tableau d'entiers prédéfini.
 * Elle parcourt tous les éléments du tableau, calcule leur somme, puis divise
 * par le nombre d'éléments pour obtenir la moyenne.
 */
public class CalculMoyenne {
    public static void main(String[] args) {
        // Définition du tableau d'entiers avec des valeurs prédéfinies
        int [] array = {1, 15, -3, 0, 8, 7, 4, -2, 28, 7, -1, 17, 2, 3, 0, 14, -4} ;
        
        // Variable pour stocker la somme de tous les éléments
        int sum = 0;
        
        // Parcours de tous les éléments du tableau avec une boucle for-each
        for (int val : array){
            sum += val; // Ajout de chaque valeur à la somme
        }
        
        // Calcul de la moyenne en convertissant la somme en double pour éviter la division entière
        double average = (double) sum / array.length;

        System.out.println("Valeur moyenne : " + average);
    }
}
