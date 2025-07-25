package fr.OOP;

public class SquareHerite extends Rectangle {
    private Couleur couleur;

    public SquareHerite(Point bottomLeftPoint, int side) {
        this(bottomLeftPoint, side, Couleur.getCouleurDefaut());
    }

    public SquareHerite(Point bottomLeftPoint, int side, Couleur couleur) {
        super(bottomLeftPoint, side, side, couleur);
        this.couleur = couleur;
    }

    @Override
    public Couleur getCouleur() {
        return couleur;
    }

    @Override
    protected String getType() {
        return "SQUARE";
    }

    @Override
    public String toString() {
        return "[SQUARE " + couleur.getCode() + " " + getBottomLeftPoint() + getBottomRightPoint() + getTopLeftPoint() + getTopRightPoint() + "]";
    }

    @Override
    public void display() {
        System.out.println(this);
    }

    public int getWidth() {
        return super.getWidth();
    }
    public int getHeight() {
        return super.getHeight();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (!(obj instanceof Rectangle) && !(obj instanceof Square) && !(obj instanceof SquareHerite)) return false;
        java.util.Collection<Point> thisPoints = this.getPoints();
        java.util.Collection<Point> otherPoints;
        Couleur otherColor;
        if (obj instanceof SquareHerite) {
            SquareHerite other = (SquareHerite) obj;
            otherPoints = other.getPoints();
            otherColor = other.getCouleur();
        } else if (obj instanceof Rectangle) {
            Rectangle other = (Rectangle) obj;
            otherPoints = other.getPoints();
            otherColor = other.getCouleur();
        } else { // Square
            Square other = (Square) obj;
            otherPoints = other.getPoints();
            otherColor = other.getCouleur();
        }
        return thisPoints.containsAll(otherPoints) && otherPoints.containsAll(thisPoints) && this.couleur == otherColor;
    }
} 