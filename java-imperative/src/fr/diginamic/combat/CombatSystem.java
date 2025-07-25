package fr.diginamic.combat;

import java.util.Random;

public class CombatSystem {
    private static final Random random = new Random();

    public static boolean fight(Character character, Creature creature) {
        System.out.println("\n=== COMBAT CONTRE " + creature.getName().toUpperCase() + " ===");
        System.out.println("Un " + creature.getName() + " apparaît devant vous !");
        System.out.println(creature);
        System.out.println();

        int turn = 1;

        // Combat loop continues until someone dies
        while (character.isAlive() && creature.isAlive()) {
            System.out.println("--- Tour " + turn + " ---");

            // Calculate attack values for both combatants
            int characterAttack = character.calculateAttack();
            int creatureAttack = creature.calculateAttack();

            System.out.println("Votre attaque: " + characterAttack);
            System.out.println("Attaque de " + creature.getName() + ": " + creatureAttack);

            // Determine round winner and apply damage
            if (characterAttack > creatureAttack) {
                // Character wins this round
                int damage = characterAttack - creatureAttack;
                creature.takeDamage(damage);
                System.out.println("Vous infligez " + damage + " dégâts à " + creature.getName() + " !");

                if (creature.isAlive()) {
                    System.out.println(creature.getName() + " a encore " + creature.getHealthPoints() + " PV.");
                }
            } else if (creatureAttack > characterAttack) {
                // Creature wins this round
                int damage = creatureAttack - characterAttack;
                character.takeDamage(damage);
                System.out.println(creature.getName() + " vous inflige " + damage + " dégâts !");

                if (character.isAlive()) {
                    System.out.println("Il vous reste " + character.getHealthPoints() + " PV.");
                }
            } else {
                // Tie - no damage dealt
                System.out.println("Les attaques s'annulent ! Aucun dégât infligé.");
            }

            System.out.println();
            turn++;
        }

        // Determine and announce final result
        if (character.isAlive()) {
            System.out.println("🎉 VICTOIRE ! Vous avez vaincu " + creature.getName() + " !");

            // Award score points
            int pointsEarned = creature.getScoreReward();
            character.addScore(pointsEarned);
            System.out.println("Vous gagnez " + pointsEarned + " point(s) de score !");
            System.out.println("Score total: " + character.getScore());

            return true;
        } else {
            System.out.println("💀 DÉFAITE ! " + creature.getName() + " vous a vaincu...");
            return false;
        }
    }

    public static void handleReward(Character character) {
        // 50% chance of receiving a reward
        if (random.nextBoolean()) {
            System.out.println("\n Vous trouvez quelque chose d'intéressant !");

            // Randomly select reward type
            int rewardType = random.nextInt(4);

            switch (rewardType) {
                case 0:
                    character.addPotion(new HealingPotion());
                    System.out.println("Vous trouvez une Potion de Soin !");
                    break;
                case 1:
                    character.addPotion(new MinorAttackPotion());
                    System.out.println("Vous trouvez une Potion d'Attaque Mineure !");
                    break;
                case 2:
                    character.addPotion(new MajorAttackPotion());
                    System.out.println("Vous trouvez une Potion d'Attaque Majeure !");
                    break;
                case 3:
                    character.addScore(5);
                    System.out.println("Vous trouvez un trésor ! +5 points de score !");
                    System.out.println("Score total: " + character.getScore());
                    break;
            }
        } else {
            System.out.println("\nVous ne trouvez rien d'intéressant cette fois.");
        }
    }
}
