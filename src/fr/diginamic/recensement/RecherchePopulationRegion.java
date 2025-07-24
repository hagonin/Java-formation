package fr.diginamic.recensement;

import java.util.Scanner;

/**
 * Service to search for population of a specific region
 */
public class RecherchePopulationRegion extends MenuService {
    
    @Override
    public void traiter(Recensement recensement, Scanner scanner) {
        System.out.print("Veuillez saisir le nom de la région: ");
        String regionName = scanner.nextLine();
        
        int population = recensement.getPopulationByRegion(regionName);
        
        if (population > 0) {
            System.out.println("Population de la région " + regionName + ": " + 
                             String.format("%,d", population) + " habitants");
        } else {
            System.out.println("Région '" + regionName + "' non trouvée ou aucune donnée.");
        }
    }
} 