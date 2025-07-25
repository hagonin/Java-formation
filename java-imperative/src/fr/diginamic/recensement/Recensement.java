package fr.diginamic.recensement;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Main data class that holds all cities from the CSV file
 * and provides methods for data access and aggregation
 */
public class Recensement {
    private List<City> cities;

    //Constructor
    public Recensement() {
        this.cities = new ArrayList<>();
    }

//Load cities from CSV file
    public void loadFromCSV(String filePath) {
        try (Scanner scanner = new Scanner(new File(filePath))) {
            // Skip header line
            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(";");

                if (parts.length >= 10) {
                    try {
                        String regionCode = parts[0].trim();
                        String regionName = parts[1].trim();
                        String departmentCode = parts[2].trim();
                        String cityCode = parts[5].trim();
                        String cityName = parts[6].trim();
                        // Parse population with potential thousands separators
                        String populationStr = parts[9].trim().replace(" ", "");
                        int population = Integer.parseInt(populationStr);

                        City city = new City(regionCode, regionName, departmentCode,
                                cityCode, cityName, population);
                        cities.add(city);
                    } catch (NumberFormatException e) {
                        System.err.println("Erreur de parsing pour la ligne: " + line);
                    }
                }
            }
            System.out.println("Chargement terminé: " + cities.size() + " villes chargées.");
        } catch (FileNotFoundException e) {
            System.err.println("Fichier non trouvé: " + filePath);
        }
    }

    //get all cities
    public List<City> getCities() {
        return cities;
    }

    //find city by name
    public City findCityByName(String cityName) {
        return cities.stream()
                .filter(city -> city.getCityName().equalsIgnoreCase(cityName))
                .findFirst()
                .orElse(null);
    }

    //Get total population for a department
    public int getPopulationByDepartment(String departmentCode) {
        return cities.stream()
                .filter(city -> city.getDepartmentCode().equalsIgnoreCase(departmentCode))
                .mapToInt(City::getTotalPopulation)
                .sum();
    }

    //Get total population for a region
    public int getPopulationByRegion(String regionName) {
        return cities.stream()
                .filter(city -> city.getRegionName().equalsIgnoreCase(regionName))
                .mapToInt(City::getTotalPopulation)
                .sum();
    }

    //Get top 10 most populated regions
    public List<Region> getTop10Regions() {
        Map<String, Integer> regionPopulations = new HashMap<>();
        for (City city : cities) {
            String regionName = city.getRegionName();
            regionPopulations.merge(regionName, city.getTotalPopulation(), Integer::sum);
        }
        return regionPopulations.entrySet().stream()
                .sorted((e1, e2) -> Integer.compare(e2.getValue(), e1.getValue()))
                .limit(10)
                .map(e -> new Region(e.getKey(), e.getValue()))
                .collect(Collectors.toList());
    }

    //Get top 10 most populated departments
    public List<Departement> getTop10Departments() {
        Map<String, Integer> deptPopulations = new HashMap<>();
        for (City city : cities) {
            String deptCode = city.getDepartmentCode();
            deptPopulations.merge(deptCode, city.getTotalPopulation(), Integer::sum);
        }
        return deptPopulations.entrySet().stream()
                .sorted((e1, e2) -> Integer.compare(e2.getValue(), e1.getValue()))
                .limit(10)
                .map(e -> new Departement(e.getKey(), e.getValue()))
                .collect(Collectors.toList());
    }

    //Get top 10 most populated cities in a department
    public List<City> getTop10CitiesInDepartment(String departmentCode) {
        return cities.stream()
                .filter(city -> city.getDepartmentCode().equalsIgnoreCase(departmentCode))
                .sorted((c1, c2) -> Integer.compare(c2.getTotalPopulation(), c1.getTotalPopulation()))
                .limit(10)
                .collect(Collectors.toList());
    }

    //Get top 10 most populated cities in a region
    public List<City> getTop10CitiesInRegion(String regionName) {
        return cities.stream()
                .filter(city -> city.getRegionName().equalsIgnoreCase(regionName))
                .sorted((c1, c2) -> Integer.compare(c2.getTotalPopulation(), c1.getTotalPopulation()))
                .limit(10)
                .collect(Collectors.toList());
    }

    //Get top 10 most populated cities in France
    public List<City> getTop10CitiesInFrance() {
        return cities.stream()
                .sorted((c1, c2) -> Integer.compare(c2.getTotalPopulation(), c1.getTotalPopulation()))
                .limit(10)
                .collect(Collectors.toList());
    }
} 