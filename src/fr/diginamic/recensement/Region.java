package fr.diginamic.recensement;

/**
 * Represents a region with its total population
 * Used for aggregating and displaying regional population data
 */
public class Region {
    private String name;
    private int totalPopulation;
    
    /**
     * Constructor for Region
     */
    public Region(String name, int totalPopulation) {
        this.name = name;
        this.totalPopulation = totalPopulation;
    }
    
    // Getters
    public String getName() {
        return name;
    }
    
    public int getTotalPopulation() {
        return totalPopulation;
    }
    
    // Setters
    public void setName(String name) {
        this.name = name;
    }
    
    public void setTotalPopulation(int totalPopulation) {
        this.totalPopulation = totalPopulation;
    }
    
    /**
     * Formatted string representation for display
     */
    @Override
    public String toString() {
        return name + " - Population: " + String.format("%,d", totalPopulation);
    }
}