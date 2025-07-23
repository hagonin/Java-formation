package fr.diginamic.combat;

import java.util.Random;

public class Creature {
    protected String name;          // Display name for the creature
    protected int strength;         // Creature's strength attribute
    protected int healthPoints;     // Current health points
    protected int scoreReward;      // Points awarded for defeating this creature

    // Random number generator for combat calculations
    protected static final Random random = new Random();

    protected Creature(String name, int minStrength, int maxStrength, int minHealth, int maxHealth, int scoreReward) {
        this.name = name;
        this.strength = generateRandomNumber(minStrength, maxStrength);
        this.healthPoints = generateRandomNumber(minHealth, maxHealth);
        this.scoreReward = scoreReward;
    }

    protected int generateRandomNumber(int min, int max) {
        return random.nextInt(max - min + 1) + min;
    }

    public int calculateAttack() {
        return strength + generateRandomNumber(1, 10);
    }

    public void takeDamage(int damage) {
        healthPoints = Math.max(0, healthPoints - damage);
    }

    public boolean isAlive() {
        return healthPoints > 0;
    }

    // Getter methods for accessing creature attributes
    public String getName() { return name; }
    public int getStrength() { return strength; }
    public int getHealthPoints() { return healthPoints; }
    public int getScoreReward() { return scoreReward; }

    @Override
    public String toString() {
        return name + " (Force: " + strength + ", PV: " + healthPoints + ")";
    }
}
