package fr.diginamic.recensement;

/**
 * Represents a department with its code and total population
 * Used for aggregating and displaying departmental population data
 */
public class Departement {
    private String code;
    private int totalPopulation;
    
    /**
     * Constructor for Departement
     */
    public Departement(String code, int totalPopulation) {
        this.code = code;
        this.totalPopulation = totalPopulation;
    }
    
    // Getters
    public String getCode() {
        return code;
    }
    
    public int getTotalPopulation() {
        return totalPopulation;
    }
    
    // Setters
    public void setCode(String code) {
        this.code = code;
    }
    
    public void setTotalPopulation(int totalPopulation) {
        this.totalPopulation = totalPopulation;
    }
    
    /**
     * Formatted string representation for display
     */
    @Override
    public String toString() {
        return "Département " + code + " - Population: " + String.format("%,d", totalPopulation);
    }
}