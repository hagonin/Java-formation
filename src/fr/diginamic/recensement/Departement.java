package fr.diginamic.recensement;

/**
 * Represents a department with aggregated population data
 */
public class Departement {
    private String departmentCode;
    private String departmentName;
    private int totalPopulation;

//Constructor for Departement
    public Departement(String departmentCode, String departmentName, int totalPopulation) {
        this.departmentCode = departmentCode;
        this.departmentName = departmentName;
        this.totalPopulation = totalPopulation;
    }

    // Getters
    public String getDepartmentCode() {
        return departmentCode;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public int getTotalPopulation() {
        return totalPopulation;
    }

    // Setters
    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public void setTotalPopulation(int totalPopulation) {
        this.totalPopulation = totalPopulation;
    }

    @Override
    public String toString() {
        return String.format("%s (%s) - Population: %,d",
                departmentName, departmentCode, totalPopulation);
    }
} 