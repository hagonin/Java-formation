package fr.diginamic.maison;

public class Salon extends Piece{
    public Salon(double superficie, int numEtage) {
        super(superficie, numEtage);
    }

    @Override
    public String getType() {
        return "Salon/Séjour";
    }
}
