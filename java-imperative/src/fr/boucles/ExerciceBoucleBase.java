package fr.boucles;

public class ExerciceBoucleBase {
    public static void main(String[] args) {
        //Affiche tous les nombres de 1 à 10
        for (int i = 1; i <=10; i++) {
            System.out.println(i);
        }

        //Affiche 20 fois le nom et le prénom
        System.out.println("\n--- Nom et Prénom 20 fois ---");
        for (int i = 0; i < 20; i++) {
            System.out.println("Leon Blerault");
        }

        //Affiche les éléments pairs de 2 à 100
        System.out.println("\n--- Nombres pairs de 2 à 100---");
        for (int i = 2; i <=100 ; i+=2) {
            System.out.println(i);
        }

        //Affiche les éléments impairs de 1 à 99
        System.out.println("\n--- Nombres impairs de 1 à 99 ---");
        for (int i = 1; i < 99 ; i+=2) {
            System.out.println(i);
        }
    }
}
