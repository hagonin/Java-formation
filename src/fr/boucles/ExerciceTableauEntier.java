package fr.boucles;

public class ExerciceTableauEntier {
    public static void main(String[] args) {
        int [] total = {1,2,3,4,5,6,7,8,9,10};
        System.out.println(total[0]);
        System.out.println("Longueur du tableau :" + total.length);
        System.out.println(total[total.length-1]);
        total[4] = 8;
        System.out.println("Nouvelle valeur à l'index 4 : " + total[4]);
    }
}
