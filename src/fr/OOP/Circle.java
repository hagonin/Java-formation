package fr.OOP;

public class Circle extends Figure implements Surfacable {
    private Point center;
    private int radius;

    public Circle(Point center, int radius) {
        this.center = center;
        this.radius = radius;
    }

    public Point getCenter() {
        return center;
    }

    public int getRadius() {
        return radius;
    }

    @Override
    protected String getType() {
        return "CIRCLE";
    }

    @Override
    public String toString() {
        return "[" + getType() + " Center: " + center + ", Radius: " + radius + "]";
    }

    //Get the surface of the circle
    @Override
    public double surface() {
        return Math.PI * radius * radius;
    }
}
