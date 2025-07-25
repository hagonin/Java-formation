package fr.OOP;

import java.util.List;

public class Circle extends Figure implements Surfacable {
    private Point center;
    private int radius;
    private Couleur couleur;

    public Circle(Point center, int radius) {
        this(center, radius, Couleur.getCouleurDefaut());
    }

    public Circle(Point center, int radius, Couleur couleur) {
        this.center = center;
        this.radius = radius;
        this.couleur = couleur;
    }

    public Point getCenter() {
        return center;
    }

    public int getRadius() {
        return radius;
    }

    @Override
    public Couleur getCouleur() {
        return couleur;
    }

    @Override
    protected String getType() {
        return "CIRCLE";
    }

    @Override
    public String toString() {
        return "[CIRCLE " + couleur.getCode() + " Center: " + center + ", Radius: " + radius + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || !(obj instanceof Circle)) return false;
        Circle other = (Circle) obj;
        return this.center.equals(other.center) && this.radius == other.radius && this.couleur == other.couleur;
    }

    //Get the surface of the circle
    @Override
    public double surface() {
        return Math.PI * radius * radius;
    }

    @Override
    public java.util.Collection<Point> getPoints() {
       return List.of(center);
    }

    @Override
    public boolean cover(Point p) {
        int dx = p.getX() - center.getX();
        int dy = p.getY() - center.getY();
        return dx * dx + dy * dy <= radius * radius;
    }
}
