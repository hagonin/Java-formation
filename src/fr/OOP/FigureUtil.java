package fr.OOP;

import java.util.Iterator;
import java.util.Random;

public class FigureUtil {
    private static final Random RANDOM = new Random();

    //private helper method to generate a random Point
    private static Point getRandomPoint(){
        int randomX = (int)(Math.random() * 50);
        int randomY = (int)(Math.random() * 50);
        return new Point(randomX, randomY);
    }

    //public method to generate a random Circle
    public static Circle getRandomCircle(){
        Point randomCenter = getRandomPoint();
        int randomRadius = (int) (Math.random() * 20) + 1;
        return new Circle(randomCenter, randomRadius);
    }

    //public method to generate a random Rectangle
    public static Rectangle getRandomRectangle(){
        Point randomBottomLeft = getRandomPoint();
        int randomWidth = (int) (Math.random() * 50) + 1 ;
        int randomHeight = (int)(Math.random() * 50) + 1;
        return new Rectangle(randomBottomLeft, randomWidth, randomHeight);
    }

    //public method to generate a random Figure
    public static Figure getRandomFigure(){
        int type = (int) (Math.random() * 4); // 0, 1, 2, or 3
        switch (type) {
            case 0:
                return getRandomCircle();
            case 1:
                return getRandomRectangle();
            case 2:
                Point p = getRandomPoint();
                int side = (int) (Math.random() * 50) + 1;
                return new Square(p, side);
            default:
                Point start = getRandomPoint();
                int length = (int) (Math.random() * 50) + 1;
                boolean horizontal = Math.random() < 0.5;
                return new Segment(start, length, horizontal);
        }
    }

    //public method to generate a random Surfacable (Circle, Rectangle, or Square)
    public static Surfacable getRandomSurfacable() {
        int type = (int) (Math.random() * 3); // 0, 1, or 2
        switch (type) {
            case 0:
                return getRandomCircle();
            case 1:
                return getRandomRectangle();
            default:
                Point p = getRandomPoint();
                int side = (int) (Math.random() * 50) + 1;
                return new Square(p, side);
        }
    }

    // Returns a collection containing all the points from the provided figures
    public static java.util.Collection<Point> getPoints(Figure... figures) {
        java.util.ArrayList<Point> result = new java.util.ArrayList<>();
        for (Figure f : figures) {
            if (f != null) {
                result.addAll(f.getPoints());
            }
        }
        return result;
    }

    // Returns a random Figure with X and Y between min and max (inclusive)
    public static Figure getRandomFigure(int min, int max) {
        int type = (int) (Math.random() * 4); // 0, 1, 2, or 3
        int x = min + (int) (Math.random() * (max - min + 1));
        int y = min + (int) (Math.random() * (max - min + 1));
        switch (type) {
            case 0:
                int radius = 1 + (int) (Math.random() * 20);
                return new Circle(new Point(x, y), radius);
            case 1:
                int width = 1 + (int) (Math.random() * 50);
                int height = 1 + (int) (Math.random() * 50);
                return new Rectangle(new Point(x, y), width, height);
            case 2:
                int side = 1 + (int) (Math.random() * 50);
                return new Square(new Point(x, y), side);
            default:
                int length = 1 + (int) (Math.random() * 50);
                boolean horizontal = Math.random() < 0.5;
                return new Segment(new Point(x, y), length, horizontal);

        }
    }

    // Returns a collection of n random figures with no restriction on X and Y
    public static java.util.Collection<Figure> genere(int n) {
        java.util.ArrayList<Figure> result = new java.util.ArrayList<>();
        for (int i = 0; i < n; i++) {
            result.add(getRandomFigure(Integer.MIN_VALUE / 2, Integer.MAX_VALUE / 2));
        }
        return result;
    }

    // Returns the first Figure in the Dessin that covers the given point, or null if none do
    public static Figure getFigureEn(Point p, Dessin d) {
        Iterator<Figure> it = d.getFigure().iterator();
        while (it.hasNext()) {
            Figure f = it.next();
            if (f.cover(p)) {
                return f;
            }
        }
        return null;
    }
}
