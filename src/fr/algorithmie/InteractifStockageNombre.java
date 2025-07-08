package fr.algorithmie;

import java.util.Scanner;

public class InteractifStockageNombre {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int [] numbers = new int [10];
        int count = 0;
        boolean  proceed = true;

        while (proceed) {
            System.out.println("1.Enter a number : ");
            System.out.println("2. Display stored numbers : ");
            System.out.println("3. Exit");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter a number : ");
                    int value = sc.nextInt();
                    if (count == numbers.length) {
                        int[] copy = new int[numbers.length * 2];
                        for (int i = 0; i < numbers.length; i++) {
                            copy[i] = numbers[i];
                        }
                        numbers = copy;
                    }
                    numbers[count] = value;
                    count++;
                    break;
                case 2:
                    for (int i = 0; i < count; i++)
                    {
                        System.out.println("Stored numbers :" + numbers[i]);
                    }
                    break;
                    case 3:
                        proceed = false;
                        break;
                        default:
                            System.out.println("See you again !");
                            System.out.println("---------FINISH----------");
            }
        }
        sc.close();
    }
}
