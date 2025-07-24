package fr.diginamic.recensement;

import java.util.Scanner;

/**
 * Main application class for the Population Census Application
 * Displays menu and handles user interactions
 */
public class ApplicationRecensement {
    
    private static final String CSV_FILE_PATH = "src/fr/diginamic/recensement/recensement.csv"; // Default CSV file path
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Recensement recensement = new Recensement();
        
        // Load CSV data
        System.out.println("=== Application de Recensement de Population ===");
        System.out.println("Chargement des données...");
        
        // Try to load from default path, otherwise ask user for path
        try {
            recensement.loadFromCSV(CSV_FILE_PATH);
        } catch (Exception e) {
            System.out.print("Fichier " + CSV_FILE_PATH + " non trouvé. Veuillez saisir le chemin du fichier CSV: ");
            String customPath = scanner.nextLine();
            recensement.loadFromCSV(customPath);
        }
        
        // Main menu loop
        boolean continuer = true;
        while (continuer) {
            afficherMenu();
            System.out.print("Votre choix: ");
            
            try {
                int choix = Integer.parseInt(scanner.nextLine());
                continuer = traiterChoix(choix, recensement, scanner);
            } catch (NumberFormatException e) {
                System.out.println("Veuillez saisir un nombre valide.");
            }
            
            if (continuer) {
                System.out.println("\nAppuyez sur Entrée pour continuer...");
                scanner.nextLine();
            }
        }
        
        System.out.println("Au revoir!");
        scanner.close();
    }
    
    /**
     * Display the main menu
     */
    private static void afficherMenu() {
        System.out.println("\n=== MENU PRINCIPAL ===");
        System.out.println("1. Population d'une ville");
        System.out.println("2. Population d'un département");
        System.out.println("3. Population d'une région");
        System.out.println("4. Afficher les 10 régions les plus peuplées");
        System.out.println("5. Afficher les 10 départements les plus peuplés");
        System.out.println("6. Afficher les 10 villes les plus peuplées d'un département");
        System.out.println("7. Afficher les 10 villes les plus peuplées d'une région");
        System.out.println("8. Afficher les 10 villes les plus peuplées de France");
        System.out.println("9. Sortir");
        System.out.println("=====================");
    }
    
    /**
     * Process user choice and call appropriate service
     */
    private static boolean traiterChoix(int choix, Recensement recensement, Scanner scanner) {
        MenuService service = null;
        
        switch (choix) {
            case 1:
                service = new RecherchePopulationCity();
                break;
            case 2:
                service = new RecherchePopulationDepartement();
                break;
            case 3:
                service = new RecherchePopulationRegion();
                break;
            case 4:
                service = new Affichage10RegionsPlusPeuplees();
                break;
            case 5:
                service = new Affichage10DepartementsPlusPeuplees();
                break;
            case 6:
                service = new Affichage10VillesPlusPeupleesDepartement();
                break;
            case 7:
                service = new Affichage10VillesPlusPeupleesRegion();
                break;
            case 8:
                service = new Affichage10VillesPlusPeupleesFrance();
                break;
            case 9:
                return false; // Exit the application
            default:
                System.out.println("Choix invalide. Veuillez choisir un nombre entre 1 et 9.");
                return true;
        }
        
        if (service != null) {
            try {
                service.traiter(recensement, scanner);
            } catch (Exception e) {
                System.out.println("Une erreur s'est produite: " + e.getMessage());
            }
        }
        
        return true; // Continue the application
    }
} 