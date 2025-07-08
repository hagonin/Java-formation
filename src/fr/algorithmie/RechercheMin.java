package fr.algorithmie;

public class RechercheMin {
    public static void main(String[] args) {
        int [] array = {1, 15, -3, 0, 8, 7, 4, -2, 28, 7, -1, 17, 2, 3, 0, 14, -4} ;
        int min = array [0];
        for (int val : array){
            if (val < min) {
                min = val;
            }
        }
        System.out.println("Valeur min : " + min);
    }
}
