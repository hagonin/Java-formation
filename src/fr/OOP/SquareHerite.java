package fr.OOP;

public class SquareHerite extends Rectangle {
    public SquareHerite(Point bottomLeftPoint, int side) {
        super(bottomLeftPoint, side, side);
    }

    @Override
    protected String getType() {
        return "SQUARE";
    }

    @Override
    public String toString() {
        return "[" + getType() + " " + getBottomLeftPoint().toString() +
                getBottomRightPoint().toString() +
                getTopLeftPoint().toString() +
                getTopRightPoint().toString() + "]";
    }

    @Override
    public void display() {
        System.out.println(this);
    }

    public int getWidth() {
        return super.getWidth();
    }
    public int getHeight() {
        return super.getHeight();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (!(obj instanceof Rectangle) && !(obj instanceof Square) && !(obj instanceof SquareHerite)) return false;
        if (obj instanceof SquareHerite) {
            SquareHerite other = (SquareHerite) obj;
            return this.getBottomLeftPoint().equals(other.getBottomLeftPoint()) &&
                   this.getWidth() == other.getWidth(); // width==height for SquareHerite
        } else if (obj instanceof Rectangle) {
            Rectangle other = (Rectangle) obj;
            return this.getBottomLeftPoint().equals(other.getBottomLeftPoint()) &&
                   this.getWidth() == other.getWidth() &&
                   this.getHeight() == other.getHeight() &&
                   this.getWidth() == this.getHeight(); // must be square
        } else if (obj instanceof Square) {
            Square other = (Square) obj;
            return this.getBottomLeftPoint().equals(other.getBottomLeftPoint()) &&
                   this.getWidth() == other.getSide();
        }
        return false;
    }
} 