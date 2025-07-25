package fr.diginamic.combat;

public class MajorAttackPotion extends Potion {
    public MajorAttackPotion() {
        super("Potion d'Attaque Majeure", "+5 attaque pour les 2 prochains combats");
    }

    @Override
    public void use(Character character) {
        character.applyAttackBonus(5, 2);
        System.out.println("Vous utilisez une potion d'attaque majeure. +5 attaque pour les 2 prochains combats.");
    }
}
