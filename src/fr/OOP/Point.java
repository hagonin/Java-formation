package fr.OOP;

public class Point {
    //static constants
    private static final int INIT_X = 25;
    private static final int INIT_Y = 25;

    private int  x;
    private int  y;

    // No-argument constructor
    public Point() {
        this.x = INIT_X;
        this.y = INIT_Y;
    }

    //Default Constructor
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    //toString method
    @Override
    public String toString() {
        return "Point{" + "x=" + x + ", y=" + y + '}';
    }

    //getters
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Point other = (Point) obj;
        return other.x == x && other.y == y;
    }
}
