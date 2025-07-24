package fr.diginamic.recensement.services;

import fr.diginamic.recensement.Recensement;
import fr.diginamic.recensement.Region;
import java.util.List;
import java.util.Scanner;

//Service to display the 10 most populated regions
public class Affichage10RegionsPlusPeuplees extends MenuService {
    
    @Override
    public void traiter(Recensement recensement, Scanner scanner) {
        System.out.println("Top 10 des régions les plus peuplées:");
        System.out.println("=====================================");
        
        List<Region> topRegions = recensement.getTop10Regions();
        
        for (int i = 0; i < topRegions.size(); i++) {
            System.out.println((i + 1) + ". " + topRegions.get(i));
        }
    }
}