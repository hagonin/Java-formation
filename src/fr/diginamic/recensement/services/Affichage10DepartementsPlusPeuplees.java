package fr.diginamic.recensement.services;

import fr.diginamic.recensement.Recensement;
import java.util.List;
import java.util.Scanner;

/**
 * Service to display the 10 most populated departments
 */
public class Affichage10DepartementsPlusPeuplees extends MenuService {
    
    @Override
    public void traiter(Recensement recensement, Scanner scanner) {
        System.out.println("Top 10 des départements les plus peuplés:");
        System.out.println("=========================================");
        
        List<String[]> topDepartments = recensement.getTop10Departments();
        
        for (int i = 0; i < topDepartments.size(); i++) {
            String[] deptData = topDepartments.get(i);
            String deptCode = deptData[0];
            String population = deptData[1];
            System.out.println((i + 1) + ". Département " + deptCode + " - Population: " + formatPopulation(population));
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