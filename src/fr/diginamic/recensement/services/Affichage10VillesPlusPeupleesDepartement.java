package fr.diginamic.recensement.services;

import fr.diginamic.recensement.Recensement;
import fr.diginamic.recensement.City;
import java.util.List;
import java.util.Scanner;

//Service to display the 10 most populated cities in a department
public class Affichage10VillesPlusPeupleesDepartement extends MenuService {
    
    @Override
    public void traiter(Recensement recensement, Scanner scanner) {
        System.out.print("Veuillez saisir le code du département: ");
        String departmentCode = scanner.nextLine();
        
        List<City> topCities = recensement.getTop10CitiesInDepartment(departmentCode);
        
        if (!topCities.isEmpty()) {
            System.out.println("Top 10 des villes les plus peuplées du département " + departmentCode + ":");
            System.out.println("================================================================");
            
            for (int i = 0; i < topCities.size(); i++) {
                City city = topCities.get(i);
                System.out.println((i + 1) + ". " + city.toString());
            }
        } else {
            System.out.println("Aucune ville trouvée pour le département '" + departmentCode + "'.");
        }
    }
}