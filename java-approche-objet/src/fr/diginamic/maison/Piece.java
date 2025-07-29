package fr.diginamic.maison;

public abstract class Piece {
    protected double superficie;
    protected int numEtage;

    public Piece(double superficie, int numEtage) {
        //use validation constructor approach
        validateSuperficie(superficie);
        validateNumEtage(numEtage);
        
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
    
    // Validation helper methods
    private void validateSuperficie(double superficie) {
        if (superficie <= 0) {
            throw new IllegalArgumentException("La superficie doit être positive (reçu: " + superficie + " m²)");
        }
        if (superficie > 10000) { // Reasonable upper limit
            throw new IllegalArgumentException("La superficie semble trop élevée (reçu: " + superficie + " m²)");
        }
    }
    
    private void validateNumEtage(int numEtage) {
        if (numEtage < -5) { // Allow basement levels but with reasonable limit
            throw new IllegalArgumentException("L'étage ne peut pas être inférieur à -5 (reçu: " + numEtage + ")");
        }
        if (numEtage > 50) { // Reasonable upper limit for floors
            throw new IllegalArgumentException("L'étage ne peut pas être supérieur à 50 (reçu: " + numEtage + ")");
        }
    }
}
