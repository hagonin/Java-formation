package fr.diginamic.recensement.services;

import fr.diginamic.recensement.Recensement;
import fr.diginamic.recensement.Departement;
import java.util.List;
import java.util.Scanner;

//Service to display the 10 most populated departments
public class Affichage10DepartementsPlusPeuplees extends MenuService {
    
    @Override
    public void traiter(Recensement recensement, Scanner scanner) {
        System.out.println("Top 10 des départements les plus peuplés:");
        System.out.println("=========================================");
        
        List<Departement> topDepartments = recensement.getTop10Departments();
        
        for (int i = 0; i < topDepartments.size(); i++) {
            System.out.println((i + 1) + ". " + topDepartments.get(i));
        }
    }
}