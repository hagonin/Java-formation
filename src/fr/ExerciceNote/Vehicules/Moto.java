package fr.ExerciceNote.Vehicules;

import fr.ExerciceNote.Port;

public class Moto extends Routier implements AMoteur {
    private int reservoir;

    public Moto(String marque, String modele, String numImmat) {
        this(marque, modele, numImmat, 20); // Default 20L tank
    }

    public Moto(String marque, String modele, String numImmat, int reservoir) {
        super(marque, modele, numImmat);
        if (reservoir <= 0) {
            throw new IllegalArgumentException("Reservoir size must be > 0");
        }
        this.reservoir = reservoir;
    }

    @Override
    public void remplirReservoir(Port port) throws Exception {
        port.obtenirCarburant(reservoir);
    }

    @Override
    public int getReservoir() { return reservoir; }

    @Override
    public String toString() {
        return "Moto " + super.toString();
    }
}