package fr.diginamic.maison;

public class Wc extends Piece {
    public Wc(double superficie, int numEtage) {
        super(superficie, numEtage);
    }

    @Override
    public String getType() {
        return "Wc";
    }
}
