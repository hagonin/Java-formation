package fr.diginamic.combat;

import java.util.Random;

public class HealingPotion extends Potion {
    private static final Random random = new Random();

    public HealingPotion() {
        super("Potion de Soin", "Restaure 5 à 10 points de vie");
    }

    @Override
    public void use(Character character) {
        int healAmount = random.nextInt(6) + 5;  // 5-10 healing
        character.heal(healAmount);
        System.out.println("Vous utilisez une potion de soin et récupérez " + healAmount + " points de vie.");
    }
}
