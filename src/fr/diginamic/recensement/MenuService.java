package fr.diginamic.recensement;

import java.util.Scanner;

/**
 * Abstract class for menu services
 * Each menu option should extend this class and implement the traiter method
 */
public abstract class MenuService {
    
    /**
     * Abstract method to be implemented by all service classes
     * @param recensement The recensement data
     * @param scanner Scanner for user input
     */
    public abstract void traiter(Recensement recensement, Scanner scanner);
} 