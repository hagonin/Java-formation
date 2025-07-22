package fr.ExerciceNote;
import fr.ExerciceNote.Vehicules.*;
import java.util.ArrayList;
import java.util.List;

public class Port {
    private List<Voiture> voitures;
    private List<Moto> motos;
    private List<Maritime> maritimes;
    private int maxVoitures;
    private int maxMotos;
    private int maxMaritimes;
    private int reservoirMax;
    private int reservoirActuel;

    // Default constructor
    public Port() {
        this(10, 5, 20, 500);
    }

    // Constructor with custom limits
    public Port(int maxVoitures, int maxMotos, int maxMaritimes, int reservoirMax) {
        if (maxVoitures < 0 || maxMotos < 0 || maxMaritimes < 0) {
            throw new IllegalArgumentException("Number of parking spaces must be >= 0");
        }
        if (reservoirMax <= 0) {
            throw new IllegalArgumentException("Reservoir size must be > 0");
        }

        this.maxVoitures = maxVoitures;
        this.maxMotos = maxMotos;
        this.maxMaritimes = maxMaritimes;
        this.reservoirMax = reservoirMax;
        this.reservoirActuel = reservoirMax;

        this.voitures = new ArrayList<>();
        this.motos = new ArrayList<>();
        this.maritimes = new ArrayList<>();
    }

    // Park a road vehicle
    public void garer(Routier vehicule) throws Exception {
        if (vehicule instanceof Voiture) {
            if (voitures.size() >= maxVoitures) {
                throw new Exception("Plus de place pour les voitures");
            }
            voitures.add((Voiture) vehicule);
        } else if (vehicule instanceof Moto) {
            if (motos.size() >= maxMotos) {
                throw new Exception("Plus de place pour les motos");
            }
            motos.add((Moto) vehicule);
        }
    }

    // Moor a maritime vehicle
    public void amarer(Maritime vehicule) throws Exception {
        if (maritimes.size() >= maxMaritimes) {
            throw new Exception("Plus de place dans le bassin");
        }
        maritimes.add(vehicule);
    }

    // Remove a vehicle from port
    public void sortir(Vehicule vehicule) throws Exception {
        boolean removed = false;

        if (vehicule instanceof Voiture) {
            removed = voitures.remove(vehicule);
        } else if (vehicule instanceof Moto) {
            removed = motos.remove(vehicule);
        } else if (vehicule instanceof Maritime) {
            removed = maritimes.remove(vehicule);
        }

        if (!removed) {
            throw new Exception("Véhicule non trouvé dans le port");
        }
    }

    // Get fuel from port reservoir
    public void obtenirCarburant(int quantite) throws Exception {
        if (reservoirActuel < quantite) {
            throw new Exception("Pas assez de carburant dans le port");
        }
        reservoirActuel -= quantite;
    }

    // Refill port's fuel reservoir
    public void remplirReservoir() {
        reservoirActuel = reservoirMax;
    }

    public int getReservoirMax() { return reservoirMax; }
    public int getReservoir() { return reservoirActuel; }

    @Override
    public String toString() {
        return "Port: " + voitures.size() + " voitures, " + motos.size() +
                " motos, " + maritimes.size() + " bateaux/voiliers, " +
                reservoirActuel + " litres de carburant restant";
    }
}
