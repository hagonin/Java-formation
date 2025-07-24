package fr.diginamic.recensement;

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
        
        List<Region> topRegions = recensement.getTop10Regions();
        
        for (int i = 0; i < topRegions.size(); i++) {
            Region region = topRegions.get(i);
            System.out.println((i + 1) + ". " + region.toString());
        }
    }
} 