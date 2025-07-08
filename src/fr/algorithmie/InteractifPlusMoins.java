package fr.algorithmie;

import java.util.Scanner;

public class InteractifPlusMoins {
    public static void main(String[] args) {
        int target = (int) (Math.random()*10)+1;
        Scanner sc = new Scanner(System.in);
        int attempts = 0;
        int proposition;
        do {
            System.out.println("Guess the number: ");
            proposition = sc.nextInt();
            attempts++;
            if (proposition < target) {
                System.out.println("Too low");
            } else if (proposition > target) {
                System.out.println("Too high");
            }
        } while (proposition != target);
        System.out.println("Congratulations! you found the number after trying " + attempts + " times");
        sc.close();
    }
}
