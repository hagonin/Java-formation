package fr.diginamic.essais;

import fr.diginamic.operations.CalculMoyenne;

public class TestMoyenne {
    public static void main(String[] args) {
        // Create an instance of CalculMoyenne
        CalculMoyenne calc = new CalculMoyenne();

        // Add some values
        calc.add(10);
        calc.add(20);
        calc.add(30);

        // Calculate the average
        double average = calc.calcul();
        System.out.println("Added values: 10, 20, 30");
        System.out.println("Average: " + average);

        // Display size and capacity
        System.out.println("Size: " + calc.getSize());
        System.out.println("Capacity: " + calc.getCapacity());

        System.out.println("\n------------ test single value ------------");
        CalculMoyenne singleValueCalc = new CalculMoyenne();
        singleValueCalc.add(42.5);
        double singleAverage = singleValueCalc.calcul();
        System.out.println("Single value test: " + singleAverage + " (expected: 42.5)");

        System.out.println("\n------------ test with negative and decimal values ------------");
        CalculMoyenne mixedCalc = new CalculMoyenne();
        mixedCalc.add(-10.5);
        mixedCalc.add(10.5);
        mixedCalc.add(0);
        double mixedAverage = mixedCalc.calcul();

        System.out.println("Mixed values: " + mixedAverage + " (expected: 0)");

        System.out.println("\n------------ test empty collection ------------");
        CalculMoyenne emptyCalc = new CalculMoyenne();
        try {
            emptyCalc.calcul();
            System.out.println("Empty collection average: " + emptyCalc);
        } catch (IllegalStateException e) {
            System.out.println("Caught expected exception for empty collection: " + e.getMessage());
        }

    }
}
