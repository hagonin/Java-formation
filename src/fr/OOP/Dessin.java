package fr.OOP;

import java.util.ArrayList;
import java.util.Collection;

public class Dessin {
    private ArrayList<Figure> figures;

    public Dessin() {
        this.figures = new ArrayList<>();
    }

    public Dessin(Collection<Figure> figures) {
        this.figures = new ArrayList<>(figures);
    }

    public boolean add(Figure f) {
        return figures.add(f);
    }

    public Collection<Figure> getFigure() {
        return figures;
    }
} 