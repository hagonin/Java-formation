package fr.tableaux;

import java.util.Arrays;

public class SortedArrayMain {
    public static void main(String[] args) {
        System.out.println("=== Sorting tests with error handling ===\n");

        // Test 1: Tri d'un tableau normal en ordre croissant
        try {
            System.out.println("Test 1: Normal array sorting");
            int[] numbers = {3, 5, 7, 3, 9, 7, 22, 90};

            boolean ascending = true;     // false for descending order

            // Création d'une instance SortedArray

            SortedArray sortedArray = new SortedArray(numbers, ascending);
            //SortedArray sortedArray = new SortedArray(null, true);
            //SortedArray sortedArray = new SortedArray(new int[0], true);
            //SortedArray sortedArray = new SortedArray(numbers, false);

            System.out.println("Original array: " + Arrays.toString(numbers));

            sortedArray.sort();
            sortedArray.display();
            System.out.println();
        } catch (IllegalArgumentException e) {
            System.err.println("Error creating array: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
        }
    }
}

