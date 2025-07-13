package fr.tableaux;

import java.util.Arrays;

/**
 * This class allows sorting an array of integers in ascending or descending order.
 * It uses Java's built-in Arrays.sort() method and includes robust error handling
 * for null or empty array cases.
 */

public class SortedArray {

    private int[] data;
    // Sorting order indicator (true = ascending, false = descending)
    private boolean ascending;

    /**
     * Constructor of the SortedArray class
     *
     * @param data      array of integers to sort
     * @param ascending true for ascending sort, false for descending sort
     */
    public SortedArray(int[] data, boolean ascending) {
        this.data = data;
        this.ascending = ascending;
    }

    /**
     * Sorts the array using Java's built-in Arrays.sort() method
     * Displays an error message and stops if the array is null or empty
     */
    public void sort() {
        if (data == null || data.length == 0) {
            System.out.println("Error: No numbers to sort!");
            return;
        }

        try {
            // Using Java's built-in Arrays.sort() method
            Arrays.sort(data);

            if (!ascending) {
                reverseArray();
            }

            System.out.println("Sort completed successfully.");
        } catch (Exception e) {
            System.err.println("Error during sorting: " + e.getMessage());
        }
    }

    // reserve the array method
    private void reverseArray() {
        for (int i = 0, j = data.length - 1; i < j; i++, j--) {
            int temp = data[i];
            data[i] = data[j];
            data[j] = temp;
        }
    }

    /**
     * Displays the array or a specific message if it is null or empty
     */
    public void display() {
        try {
            if (data == null) {
                System.out.println("Error: No numbers to display");
            } else if (data.length == 0) {
                System.out.println("[]");
            } else {
                System.out.println(Arrays.toString(data));
            }
        } catch (Exception e) {
            System.err.println("Error during display: " + e.getMessage());
        }
    }
}

