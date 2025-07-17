package fr.OOP;

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

    // Returns an array containing all the points from the provided figures
    public static Point[] getPoints(Figure... figures) {
        // First pass: count total points
        int total = 0;
        for (Figure f : figures) {
            if (f != null) {
                total += f.getPoints().length;
            }
        }
        // Second pass: fill the array
        Point[] result = new Point[total];
        int idx = 0;
        for (Figure f : figures) {
            if (f != null) {
                for (Point p : f.getPoints()) {
                    result[idx++] = p;
                }
            }
        }
        return result;
    }
}
