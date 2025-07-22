package fr.ExerciceNote.Vehicules;

import fr.ExerciceNote.Port;

public class Voiture extends Routier implements AMoteur {
    private int reservoir;

    public Voiture(String marque, String modele, String numImmat) {
        super(marque, modele, numImmat);
    }

    public Voiture(String marque, String modele, String numImmat, int reservoir){
            super(marque, modele, numImmat);
            if (reservoir <= 0) {
                throw new IllegalArgumentException("Le réservoir doit être supérieur à 0.");
            }
            this.reservoir = reservoir;
        }

        @Override
        public void remplirReservoir (Port port) throws Exception {
            port.obtenirCarburant(reservoir);
        }

        @Override
        public int getReservoir () {
            return reservoir;
        }

        @Override
        public String toString () {
            return "Voiture " + super.toString();
        }
    }
