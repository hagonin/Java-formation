package fr.diginamic.maison;

import java.util.ArrayList;
import java.util.List;

public class Maison {
    private List<Piece> pieces;
    public Maison() {
        this.pieces = new ArrayList<>();
    }

    //add a new room
    public void ajouterPiece(Piece piece) {
        if (piece == null) {
            throw new IllegalArgumentException("La pièce ne peut pas être une pièce nulle à la maison.");
        }
        pieces.add(piece);
        System.out.println(piece.getType() + " ajoutée à la maison (" +
                piece.getSuperficie() + " m², étage " + piece.getNumEtage() + ")");
    }

    //calculate the total area of the house
    public double getSuperficieTotale(){
        double total = 0.0;
        for (Piece piece : pieces) {
            total += piece.getSuperficie();
        }
        return total;
    }

    //calculate the total surface area of rooms on a specific floor
    public double getSuperficieEtage(int numEtage) {
        double totalEtage = 0.0;
        for (Piece piece : pieces) {
            if (piece.getNumEtage() == numEtage) {
                totalEtage += piece.getSuperficie();
            }
        }
        return totalEtage;
    }

    //calculate total surface area for all rooms of a specific type
    //use bounded wildcards to allow any subclass of Piece
    public double getSuperficieParType(Class<? extends Piece> typePiece){
        double totalType = 0.0;
        for (Piece piece : pieces) {
            if (typePiece.isInstance(piece)) {
                totalType += piece.getSuperficie();
            }
        }
        return totalType;
    }
    //count num of rooms of a specific type
    public int getNombrePiecesParType(Class<? extends Piece> typePiece) {
        int count = 0;

        for (Piece piece : pieces) {
            if (typePiece.isInstance(piece)) {
                count++;
            }
        }

        return count;
    }

    //get the list of all rooms in the house
    public List<Piece> getPieces() {
        return new ArrayList<>(pieces); // return a copy to prevent external modification
    }

    //get all the rooms on a specific floor
    public List<Piece> getPiecesEtage(int numEtage) {
        List<Piece> piecesEtage = new ArrayList<>();
        for (Piece piece : pieces) {
            if (piece.getNumEtage() == numEtage) {
                piecesEtage.add(piece);
            }
        }
        return piecesEtage;
    }

    @Override
    public String toString() {
        StringBuilder desc = new StringBuilder("Maison avec les pièces suivantes :\n");
        for (Piece piece : pieces) {
            desc.append(piece.toString()).append("\n");
        }
        desc.append("Superficie totale : ").append(getSuperficieTotale()).append(" m²");
        return desc.toString();
    }
}
