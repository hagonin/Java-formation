package fr.algorithmie;

/**
 * Cette classe vérifie si le premier et le dernier élément d'un tableau sont identiques.
 * Elle utilise une condition logique pour vérifier que le tableau n'est pas vide
 * et que le premier élément est égal au dernier élément.
 */
public class FirstLast {
    public static void main(String[] args) {
        int [] array = {1,4,3,6};
        //int [] array = {0};
        
        // Vérification que le tableau n'est pas vide et le premier élément égale le dernier
        boolean result = array.length > 0 && array[0] == array[array.length-1];

        System.out.println("Premier et dernier identique : " + result);
    }
}
