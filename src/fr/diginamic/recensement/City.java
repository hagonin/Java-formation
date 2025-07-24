package fr.diginamic.recensement;

/**
 * Represents a city with its population and administrative information
 */
public class City {
    private String regionCode;
    private String regionName;
    private String departmentCode;
    private String cityCode;
    private String cityName;
    private int totalPopulation;

    /**
     * Constructor for City
     */
    public City(String regionCode, String regionName, String departmentCode, 
                String cityCode, String cityName, int totalPopulation) {
        this.regionCode = regionCode;
        this.regionName = regionName;
        this.departmentCode = departmentCode;
        this.cityCode = cityCode;
        this.cityName = cityName;
        this.totalPopulation = totalPopulation;
    }

    // Getters
    public String getRegionCode() {
        return regionCode;
    }

    public String getRegionName() {
        return regionName;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public String getCityCode() {
        return cityCode;
    }

    public String getCityName() {
        return cityName;
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

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public void setTotalPopulation(int totalPopulation) {
        this.totalPopulation = totalPopulation;
    }

    @Override
    public String toString() {
        return String.format("%s (%s) - Population: %,d", 
                           cityName, departmentCode, totalPopulation);
    }
} 