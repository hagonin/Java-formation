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

    //  Constructeur par défaut créant un port avec des capacités standard
    public Port() {
        this(10, 5, 20, 500);
    }

    // Constructeur pour un port avec des limites de capacité personnalisées
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

    // Méthode pour garer un véhicule routier
    // Exception Si aucune place de parking n'est disponible pour ce type de véhicule
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

    //Exception Si aucune place d'amarrage n'est disponible
    public void amarer(Maritime vehicule) throws Exception {
        if (maritimes.size() >= maxMaritimes) {
            throw new Exception("Plus de place dans le bassin");
        }
        maritimes.add(vehicule);
    }

    // Méthode pour retirer un véhicule du port
    //Exception Si le véhicule n'est pas trouvé dans le port
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

    //Méthode pour obtenir du carburant du port
    //Exception Si le carburant disponible dans le réservoir du port est insuffisant
    public void obtenirCarburant(int quantite) throws Exception {
        if (reservoirActuel < quantite) {
            throw new Exception("Pas assez de carburant dans le port");
        }
        reservoirActuel -= quantite;
    }

    // Méthode pour remplir le réservoir de carburant du port à sa capacité maximale
    public void remplirReservoir() {
        reservoirActuel = reservoirMax;
    }

    //Méthodes pour obtenir la capacité maximale du réservoir de carburant
    public int getReservoirMax() {
        return reservoirMax;
    }

    //Méthode pour obtenir le niveau actuel de carburant dans le réservoir
    public int getReservoir() {
        return reservoirActuel;
    }

    //Méthode pour formatter la chaine de caractères montrant l'état du port avec bateaux et voiliers séparés
    @Override
    public String toString() {
        int nbBateaux = 0;
        int nbVoiliers = 0;

        for (Maritime maritime : maritimes) {
            if (maritime instanceof Bateau) {
                nbBateaux++;
            } else if (maritime instanceof Voilier) {
                nbVoiliers++;
            }
        }

        return "Port: " + voitures.size() + " voitures, " + motos.size() +
                " motos, " + nbBateaux + " bateaux, " + nbVoiliers + " voiliers, " +
                reservoirActuel + " litres de carburant restant";
    }
}
