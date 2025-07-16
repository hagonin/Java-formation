package fr.OOP;

public class Square extends Figure implements Surfacable {
    private Point bottomLeftPoint;
    private int side;

    public Square(Point bottomLeftPoint, int side) {
        this.bottomLeftPoint = bottomLeftPoint;
        this.side = side;
    }

    public Point getBottomLeftPoint() {
        return bottomLeftPoint;
    }

    public Point getBottomRightPoint() {
        return new Point(bottomLeftPoint.getX() + side, bottomLeftPoint.getY());
    }

    public Point getTopLeftPoint() {
        return new Point(bottomLeftPoint.getX(), bottomLeftPoint.getY() + side);
    }

    public Point getTopRightPoint() {
        return new Point(bottomLeftPoint.getX() + side, bottomLeftPoint.getY() + side);
    }

    protected String getType() {
        return "SQUARE";
    }

    public int getSide() {
        return side;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (!(obj instanceof Rectangle) && !(obj instanceof Square) && !(obj instanceof SquareHerite)) return false;
        if (obj instanceof Square) {
            Square other = (Square) obj;
            return this.getBottomLeftPoint().equals(other.getBottomLeftPoint()) &&
                   this.side == other.side;
        } else if (obj instanceof Rectangle) {
            Rectangle other = (Rectangle) obj;
            return this.getBottomLeftPoint().equals(other.getBottomLeftPoint()) &&
                   this.side == other.getWidth() &&
                   this.side == other.getHeight();
        } else if (obj instanceof SquareHerite) {
            SquareHerite other = (SquareHerite) obj;
            return this.getBottomLeftPoint().equals(other.getBottomLeftPoint()) &&
                   this.side == other.getWidth(); // width==height for SquareHerite
        }
        return false;
    }

    @Override
    public String toString() {
        return "[" + getType() + " " + getBottomLeftPoint().toString() +
                getBottomRightPoint().toString() +
                getTopLeftPoint().toString() +
                getTopRightPoint().toString() + "]";
    }

    @Override
    public double surface() {
        return side * side;
    }
} 