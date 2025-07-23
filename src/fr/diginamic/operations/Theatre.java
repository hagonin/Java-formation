package fr.diginamic.operations;

public class Theatre {
    private String nom;
    private int capaciteMax;
    private int totalClientsInscrits;
    private double chiffreAffraires;

    public Theatre(String nom, int capaciteMax) {
        this.nom = nom;
        this.capaciteMax = capaciteMax;
        this.totalClientsInscrits = 0;
        this.chiffreAffraires = 0.0;
    }

    public void inscrire(int nbrClients, double prixBillet) {
        if (nbrClients <= 0) {
            throw new IllegalArgumentException("Number of clients must be greater than 0.");
        }
        if (prixBillet < 0) {
            throw new IllegalArgumentException("Ticket price must be non-negative.");
        }
        if (totalClientsInscrits + nbrClients > capaciteMax) {
            int espacesDisponibles = capaciteMax - totalClientsInscrits;

            System.out.println("ERREUR: Capacité insuffisante!");
            System.out.println("Demande: " + nbrClients + " clients");
            System.out.println("Espaces disponibles: " + espacesDisponibles);
            System.out.println("Capacité maximale: " + capaciteMax);
            System.out.println("Clients actuellement inscrits: " + totalClientsInscrits);
            return;
        }
        //update client count first
        totalClientsInscrits += nbrClients;

        //calculate and add revenue for this transaction
        double revenueTrans = nbrClients * prixBillet;
        chiffreAffraires += revenueTrans;

        System.out.println("-".repeat(30));
        System.out.println("Inscription réussie!");
        System.out.println("Clients ajoutés: " + nbrClients);
        System.out.println("Revenus de cette transaction: " + revenueTrans + "€");
        System.out.println("Total clients inscrits: " + totalClientsInscrits + "/" + capaciteMax);
        System.out.println("Chiffre d'affaires total: " + chiffreAffraires + "€");
    }

    public String getNom() {
        return nom;
    }

    public int getCapaciteMax() {
        return capaciteMax;
    }

    public int getTotalClientsInscrits() {
        return totalClientsInscrits;
    }

    public double getChiffreAffraires() {
        return chiffreAffraires;
    }

    //calculate how many clients can still be registered
    //returns the remaining capacity
    public int getEspacesDisponibles() {
        return capaciteMax - totalClientsInscrits;
    }

    public boolean estComplet() {
        return totalClientsInscrits >= capaciteMax;
    }
}
