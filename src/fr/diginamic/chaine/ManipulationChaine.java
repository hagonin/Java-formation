package fr.diginamic.chaine;

public class ManipulationChaine {
    public static void main(String[] args) {
        String chaine = "Durand;Marcel;2 523.5";

        System.out.println("Chaîne d'origine: \"" + chaine + "\"\n");

        //display first character
        System.out.println("Premier caractère: " + chaine.charAt(0));
        //display the string length
        System.out.println("Longueur de la chaîne: " + chaine.length() + " caractères");

        //find the semicolon index
        int indexPointVirgule = chaine.indexOf(';');
        System.out.println("Index du point-virgule: " + indexPointVirgule);
        //extract the last name using substring and indexOf
        String nom = chaine.substring(0, indexPointVirgule);
        System.out.println("Nom: " + nom);
        //display last name in uppercase
        System.out.println("Nom en majuscules: " + nom.toUpperCase());
        //display last name in lowercase
        System.out.println("Nom en minuscules: " + nom.toLowerCase());

        //split the string into parts
        String[] parts = chaine.split(";");
        System.out.println("\nChaine découpée en parties:");
        for (String part : parts) {
            System.out.println(part);
        }

        System.out.println("\nCreation d'un objet Salarie:");
        String nomDeFamille = parts[0];
        String prenom = parts[1];
        String salaireAvecEspace = parts[2];

        System.out.println("Données brutes:");
        System.out.println("  Nom: \"" + nomDeFamille + "\"");
        System.out.println("  Prénom: \"" + prenom + "\"");
        System.out.println("  Salaire brut: \"" + salaireAvecEspace + "\"");

        //remove espace from the salary string
        String salaireSansEspace = salaireAvecEspace.replace(" ", "");
        System.out.println("\nSalaire sans espaces: \"" + salaireSansEspace + "\"");

        //convert the salary string to double
        double salaire = Double.parseDouble(salaireSansEspace);
        System.out.println("\nSalaire converti en double: " + salaire + "€");
    }
}
