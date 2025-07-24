package fr.diginamic.recensement.services;

import fr.diginamic.recensement.Recensement;
import fr.diginamic.recensement.City;
import java.util.List;
import java.util.Scanner;

/**
 * Service to display the 10 most populated cities in a region
 */
public class Affichage10VillesPlusPeupleesRegion extends MenuService {
    
    @Override
    public void traiter(Recensement recensement, Scanner scanner) {
        System.out.print("Veuillez saisir le nom de la région: ");
        String regionName = scanner.nextLine();
        
        List<City> topCities = recensement.getTop10CitiesInRegion(regionName);
        
        if (!topCities.isEmpty()) {
            System.out.println("Top 10 des villes les plus peuplées de la région " + regionName + ":");
            System.out.println("===========================================================");
            
            for (int i = 0; i < topCities.size(); i++) {
                City city = topCities.get(i);
                System.out.println((i + 1) + ". " + city.toString());
            }
        } else {
            System.out.println("Aucune ville trouvée pour la région '" + regionName + "'.");
        }
    }
}