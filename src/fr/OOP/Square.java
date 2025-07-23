package fr.OOP;

public class Square extends Figure implements Surfacable {
    private Point bottomLeftPoint;
    private int side;
    private Couleur couleur;

    public Square(Point bottomLeftPoint, int side) {
        this(bottomLeftPoint, side, Couleur.getCouleurDefaut());
    }

    public Square(Point bottomLeftPoint, int side, Couleur couleur) {
        this.bottomLeftPoint = bottomLeftPoint;
        this.side = side;
        this.couleur = couleur;
    }

    public Point getBottomLeftPoint() {
        return bottomLeftPoint;
    }

    public Point getBottomRightPoint() {
        return new Point(bottomLeftPoint.getX() + side, bottomLeftPoint.getY());
    }

    public Point getTopLeftPoint() {
        return new Point(bottomLeftPoint.getX(), bottomLeftPoint.getY() + side);
    }

    public Point getTopRightPoint() {
        return new Point(bottomLeftPoint.getX() + side, bottomLeftPoint.getY() + side);
    }

    protected String getType() {
        return "SQUARE";
    }

    public int getSide() {
        return side;
    }

    @Override
    public Couleur getCouleur() {
        return couleur;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (!(obj instanceof Rectangle) && !(obj instanceof Square) && !(obj instanceof SquareHerite)) return false;
        java.util.Collection<Point> thisPoints = this.getPoints();
        java.util.Collection<Point> otherPoints;
        Couleur otherColor;
        if (obj instanceof Square) {
            Square other = (Square) obj;
            otherPoints = other.getPoints();
            otherColor = other.getCouleur();
        } else if (obj instanceof Rectangle) {
            Rectangle other = (Rectangle) obj;
            otherPoints = other.getPoints();
            otherColor = other.getCouleur();
        } else { // SquareHerite
            SquareHerite other = (SquareHerite) obj;
            otherPoints = other.getPoints();
            otherColor = other.getCouleur();
        }
        return thisPoints.containsAll(otherPoints) && otherPoints.containsAll(thisPoints) && this.couleur == otherColor;
    }

    @Override
    public String toString() {
        return "[SQUARE " + couleur.getCode() + " " + getBottomLeftPoint() + getBottomRightPoint() + getTopLeftPoint() + getTopRightPoint() + "]";
    }

    @Override
    public double surface() {
        return side * side;
    }

    @Override
    public java.util.Collection<Point> getPoints() {
        java.util.ArrayList<Point> pts = new java.util.ArrayList<>();
        pts.add(getBottomLeftPoint());
        pts.add(getBottomRightPoint());
        pts.add(getTopLeftPoint());
        pts.add(getTopRightPoint());
        return pts;
    }

    @Override
    public boolean cover(Point p) {
        int x = p.getX();
        int y = p.getY();
        int left = getBottomLeftPoint().getX();
        int bottom = getBottomLeftPoint().getY();
        int right = left + getSide();
        int top = bottom + getSide();
        return x >= left && x <= right && y >= bottom && y <= top;
    }
} 