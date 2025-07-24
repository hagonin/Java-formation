package fr.diginamic.recensement.services;

import fr.diginamic.recensement.Recensement;
import java.util.List;
import java.util.Scanner;

/**
 * Service to display the 10 most populated regions
 */
public class Affichage10RegionsPlusPeuplees extends MenuService {
    
    @Override
    public void traiter(Recensement recensement, Scanner scanner) {
        System.out.println("Top 10 des régions les plus peuplées:");
        System.out.println("=====================================");
        
        List<String[]> topRegions = recensement.getTop10Regions();
        
        for (int i = 0; i < topRegions.size(); i++) {
            String[] regionData = topRegions.get(i);
            String regionName = regionData[0];
            String population = regionData[1];
            System.out.println((i + 1) + ". " + regionName + " - Population: " + formatPopulation(population));
        }
    }
    
    private String formatPopulation(String population) {
        try {
            int pop = Integer.parseInt(population);
            return String.format("%,d", pop);
        } catch (NumberFormatException e) {
            return population;
        }
    }
}