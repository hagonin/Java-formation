package fr.diginamic.combat;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Character {
    //character attributes
    private int strength;
    private int healthPoints;
    private int maxHealthPoints;
    private int score;

    //combat state
    private int attackBonus;
    private int combatsRemaining;

    //inventory system
    private List<Potion> inventory;

    //random number generator for character creation
    private static final Random random = new Random();

    public Character() {
        this.strength = generateRandomNumber(12,18);
        this.healthPoints = generateRandomNumber(20, 50);
        this.maxHealthPoints = this.maxHealthPoints; //start at full health
        this.score = 0;   //new chacracter starts with 0 score


        this.attackBonus = 0; //no attack bonus at start
        this.combatsRemaining = 0;

        this.inventory = new ArrayList<>();
        initializeInventory();
    }
    private void initializeInventory() {
        inventory.add(new HealingPotion());
        inventory.add(new MinorAttackPotion());
        inventory.add(new MajorAttackPotion());
    }

    private int generateRandomNumber(int min, int max) {
        return random.nextInt(max - min + 1) + min;
    }

    public int calculateAttack() {
        int baseAttack = strength + generateRandomNumber(1, 10);
        int totalAttack = baseAttack + attackBonus;

        // Apply temporary bonus logic
        if (combatsRemaining > 0) {
            combatsRemaining--;
            // If this was the last combat with bonus, reset it
            if (combatsRemaining == 0) {
                attackBonus = 0;
            }
        }
        return totalAttack;
    }

    public void takeDamage(int damage) {
        healthPoints = Math.max(0, healthPoints - damage);
    }

    public void heal(int amount) {
        healthPoints = Math.min(maxHealthPoints, healthPoints + amount);
    }

    public void applyAttackBonus(int bonus, int duration) {
        this.attackBonus += bonus;  // Bonuses stack if multiple potions are used
        this.combatsRemaining = Math.max(this.combatsRemaining, duration);
    }

    public void addScore(int points) {
        this.score += points;
    }

    public boolean usePotion(int index) {
        if (index < 0 || index >= inventory.size()) {
            return false;  // Invalid index
        }

        Potion potion = inventory.get(index);
        potion.use(this);  // Polymorphic method call
        inventory.remove(index);  // Remove used potion
        return true;
    }

    public void addPotion(Potion potion) {
        inventory.add(potion);
    }

    public boolean isAlive() {
        return healthPoints > 0;
    }

    public List<Potion> getInventory() {
        return new ArrayList<>(inventory);
    }

    // getter methods for accessing character attributes
    public int getStrength() { return strength; }
    public int getHealthPoints() { return healthPoints; }
    public int getMaxHealthPoints() { return maxHealthPoints; }
    public int getScore() { return score; }
    public int getAttackBonus() { return attackBonus; }
    public int getCombatsRemaining() { return combatsRemaining; }

    @Override
    public String toString() {
        StringBuilder info = new StringBuilder();
        info.append("=== ÉTAT DU PERSONNAGE ===\n");
        info.append("Force: ").append(strength).append("\n");
        info.append("Points de vie: ").append(healthPoints).append("/").append(maxHealthPoints).append("\n");
        info.append("Score: ").append(score).append("\n");

        if (attackBonus > 0) {
            info.append("Bonus d'attaque: +").append(attackBonus)
                    .append(" (").append(combatsRemaining).append(" combat(s) restant(s))\n");
        }

        info.append("Potions en inventaire: ").append(inventory.size());

        return info.toString();
    }
}
