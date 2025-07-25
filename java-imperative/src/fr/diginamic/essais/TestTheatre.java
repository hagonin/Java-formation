package fr.diginamic.essais;

import fr.diginamic.operations.Theatre;

public class TestTheatre {
    public static void main(String[] args) {
        // Create a Theatre instance
        Theatre theatre = new Theatre("Théâtre National", 100);

        System.out.println("Théâtre créé: " + theatre.getNom());
        System.out.println("Capacité maximale: " + theatre.getCapaciteMax());
        System.out.println("État initial - Clients: " + theatre.getTotalClientsInscrits() +
                ", Revenus: " + theatre.getChiffreAffraires() + "€\n");

        // Test groups booking
        theatre.inscrire(10, 20.0);
        theatre.inscrire(50, 30.0);
        theatre.inscrire(20, 28.0);
        theatre.inscrire(3, 35.0);
        theatre.inscrire(2, 40.0);
        theatre.inscrire(1, 25.0);
        theatre.inscrire(10, 30.0);
        // Test exceeding capacity
        theatre.inscrire(60, 20.0); // Should fail due to insufficient capacity

        afficherEtat(theatre);

        // Test negative ticket price
        try {
            theatre.inscrire(10, -5.0); // Should throw an exception
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        // Test zero clients
        try {
            theatre.inscrire(0, 20.0); // Should throw an exception
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void afficherEtat(Theatre theatre) {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("RAPPORT FINAL - " + theatre.getNom());
        System.out.println("=".repeat(50));

        System.out.println("Capacité maximale: " + theatre.getCapaciteMax() + " personnes");
        System.out.println("Total clients inscrits: " + theatre.getTotalClientsInscrits() + " personnes");
        System.out.println("Espaces disponibles: " + theatre.getEspacesDisponibles() + " personnes");
        System.out.println("Taux d'occupation: " +
                String.format("%.1f%%", (theatre.getTotalClientsInscrits() * 100.0 / theatre.getCapaciteMax())));
        System.out.println("Chiffre d'affaires total: " + theatre.getChiffreAffraires() + "€");
        System.out.println("Revenus moyens par client: " +
                (theatre.getTotalClientsInscrits() > 0 ? 
                    String.format("%.2f€", theatre.getChiffreAffraires() / theatre.getTotalClientsInscrits()) : 
                    "N/A (aucun client)"));
        System.out.println("Statut: " + (theatre.estComplet() ? "COMPLET" : "Places disponibles"));
        System.out.println("=".repeat(50));
    }
}
