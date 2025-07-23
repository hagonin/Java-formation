package fr.diginamic.maison;

public class Cuisine extends Chambre {
    public Cuisine(double surficie, int numEtage) {
        super(surficie, numEtage);
    }

    @Override
    public String getType() {
        return "Cuisine";
    }
}
