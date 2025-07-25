package fr.ExerciceNote.Vehicules;

import fr.ExerciceNote.Port;

public class Voiture extends Routier implements AMoteur {
    private int reservoir;

    public Voiture(String marque, String modele, String numImmat) {
        //Constructeur avec réservoir par défaut 50L
        this(marque, modele, numImmat,50);
    }

    //Constructeur avec réservoir customisé
    public Voiture(String marque, String modele, String numImmat, int reservoir){
            super(marque, modele, numImmat);
            if (reservoir <= 0) {
                throw new IllegalArgumentException("Le réservoir doit être supérieur à 0.");
            }
            this.reservoir = reservoir;
        }

    //Remplir le réservoir avec fuel du port
    public void remplirReservoir(Port port) throws Exception {
        port.obtenirCarburant(reservoir);
    }

    //Obtienir la capacité du réservoir
    @Override
    public int getReservoir() {
        return reservoir;
    }

    @Override
    public String toString() {
        return "Voiture " + super.toString();
    }
    }
