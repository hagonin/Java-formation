package fr.algorithmie;

import java.util.Scanner;


public class InteractifFibonacci {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Entrez le rang N (> = 0): ");
        int n = sc.nextInt();
        int result = computeFibonacci(n);
        System.out.println("Fibonacci de rang " + n + " = " + result);
        sc.close();
    }

    public static int computeFibonacci(int n) {
        if (n <= 0){
            return 0;
        }
        int precedent = 0;
        int courant = 1;
        for (int i = 1; i < n; i++) {
            int suivant = precedent + courant;
            precedent = courant;
            courant = suivant;
        }
        return courant;
    }
}


// Another method
/*
public class InteractifFibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a Fibonacci rank N (>= 0): ");
        int n = scanner.nextInt();

        if (n == 0) {
            System.out.println("Fibonacci number: 0");
        } else if (n == 1) {
            System.out.println("Fibonacci number: 1");
        } else {
            int a = 0, b = 1;
            for (int i = 2; i <= n; i++) {
                int temp = b;
                b = a + b;
                a = temp;
            }
            System.out.println("Fibonacci number at rank " + n + ": " + b);
        }

        scanner.close();
    }
}*/
