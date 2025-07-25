package fr.algorithmie;

/**
 * Classe CaractereConsecutif
 *
 * Cette classe compte le nombre de caractères consécutifs identiques dans une chaîne
 * et affiche le résultat sous la forme d'une nouvelle chaîne où chaque caractère est
 * suivi du nombre de répétitions consécutives.
 *
 * Fonctionnalités :
 * - Parcourt une chaîne de caractères
 * - Compte les caractères consécutifs identiques
 * - Construit une nouvelle chaîne avec le caractère et son nombre de répétitions
 * - Affiche le résultat
 */
public class CaractereConsecutif {
    /**
     * Méthode principale qui exécute le programme
     *
     * @param args arguments de ligne de commande (non utilisés)
     */
    public static void main(String[] args) {
        // Définition de la chaîne à analyser
        String text = "aaaabbbcccdeee";
        StringBuilder result = new StringBuilder();
        int count = 1;
        // Parcours de la chaîne à partir du deuxième caractère
        for (int i = 1; i < text.length(); i++){
            if (text.charAt(i) == text.charAt(i - 1)){
                count++; // Incrémente le compteur si le caractère est identique au précédent
            } else {
                // Ajoute le caractère précédent et son nombre de répétitions
                result.append(text.charAt(i-1)).append(count);
                count = 1; // Réinitialise le compteur
            }
        }
        // Ajoute le dernier caractère et son nombre de répétitions
        result.append(text.charAt(text.length()-1)).append(count);
        // Affiche le résultat
        System.out.println(text +" becomes " + result);
    }
}
