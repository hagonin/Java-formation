package fr.algorithmie;
import java.util.Arrays;

public class Rotation {
    public static void main(String[] args) {
        int [] array = {0,1,2,3};
        int last = array[array.length - 1];
        for (int i = array.length - 1; i > 0; i--){
            array[i] = array[i -1];
        }
        array[0] = last;
        System.out.println(Arrays.toString(array));
    }
}
