package fr.OOP;

public abstract class Figure {
    public abstract String toString();
    protected abstract String getType();
    public abstract java.util.Collection<Point> getPoints();
    public abstract boolean cover(Point p);
    
    public void display() {
        System.out.println(this);
    }
} 