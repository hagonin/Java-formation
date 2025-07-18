package fr.OOP;

import java.util.List;

public class Segment extends Figure {
    private Point start, end;
    private int length;
    private boolean horizontal;

    //Constructor
    public Segment(Point start, int length, boolean horizontal) {
        this.start = start;
        this.length = length;
        this.horizontal = horizontal;
    }

    //Getters
    public Point getStart() {
        return start;
    }

    public int getLength() {
        return length;
    }

    public boolean isHorizontal() {
        return horizontal;
    }

    //Get the end point of the segment
    public Point getEnd() {
        if (horizontal) {
            return new Point(start.getX() + length, start.getY());
        } else {
            return new Point(start.getX(), start.getY() + length);
        }
    }

    //Get the type of the segment
    @Override
    protected String getType() {
        return "SEGMENT";
    }

    //Get the string representation of the segment
    @Override
    public String toString() {
        return "[" + start + " to " + getEnd() + "]";
    }

    @Override
    public java.util.Collection<Point> getPoints() {
        return List.of(start, end);
    }

    @Override
    public boolean cover(Point p) {
        if (horizontal) {
            return p.getY() == start.getY() &&
                   p.getX() >= start.getX() && p.getX() <= getEnd().getX();
        } else {
            return p.getX() == start.getX() &&
                   p.getY() >= start.getY() && p.getY() <= getEnd().getY();
        }
    }
} 