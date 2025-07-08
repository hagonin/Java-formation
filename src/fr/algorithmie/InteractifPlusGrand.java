package fr.algorithmie;

import java.util.Scanner;

public class InteractifPlusGrand {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int max = Integer.MIN_VALUE;
        for(int a = 0; a < 10; a++){
            System.out.println("Please enter 10 numbers one by one. After entering each number, press Enter \nAdd a number:  ");
            int n = sc.nextInt();
            if (n > max) {
                max = n ;
            }
        }
        System.out.println("The biggest number is " + max);
        sc.close();
    }

}
