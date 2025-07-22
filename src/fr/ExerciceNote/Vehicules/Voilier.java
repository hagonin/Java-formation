package fr.ExerciceNote.Vehicules;

public class Voilier extends Maritime {
    public Voilier(String marque, String modele, String numImmat) {
        super(marque, modele, numImmat);
    }

    @Override
    public String toString() {
        return "Voilier " + super.toString();
    }
}


