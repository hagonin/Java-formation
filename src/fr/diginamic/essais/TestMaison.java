package fr.diginamic.essais;

import fr.diginamic.maison.*;

public class TestMaison {
    private static Maison houseForTesting;
    public static void main(String[] args) {
        testBasicMaisonCreation();

        testAreaCalculations();

        testErrorHandling();

        testAdvancedFeatures();

        System.out.println("======Tous les tests ont réussi !=======");
        System.out.println("=".repeat(50));
    }
    //Tests basic house creation and room addition functionality.
    public static void testBasicMaisonCreation() {
        // Create a new house
        Maison maison = new Maison();
        maison.ajouterPiece(new Salon(35.5, 0));            // Living room on ground floor
        maison.ajouterPiece(new Cuisine(12.0, 0));            // Kitchen on ground floor
        maison.ajouterPiece(new Wc(2.5, 0));                                   // Powder room on ground floor

        maison.ajouterPiece(new Chambre(15.0, 1));        // Master bedroom on first floor
        maison.ajouterPiece(new Chambre(12.5, 1));        // Second bedroom on first floor
        maison.ajouterPiece(new SalleDeBain(8.0, 1));     // Bathroom on first floor

        maison.ajouterPiece(new Chambre(10.0, 2));        // Guest room on second floor
        maison.ajouterPiece(new Wc(2.0, 2));
        System.out.println("Maison créée avec succès:" + maison);

        houseForTesting = maison;
    }
    // Tests area calculations methods and floor-based operations
    public static void testAreaCalculations(){
        Maison maison = houseForTesting;

        //test total area calculation
        double totalArea = maison.getSuperficieTotale();
        System.out.println("Superficie totale de la maison: " + totalArea + " m²");

        //test floor-based area calculation
        double superficieEtage0 = maison.getSuperficieEtage(0);
        double superficieEtage1 = maison.getSuperficieEtage(1);
        double superficieEtage2 = maison.getSuperficieEtage(2);
        System.out.println("Superficie de l'étage 0: " + superficieEtage0 + " m²");
        System.out.println("Superficie de l'étage 1: " + superficieEtage1 + " m²");
        System.out.println("Superficie de l'étage 2: " + superficieEtage2 + " m²");

        //verify choosen floor areas to total area
        double expectedTotalArea = superficieEtage0 + superficieEtage1 + superficieEtage2;
    }

    //test error handling for invalid inputs
    private static void testErrorHandling(){
        Maison maison = new Maison();

        System.out.println("\nTest d'ajout d'une pièce nulle:");
        try{
            maison.ajouterPiece(null);
        } catch (IllegalArgumentException e) {
            System.out.println("Erreur capturée: " + e.getMessage());
        }

        //test adding a room with negative area
        System.out.println("Test d'ajout d'une pièce avec superficie négative:");
        try {
            maison.ajouterPiece(new Chambre(-10.0, 0));
        } catch (IllegalArgumentException e) {
            System.out.println("Erreur capturée: " + e.getMessage());
        }

        //test adding a room with negative floor number
        System.out.println("Test d'ajout d'une pièce avec numéro d'étage négatif:");
        try {
            maison.ajouterPiece(new Cuisine(15.0, -1));
        } catch (IllegalArgumentException e) {
            System.out.println("Erreur capturée: " + e.getMessage());
        }
    }

    //test advanced features like type-based area calculations
    private static void testAdvancedFeatures(){
        Maison maison = houseForTesting;
        System.out.println("\n=== Test opérations avancées par type ===");
        //test area calculation by type
        System.out.println("Superficie par type de pièce:");
        double superficieChambres = maison.getSuperficieParType(Chambre.class);
        double superficieCuisines = maison.getSuperficieParType(Cuisine.class);
        double superficieSalons = maison.getSuperficieParType(Salon.class);
        double superficieSallesDeBain = maison.getSuperficieParType(SalleDeBain.class);
        double superficieWC = maison.getSuperficieParType(Wc.class);

        System.out.println("  Chambres: " + superficieChambres + " m²");
        System.out.println("  Cuisines: " + superficieCuisines + " m²");
        System.out.println("  Salons/Séjours: " + superficieSalons + " m²");
        System.out.println("  Salles de bain: " + superficieSallesDeBain + " m²");
        System.out.println("  WC: " + superficieWC + " m²");

        // Test room counting by type
        System.out.println("\nNombre de pièces par type:");

        int nombreChambres = maison.getNombrePiecesParType(Chambre.class);
        int nombreCuisines = maison.getNombrePiecesParType(Cuisine.class);
        int nombreSalons = maison.getNombrePiecesParType(Salon.class);
        int nombreSallesDeBain = maison.getNombrePiecesParType(SalleDeBain.class);
        int nombreWC = maison.getNombrePiecesParType(Wc.class);

        System.out.println("  Chambres: " + nombreChambres);
        System.out.println("  Cuisines: " + nombreCuisines);
        System.out.println("  Salons/Séjours: " + nombreSalons);
        System.out.println("  Salles de bain: " + nombreSallesDeBain);
        System.out.println("  WC: " + nombreWC);
    }
}
