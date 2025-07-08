package fr.algorithmie;

public class NombreParfait {
    public static void main(String[] args) {
        //int n = 28;
        int n = 16;
        int sum = 0;
        for (int i = 1; i < n; i++){
            if (n % i == 0) {
                sum += i;
            }
        }
        boolean perfect = sum == n;
        System.out.println(n + " est parfait: " + perfect);
    }
}
