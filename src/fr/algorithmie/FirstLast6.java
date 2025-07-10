package fr.algorithmie;

/**
 * Cette classe vérifie si le premier ou le dernier élément d'un tableau est égal à 6.
 * Elle affiche le résultat de cette vérification.
 */
public class FirstLast6 {
    public static void main(String[] args) {
        //int [] array = {1,4,3,6}; // Exemple de tableau sans 6 en première ou dernière position
        int [] array = {1,4,3,6,4};
        // Vérifie si le premier ou le dernier élément est égal à 6
        boolean result = array[0] == 6 || array[array.length-1] == 6;
        System.out.println("First or last element is 6 :" + result);
    }
}
