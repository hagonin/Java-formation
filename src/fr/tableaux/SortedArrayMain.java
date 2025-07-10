package fr.tableaux;

import java.util.Arrays;

public class SortedArrayMain {
    public static void main(String[] args) {
        System.out.println("=== Tests de tri avec gestion d'erreurs ===\n");
        
        // Test 1: Tri d'un tableau normal en ordre croissant
        try {
            System.out.println("Test 1: Tri d'un tableau normal");
            int [] numbers = {3, 5, 7, 3, 9, 7, 22, 90};

            boolean ascending = true;     // false for descending order

            // Création d'une instance SortedArray avec tri croissant
            SortedArray sortedArray = new SortedArray(numbers, ascending);

            System.out.println("Tableau original: " + Arrays.toString(numbers));

            sortedArray.sort();
            sortedArray.display();
            System.out.println();

        } catch (IllegalArgumentException e) {
            System.err.println("Erreur lors de la création du tableau: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Erreur inattendue: " + e.getMessage());
        }

        // Test 2: Tentative de création avec un tableau null
        try {
            System.out.println("Test 2: Tentative de création avec un tableau null");

            SortedArray sortedArray = new SortedArray(null, true);

            sortedArray.sort();
            sortedArray.display();

            System.out.println();
        } catch (IllegalArgumentException e) {
            System.out.println("Exception attendue: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Erreur inattendue: " + e.getMessage());
        }
        
        // Test 3: Tentative de création avec un tableau vide
        try {
            System.out.println("Test 3: Tentative de création avec un tableau vide");
            SortedArray sortedArray = new SortedArray(new int[0], true);

            sortedArray.sort();
            sortedArray.display();

            System.out.println();
        } catch (IllegalArgumentException e) {
            System.out.println("Exception attendue: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Erreur inattendue: " + e.getMessage());
        }
        
        // Test 4: Tri en ordre décroissant
        try {
            System.out.println("Test 4: Tri en ordre décroissant");

            int [] numbers = {3, 5, 7, 3, 9, 7, 22, 90};

            SortedArray sortedArrayDesc = new SortedArray(numbers, false);

            System.out.println("Tableau original: " + Arrays.toString(numbers));

            sortedArrayDesc.sort();
            sortedArrayDesc.display();

            System.out.println();
        } catch (IllegalArgumentException e) {
            System.err.println("Erreur lors de la création du tableau: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Erreur inattendue: " + e.getMessage());
        }
        
        System.out.println("=== Fin des tests ===");
    }
}

