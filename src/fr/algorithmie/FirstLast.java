package fr.algorithmie;

public class FirstLast {
    public static void main(String[] args) {
        int [] array = {1,4,3,6};
        //int [] array = {0};
        boolean result = array.length > 0 && array[0] == array[array.length-1];
        System.out.println("Premier et dernier identique : " + result);
    }
}
