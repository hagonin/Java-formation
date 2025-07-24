package fr.diginamic.recensement;

/**
 * Represents a region with aggregated population data
 */
public class Region {
    private String regionCode;
    private String regionName;
    private int totalPopulation;

    /**
     * Constructor for Region
     */
    public Region(String regionCode, String regionName, int totalPopulation) {
        this.regionCode = regionCode;
        this.regionName = regionName;
        this.totalPopulation = totalPopulation;
    }

    // Getters
    public String getRegionCode() {
        return regionCode;
    }

    public String getRegionName() {
        return regionName;
    }

    public int getTotalPopulation() {
        return totalPopulation;
    }

    // Setters
    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public void setTotalPopulation(int totalPopulation) {
        this.totalPopulation = totalPopulation;
    }

    @Override
    public String toString() {
        return String.format("%s - Population: %,d", regionName, totalPopulation);
    }
} 