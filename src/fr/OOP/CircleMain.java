package fr.OOP;

public class CircleMain {
        public static void main(String[] args) {
            System.out.println("=== Testing Point class ===");
            Point p1 = new Point(5, 3);
            Point p2 = new Point(10, 7);
            System.out.println("Point p1: " + p1.toString());
            System.out.println("Point p2: " + p2.toString());
//            System.out.println("p1.getX() = " + p1.getX());
//            System.out.println("p1.getY() = " + p1.getY());

            System.out.println("\n=== Testing Circle class ===");
            Circle circle1 = new Circle(p1, 5);
            Circle circle2 = new Circle(new Point(0, 0), 10);
            System.out.println("Circle1: " + circle1.toString());
            System.out.print("Circle2 with display(): ");
            circle2.display();

            System.out.println("\n=== Testing Rectangle class ===");
            Rectangle rect1 = new Rectangle(p1, 4, 6);
            Rectangle rect2 = new Rectangle(new Point(2, 1), 8, 3);

            System.out.println("Rectangle1: " + rect1.toString());
            System.out.println("Points of rectangle1:");
            System.out.println("  Bottom left: " + rect1.getBottomLeftPoint());
            System.out.println("  Bottom right: " + rect1.getBottomRightPoint());
            System.out.println("  Top left: " + rect1.getTopLeftPoint());
            System.out.println("  Top right: " + rect1.getTopRightPoint());

            System.out.print("Rectangle2 with display(): ");
            rect2.display();
        }
}
