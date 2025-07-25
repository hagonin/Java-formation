package fr.algorithmie;

/**
 * Cette classe vérifie si un nombre est parfait. Un nombre parfait est égal à la somme
 * de ses diviseurs propres (diviseurs autres que lui-même).
 */


public class NombreParfait {
    public static void main(String[] args) {
        //int n = 28; // Exemple de nombre parfait (28 = 1 + 2 + 4 + 7 + 14)
        int n = 16;
        int sum = 0; // Variable pour stocker la somme des diviseurs

        // Parcours de tous les nombres de 1 à n-1 pour trouver les diviseurs
        for (int i = 1; i < n; i++){
            if (n % i == 0) {
                sum += i;
            }
        }
        // Vérifie si le nombre est parfait (égal à la somme de ses diviseurs propres)
        boolean perfect = sum == n;

        System.out.println(n + " est parfait: " + perfect);
    }
}
