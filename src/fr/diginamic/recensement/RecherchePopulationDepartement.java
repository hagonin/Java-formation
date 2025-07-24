package fr.diginamic.recensement;

import java.util.Scanner;

/**
 * Service to search for population of a specific department
 */
public class RecherchePopulationDepartement extends MenuService {
    
    @Override
    public void traiter(Recensement recensement, Scanner scanner) {
        System.out.print("Veuillez saisir le code du département: ");
        String departmentCode = scanner.nextLine();
        
        int population = recensement.getPopulationByDepartment(departmentCode);
        
        if (population > 0) {
            System.out.println("Population du département " + departmentCode + ": " + 
                             String.format("%,d", population) + " habitants");
        } else {
            System.out.println("Département '" + departmentCode + "' non trouvé ou aucune donnée.");
        }
    }
} 