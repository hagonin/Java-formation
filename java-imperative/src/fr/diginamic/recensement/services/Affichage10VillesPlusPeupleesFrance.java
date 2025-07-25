package fr.diginamic.recensement.services;

import fr.diginamic.recensement.Recensement;
import fr.diginamic.recensement.City;
import java.util.List;
import java.util.Scanner;

//Service to display the 10 most populated cities in France
public class Affichage10VillesPlusPeupleesFrance extends MenuService {
    
    @Override
    public void traiter(Recensement recensement, Scanner scanner) {
        System.out.println("Top 10 des villes les plus peuplées de France:");
        System.out.println("==============================================");
        
        List<City> topCities = recensement.getTop10CitiesInFrance();
        
        for (int i = 0; i < topCities.size(); i++) {
            City city = topCities.get(i);
            System.out.println((i + 1) + ". " + city.toString());
        }
    }
}