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
        Couleur couleur = Couleur.getRandomCouleur();
        return new Circle(randomCenter, randomRadius, couleur);
    }

    //public method to generate a random Rectangle
    public static Rectangle getRandomRectangle(){
        Point randomBottomLeft = getRandomPoint();
        int randomWidth = (int) (Math.random() * 50) + 1 ;
        int randomHeight = (int)(Math.random() * 50) + 1;
        Couleur couleur = Couleur.getRandomCouleur();
        return new Rectangle(randomBottomLeft, randomWidth, randomHeight, couleur);
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
                Couleur couleur = Couleur.getRandomCouleur();
                return new Square(p, side, couleur);
            default:
                Point start = getRandomPoint();
                int length = (int) (Math.random() * 50) + 1;
                boolean horizontal = Math.random() < 0.5;
                Couleur couleurSeg = Couleur.getRandomCouleur();
                return new Segment(start, length, horizontal, couleurSeg);
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
                Couleur couleur = Couleur.getRandomCouleur();
                return new Square(p, side, couleur);
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

    // Returns a list of figures sorted by distance to origin (closest first)
    public static java.util.List<Figure> trieProcheOrigine(Dessin d) {
        java.util.List<Figure> list = new java.util.ArrayList<>(d.getFigure());
        java.util.Collections.sort((java.util.List)list);
        return list;
    }

    // Returns a list of figures sorted by surface (largest first), only Surfacable
    public static java.util.List<Figure> trieDominant(Dessin d) {
        java.util.List<Figure> list = new java.util.ArrayList<>();
        for (Figure f : d.getFigure()) {
            if (f instanceof Surfacable) {
                list.add(f);
            }
        }
        list.sort((a, b) -> {
            double sa = ((Surfacable)a).surface();
            double sb = ((Surfacable)b).surface();
            return Double.compare(sb, sa); // largest to smallest
        });
        return list;
    }

    // Save a Dessin to a human-readable text file
    public static void save(Dessin drawing, String filename) {
        try (java.io.PrintWriter out = new java.io.PrintWriter(filename)) {
            for (Figure f : drawing.getFigure()) {
                if (f instanceof Circle) {
                    Circle c = (Circle) f;
                    out.printf("CIRCLE %c %d %d %d\n", c.getCouleur().getCode(), c.getCenter().getX(), c.getCenter().getY(), c.getRadius());
                } else if (f instanceof SquareHerite) {
                    SquareHerite s = (SquareHerite) f;
                    out.printf("SQUAREHERITE %c %d %d %d\n", s.getCouleur().getCode(), s.getBottomLeftPoint().getX(), s.getBottomLeftPoint().getY(), s.getWidth());
                } else if (f instanceof Square) {
                    Square s = (Square) f;
                    out.printf("SQUARE %c %d %d %d\n", s.getCouleur().getCode(), s.getBottomLeftPoint().getX(), s.getBottomLeftPoint().getY(), s.getSide());
                } else if (f instanceof Rectangle) {
                    Rectangle r = (Rectangle) f;
                    out.printf("RECT %c %d %d %d %d\n", r.getCouleur().getCode(), r.getBottomLeftPoint().getX(), r.getBottomLeftPoint().getY(), r.getWidth(), r.getHeight());
                } else if (f instanceof Segment) {
                    Segment s = (Segment) f;
                    out.printf("SEGMENT %c %d %d %d %b\n", s.getCouleur().getCode(), s.getStart().getX(), s.getStart().getY(), s.getLength(), s.isHorizontal());
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Error saving drawing: " + e.getMessage(), e);
        }
    }

    // Load a Dessin from a human-readable text file
    public static Dessin load(String filename) {
        Dessin dessin = new Dessin();
        try (java.io.BufferedReader in = new java.io.BufferedReader(new java.io.FileReader(filename))) {
            String line;
            while ((line = in.readLine()) != null) {
                String[] parts = line.trim().split("\\s+");
                if (parts.length < 1) continue;
                String type = parts[0];
                Couleur couleur = null;
                if (parts.length > 1) {
                    couleur = Couleur.valueOfCode(parts[1].charAt(0));
                }
                switch (type) {
                    case "CIRCLE":
                        if (parts.length == 5)
                            dessin.add(new Circle(new Point(Integer.parseInt(parts[2]), Integer.parseInt(parts[3])), Integer.parseInt(parts[4]), couleur));
                        break;
                    case "RECT":
                        if (parts.length == 6)
                            dessin.add(new Rectangle(new Point(Integer.parseInt(parts[2]), Integer.parseInt(parts[3])), Integer.parseInt(parts[4]), Integer.parseInt(parts[5]), couleur));
                        break;
                    case "SQUARE":
                        if (parts.length == 5)
                            dessin.add(new Square(new Point(Integer.parseInt(parts[2]), Integer.parseInt(parts[3])), Integer.parseInt(parts[4]), couleur));
                        break;
                    case "SQUAREHERITE":
                        if (parts.length == 5)
                            dessin.add(new SquareHerite(new Point(Integer.parseInt(parts[2]), Integer.parseInt(parts[3])), Integer.parseInt(parts[4]), couleur));
                        break;
                    case "SEGMENT":
                        if (parts.length == 6)
                            dessin.add(new Segment(new Point(Integer.parseInt(parts[2]), Integer.parseInt(parts[3])), Integer.parseInt(parts[4]), Boolean.parseBoolean(parts[5]), couleur));
                        break;
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Error loading drawing: " + e.getMessage(), e);
        }
        return dessin;
    }
}
