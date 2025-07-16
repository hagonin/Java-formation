package fr.OOP;

public abstract class Figure {
    public abstract String toString();
    protected abstract String getType();
    
    public void display() {
        System.out.println(this);
    }
} 