package fr.OOP;

public class Rectangle extends Figure implements Surfacable {
    private Point bottomLeftPoint;
    private int width;
    private int height;

    // Constructor
    public Rectangle(Point bottomLeftPoint, int width, int height) {
        this.bottomLeftPoint = bottomLeftPoint;
        this.width = width;
        this.height = height;
    }

    // Getters
    public Point getBottomLeftPoint() {
        return bottomLeftPoint;
    }

    public Point getBottomRightPoint() {
        return new Point(bottomLeftPoint.getX() + width, bottomLeftPoint.getY());
    }

    public Point getTopLeftPoint() {
        return new Point(bottomLeftPoint.getX(), bottomLeftPoint.getY() + height);
    }

    public Point getTopRightPoint() {
        return new Point(bottomLeftPoint.getX() + width, bottomLeftPoint.getY() + height);
    }

    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }

    protected String getType() {
        return "RECT";
    }

    // toString() [RECT [X;Y][X;Y][X;Y][X;Y]]
    @Override
    public String toString() {
        return "[" + getType() + " " + getBottomLeftPoint().toString() +
                getBottomRightPoint().toString() +
                getTopLeftPoint().toString() +
                getTopRightPoint().toString() + "]";
    }

    //Equals method 
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (!(obj instanceof Rectangle) && !(obj instanceof Square) && !(obj instanceof SquareHerite)) return false;
        if (obj instanceof Rectangle) {
            Rectangle other = (Rectangle) obj;
            return this.getBottomLeftPoint().equals(other.getBottomLeftPoint()) &&
                   this.width == other.width &&
                   this.height == other.height;
        } else if (obj instanceof Square) {
            Square other = (Square) obj;
            return this.getBottomLeftPoint().equals(other.getBottomLeftPoint()) &&
                   this.width == other.getSide() &&
                   this.height == other.getSide();
        } else if (obj instanceof SquareHerite) {
            SquareHerite other = (SquareHerite) obj;
            return this.getBottomLeftPoint().equals(other.getBottomLeftPoint()) &&
                   this.width == other.getWidth() &&
                   this.height == other.getHeight();
        }
        return false;
    }

    @Override
    public double surface() {
        return width * height;
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
        int right = left + getWidth();
        int top = bottom + getHeight();
        return x >= left && x <= right && y >= bottom && y <= top;
    }
}
