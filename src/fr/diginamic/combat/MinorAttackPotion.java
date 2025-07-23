package fr.diginamic.combat;

public class MinorAttackPotion extends Potion {
    public MinorAttackPotion() {
        super("Potion d'Attaque Mineure", "+3 attaque pour le prochain combat");
    }

    @Override
    public void use(Character character) {
        character.applyAttackBonus(3, 1);
        System.out.println("Vous utilisez une potion d'attaque mineure. +3 attaque pour le prochain combat.");
    }
}
