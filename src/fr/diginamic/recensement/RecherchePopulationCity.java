package fr.diginamic.recensement;

import java.util.Scanner;

/**
 * Service to search for population of a specific city
 */
public class RecherchePopulationCity extends MenuService {
    
    @Override
    public void traiter(Recensement recensement, Scanner scanner) {
        System.out.print("Veuillez saisir le nom de la ville: ");
        String cityName = scanner.nextLine();
        
        City city = recensement.findCityByName(cityName);
        
        if (city != null) {
            System.out.println("Population de " + city.getCityName() + ": " + 
                             String.format("%,d", city.getTotalPopulation()) + " habitants");
        } else {
            System.out.println("Ville '" + cityName + "' non trouvée.");
        }
    }
} 