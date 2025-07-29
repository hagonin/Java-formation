package fr.ExerciceNote.Vehicules;

public abstract class Vehicule {
    private String marque;
    private String modele;
    private String numImmat;

    public Vehicule(String marque, String modele, String numImmat) {
        this.marque = marque;
        this.modele = modele;
        this.numImmat = numImmat;
    }

    public String getMarque() {
        return marque;
    }

    public String getModele() {
        return modele;
    }

    public String getNumImmat() {
        return numImmat;
    }

    @Override
    public String toString() {
        return "N° : " + numImmat + ", Marque: " + marque + " " + modele;
    }
} 