package fr.ExerciceNote.Vehicules;

import fr.ExerciceNote.Port;

public interface AMoteur {
    void remplirReservoir(Port port) throws Exception;
    int getReservoir();
} 