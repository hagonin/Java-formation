package fr.algorithmie;
import java.util.Arrays;

/**
 * Cette classe effectue une rotation vers la droite d'un tableau d'entiers.
 * Elle déplace tous les éléments d'une position vers la droite, le dernier
 * élément devenant le premier.
 */



public class Rotation {
    public static void main(String[] args) {
        int [] array = {0,1,2,3};
        
        // Sauvegarde du dernier élément avant la rotation
        int last = array[array.length - 1];
        
        // Déplacement de tous les éléments vers la droite (de droite à gauche pour éviter l'écrasement)
        for (int i = array.length - 1; i > 0; i--){
            array[i] = array[i -1]; // Chaque élément prend la place de son prédécesseur
        }
        
        // Placement de l'ancien dernier élément en première position
        array[0] = last;

        System.out.println(Arrays.toString(array));
    }
}
