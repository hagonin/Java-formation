package fr.algorithmie;


public class ComparaisonTableau {
    public static void main(String[] args) {
        int[] array1 = {1, 15, -3, 8, 7, 4, -2, 28, -1, 17, 2, 3, 0, 14, -4};
       int[] array2 = {3, -8, 17, 5, -1, 4, 0, 6, 2, 11, -5, -4, 8};
        //int[] array1 = {3, -8, 17, 5, -1, 4, 0, 6, 2, 11, -5, -4, 8};

        boolean identique = true;
        if (array1.length != array2.length) {
            identique = false;
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