package fr.diginamic.chaine.entites;

public class Salarie {
    private String nom;
    private String prenom;
    private double salaire;

    public Salarie(String nom, String prenom, double salaire) {
        validateNom(nom);
        validatePrenom(prenom);
        validateSalaire(salaire);
        
        this.nom = nom.trim();
        this.prenom = prenom.trim();
        this.salaire = salaire;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        if (nom == null || nom.trim().isEmpty()) {
            throw new IllegalArgumentException("Le nom ne peut pas être null ou vide");
        }
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        if (prenom == null || prenom.trim().isEmpty()) {
            throw new IllegalArgumentException("Le prénom ne peut pas être null ou vide");
        }
        this.prenom = prenom;
    }

    public double getSalaire() {
        return salaire;
    }

    public void setSalaire(double salaire) {
        if (salaire < 0) {
            throw new IllegalArgumentException("Le salaire ne peut pas être négatif");
        }
        this.salaire = salaire;
    }

    @Override
    public String toString() {
        return String.format("Salarie{nom='%s', prenom='%s', salaire=%.2f€}",
                nom, prenom, salaire);
    }

    public double getSalaireAnnuel() {
        return salaire * 12;
    }
    public String getNomComplet() {
        return nom + " " + prenom;
    }
    
    // Validation helper methods
    private void validateNom(String nom) {
        if (nom == null) {
            throw new IllegalArgumentException("Le nom ne peut pas être null");
        }
        if (nom.trim().isEmpty()) {
            throw new IllegalArgumentException("Le nom ne peut pas être vide");
        }
    }
    
    private void validatePrenom(String prenom) {
        if (prenom == null) {
            throw new IllegalArgumentException("Le prénom ne peut pas être null");
        }
        if (prenom.trim().isEmpty()) {
            throw new IllegalArgumentException("Le prénom ne peut pas être vide");
        }
    }
    
    private void validateSalaire(double salaire) {
        if (salaire < 0) {
            throw new IllegalArgumentException("Le salaire ne peut pas être négatif");
        }
    }
}
