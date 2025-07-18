package fr.OOP;

public class TestShapes {
    public static void main(String[] args) {
        // Test Point class
        System.out.println("Testing Point class:");
        Point defaultPoint = new Point();
        System.out.println("Default Point: " + defaultPoint); // Should print default values

        Point customPoint = new Point(10, 20);
        System.out.println("Custom Point: " + customPoint); // Should print [10,20] or similar

        // If you have getX() and getY() methods, test them:
        // System.out.println("Custom Point X: " + customPoint.getX());
        // System.out.println("Custom Point Y: " + customPoint.getY());

        // Test FigureUtil class
        System.out.println("\nTesting FigureUtil:");

        Circle randomCircle = FigureUtil.getRandomCircle();
        System.out.println("Random Circle: " + randomCircle);

        Rectangle randomRectangle = FigureUtil.getRandomRectangle();
        System.out.println("Random Rectangle: " + randomRectangle);

        // Optionally, test multiple random shapes
        System.out.println("\nMultiple random shapes:");
        for (int i = 0; i < 3; i++) {
            System.out.println("Circle " + (i + 1) + ": " + FigureUtil.getRandomCircle());
            System.out.println("Rectangle " + (i + 1) + ": " + FigureUtil.getRandomRectangle());
        }

        // Test Square (no inheritance)
        System.out.println("\nTesting Square (no inheritance):");
        Point square1 = new Point(5,5);
        Square square = new Square(square1, 10);
        System.out.println("Square: " + square);
        square.display();

        // Test SquareHerite (inherits from Rectangle)
        System.out.println("\nTesting SquareHerite (inherits from Rectangle):");
        SquareHerite squareHerite = new SquareHerite(new Point(15, 15), 8);
        System.out.println("SquareHerite: " + squareHerite);
        squareHerite.display();

        // Test equals method for Point
        System.out.println("\nTesting equals method for Point:");
        Point p1 = new Point(1, 2);
        Point p2 = new Point(1, 2);
        Point p3 = new Point(2, 3);
        System.out.println("p1.equals(p2): " + p1.equals(p2)); // true
        System.out.println("p1.equals(p3): " + p1.equals(p3)); // false

        // Test equals method for Square and Rectangle
        System.out.println("\nTesting equals method for Square, Rectangle, and SquareHerite:");
        Square squareA = new Square(new Point(0, 0), 5);
        Square squareB = new Square(new Point(0, 0), 5);

        Rectangle rectA = new Rectangle(new Point(0, 0), 5, 5);
        Rectangle rectB = new Rectangle(new Point(0, 0), 5, 6);

        SquareHerite squareHeriteA = new SquareHerite(new Point(0, 0), 5);
        SquareHerite squareHeriteB = new SquareHerite(new Point(0, 0), 6);

        System.out.println("squareA.equals(squareB): " + squareA.equals(squareB)); // true
        System.out.println("squareA.equals(rectA): " + squareA.equals(rectA)); // true
        System.out.println("rectA.equals(squareA): " + rectA.equals(squareA)); // true
        System.out.println("rectA.equals(rectB): " + rectA.equals(rectB)); // false
        System.out.println("squareA.equals(squareHeriteA): " + squareA.equals(squareHeriteA)); // true
        System.out.println("squareHeriteA.equals(squareA): " + squareHeriteA.equals(squareA)); // true
        System.out.println("squareHeriteA.equals(squareHeriteB): " + squareHeriteA.equals(squareHeriteB)); // false

        // Test all subclasses of Figure explicitly
        System.out.println("\nTesting all subclasses of Figure:");
        Figure circle = new Circle(new Point(3, 4), 7);
        Figure rectangle = new Rectangle(new Point(1, 2), 5, 8);
        Figure figureSquare = new Square(new Point(6, 6), 4);
        Figure figureSquareHerite = new SquareHerite(new Point(8, 8), 5);

        Figure[] allFigures = {circle, rectangle, figureSquare, figureSquareHerite};

        for (int i = 0; i < allFigures.length; i++) {
            System.out.println("Subclass Figure " + (i+1) + ": " + allFigures[i]);
            allFigures[i].display();
        }

        // Test Segment class
        System.out.println("\nTesting Segment class:");
        Segment segment1 = new Segment(new Point(2, 2), 7, true);
        Segment segment2 = new Segment(new Point(3, 3), 5, false);
        System.out.println("Segment 1: " + segment1);
        System.out.println("Segment 2: " + segment2);
        segment1.display();
        segment2.display();

        // Test Surfacable interface
//        System.out.println("\nTesting Surfacable interface:");
//        Surfacable[] surfacables = {
//            new Circle(new Point(0, 0), 3),
//            new Rectangle(new Point(1, 1), 4, 6),
//            new Square(new Point(2, 2), 5)
//        };
//        for (int i = 0; i < surfacables.length; i++) {
//            System.out.println("Surfacable " + (i+1) + ": " + surfacables[i] + ", surface = " + surfacables[i].surface());
//        }

        // Test getRandomFigure()
//        System.out.println("\nTesting getRandomFigure():");
//        for (int i = 0; i < 5; i++) {
//            Figure f = FigureUtil.getRandomFigure();
//            System.out.println("Random Figure " + (i+1) + ": " + f.getClass().getSimpleName() + " - " + f);
//        }

        // Test getRandomSurfacable()
//        System.out.println("\nTesting getRandomSurfacable():");
//        for (int i = 0; i < 5; i++) {
//            Surfacable s = FigureUtil.getRandomSurfacable();
//            System.out.println("Random Surfacable " + (i+1) + ": " + s.getClass().getSimpleName() + " - " + s + ", surface = " + s.surface());
//        }

        // Test getPoints() feature
//        System.out.println("\nTesting getPoints() feature:");
//        Circle testCircle = new Circle(new Point(10, 10), 5);
//        Segment testSegment = new Segment(new Point(0, 0), 7, true);
//        Rectangle testRectangle = new Rectangle(new Point(2, 2), 4, 3);
//        Square testSquare = new Square(new Point(5, 5), 2);
//
//        Figure[] testFigures = {testCircle, testSegment, testRectangle, testSquare};
//        String[] figureNames = {"Circle", "Segment", "Rectangle", "Square"};
//        for (int i = 0; i < testFigures.length; i++) {
//            System.out.print(figureNames[i] + " points: ");
//            java.util.Collection<Point> pts = testFigures[i].getPoints();
//            for (Point p : pts) {
//                System.out.print(p + " ");
//            }
//            System.out.println();
//        }

        // Test FigureUtil.getPoints(Figure...)
//        System.out.println("All points from all figures:");
//        java.util.Collection<Point> allPoints = FigureUtil.getPoints(testFigures);
//        for (Point p : allPoints) {
//            System.out.print(p + " ");
//        }
//        System.out.println();
//
//        // Test Dessin and FigureUtil.genere(int n)
//        System.out.println("\nTesting Dessin and FigureUtil.genere(int n):");
//        Dessin dessin = new Dessin();
//        // Add a few figures manually
//        dessin.add(new Circle(new Point(10, 10), 5));
//        dessin.add(new Rectangle(new Point(2, 2), 4, 3));
//        dessin.add(new Square(new Point(5, 5), 2));
//        System.out.println("Figures in Dessin after manual add:");
//        for (Figure f : dessin.getFigure()) {
//            System.out.println(f);
//        }
//
//        // Generate random figures and add to Dessin
//        java.util.Collection<Figure> randomFigures = FigureUtil.genere(5);
//        System.out.println("\nRandomly generated figures:");
//        for (Figure f : randomFigures) {
//            System.out.println(f);
//            dessin.add(f);
//        }
//        System.out.println("\nAll figures in Dessin after adding random figures:");
//        for (Figure f : dessin.getFigure()) {
//            System.out.println(f);
//        }

        // Test cover(Point) and FigureUtil.getFigureEn(Point, Dessin)
        System.out.println("\nTesting cover(Point) and getFigureEn(Point, Dessin):");
        Dessin testDessin = new Dessin();
        Figure rect = new Rectangle(new Point(0, 0), 10, 5);
        Figure circ = new Circle(new Point(5, 5), 3);
        Figure seg = new Segment(new Point(2, 2), 6, true);
        Figure sq = new Square(new Point(8, 1), 4);
        testDessin.add(rect);
        testDessin.add(circ);
        testDessin.add(seg);
        testDessin.add(sq);

        Point[] testPoints = {
            new Point(1, 1),   // inside rect
            new Point(5, 5),   // inside circ and rect
            new Point(2, 2),   // on seg and in rect
            new Point(10, 5),  // on edge of rect
            new Point(9, 2),   // inside sq
            new Point(20, 20)  // outside all
        };
        for (Point p : testPoints) {
            System.out.print("Point " + p + " is covered by: ");
            Figure found = FigureUtil.getFigureEn(p, testDessin);
            if (found != null) {
                System.out.println(found.getType() + " " + found);
            } else {
                System.out.println("none");
            }
        }
    }
}
