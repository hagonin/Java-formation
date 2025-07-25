package fr.diginamic.operations;

public class CalculMoyenne {
    private double [] values;
    private int size;

    private static final int INITIAL_CAPACITY = 10;

    //create an empty array with initial capacity but size of 0
    public CalculMoyenne() {
        this.values = new double[INITIAL_CAPACITY];
        this.size = 0;
    }

    public void add(double value){
        if (size >= values.length) {
            redimensionner();
        }
        values[size] = value;
        size++;
    }

    private void redimensionner() {
        int newCapacity = values.length * 2;

        double[] newValues = new double[newCapacity];

        //copy existing values to the new array
        for (int i = 0; i < size; i++) {
            newValues[i] = values[i];
        }
        //replace the old array with the new one
        values = newValues;
    }

    public double calcul(){
        if (size == 0) {
            throw new IllegalStateException("No values to calculate the average.");
        }

        double sum = 0;
        for (int i = 0; i < size; i++) {
            sum += values[i];
        }

        return sum / size;
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return values.length;
    }
}
