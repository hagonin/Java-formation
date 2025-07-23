package fr.ExerciceNote.Vehicules;

import fr.ExerciceNote.Port;

public interface AMoteur {
    // Méthode pour remplir le carburant
    // Jette une exception si le port n'a pas assez de carburant ou si le ravitaillement échoue
    void remplirReservoir(Port port) throws Exception;

    // Méthode pour obtenir la capacité du réservoir de carburant du véhicule
    int getReservoir();
} 