package fr.algorithmie;

public class FirstLast6 {
    public static void main(String[] args) {
        //int [] array = {1,4,3,6};
        int [] array = {1,4,3,6,4};
        boolean result = array[0] == 6 || array[array.length-1] == 6;
        System.out.println("First or last element is 6 :" + result);
    }
}
