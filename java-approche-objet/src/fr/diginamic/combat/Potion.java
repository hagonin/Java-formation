package fr.diginamic.combat;

public abstract class Potion {
    protected String name;          // Display name of the potion
    protected String description;   // Description of the potion's effect

    protected Potion(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public abstract void use(Character character);

    // Getter methods for potion attributes
    public String getName() { return name; }
    public String getDescription() { return description; }

    @Override
    public String toString() {
        return name + " - " + description;
    }
}

