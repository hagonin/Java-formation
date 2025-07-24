package fr.diginamic.essais;

import fr.diginamic.operations.Operations;

public class TestOperations {
    public static void main(String[] args) {
        System.out.println("=== Testing Operations Class ===\n");

        double operand1 = 10.5;
        double operand2 = 3.2;

        // Test Addition
        System.out.println("Testing Addition:");
        double additionResult = Operations.calcul(operand1, operand2, '+');
        System.out.println(operand1 + " + " + operand2 + " = " + additionResult);

        // Test Subtraction
        System.out.println("\nTesting Subtraction:");
        double subtractionResult = Operations.calcul(operand1, operand2, '-');
        System.out.println(operand1 + " - " + operand2 + " = " + subtractionResult);

        // Test Multiplication
        System.out.println("\nTesting Multiplication:");
        double multiplicationResult = Operations.calcul(operand1, operand2, '*');
        System.out.println(operand1 + " * " + operand2 + " = " + multiplicationResult);

        // Test Division
        System.out.println("\nTesting Division:");
        double divisionResult = Operations.calcul(operand1, operand2, '/');
        System.out.println(operand1 + " / " + operand2 + " = " + divisionResult);

        // Test edge cases and error handling
        System.out.println("\n=== Testing Edge Cases ===");

        // Test invalid operator handling
        try {
            System.out.println("\nTesting invalid operator:");
            Operations.calcul(10.0, 5.0, '%');
        } catch (IllegalArgumentException e) {
            System.out.println("Caught expected exception: " + e.getMessage());
        }

        System.out.println("\n=== All tests completed ===");
        // Test division by zero handling
        try {
            System.out.println("\nTesting division by zero:");
            Operations.calcul(10.0, 0.0, '/');
        } catch (IllegalArgumentException e) {
            System.out.println("Caught expected exception: " + e.getMessage());
        }
    }
}
