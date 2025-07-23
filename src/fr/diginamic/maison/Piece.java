package fr.diginamic.maison;

public abstract class Piece {
    protected double superficie;
    protected int numEtage;

    public Piece(double superficie, int numEtage) {
        this.superficie = superficie;
        this.numEtage = numEtage;
    }

    public double getSuperficie() {
        return superficie;
    }
    public int getNumEtage() {
        return numEtage;
    }

    public abstract String getType();

    @Override
    public String toString(){
       return String.format( "%s - %.1f m², (Étage: %d)", getType(), superficie, numEtage);
    }
}
