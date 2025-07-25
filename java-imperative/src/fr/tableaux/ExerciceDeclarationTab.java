package fr.tableaux;

public class ExerciceDeclarationTab {
    public static void main(String[] args) {
        int[] numbers = {8,-7,12,1,-2,14,17,9};
        System.out.println("Élement à l'index 0:" + numbers[0]);
        System.out.println("Longeur du tableau:" + numbers.length);
        System.out.println("Dernier élement:" + numbers[numbers.length -1]);
        //Afficher l'entier d'index 10 => ceci provoque une exception ArrayIndexOutOfBoundsException
        //car l'index 10 n'existe pas dans le tableau. Le tableau ne possède que 8 éléments
    }
}
