package fr.diginamic.combat;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class RPGGame {
    private Scanner scanner;
    private Character character;
    private Random random;

    public RPGGame() {
        this.scanner = new Scanner(System.in);
        this.random = new Random();
    }

    public void play() {
        System.out.println("=================================");
        System.out.println("  BIENVENUE DANS LE JEU RPG !   ");
        System.out.println("=================================");

        boolean continueGame = true;

        while (continueGame) {
            displayMenu();
            int choice = readUserChoice();

            switch (choice) {
                case 1:
                    createCharacter();
                    break;
                case 2:
                    fightCreature();
                    break;
                case 3:
                    usePotion();
                    break;
                case 4:
                    displayScore();
                    break;
                case 5:
                    continueGame = false;
                    System.out.println("Merci d'avoir joué ! À bientôt !");
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez choisir une option entre 1 et 5.");
            }

            if (continueGame) {
                System.out.println("\nAppuyez sur Entrée pour continuer...");
                scanner.nextLine();
            }
        }
    }

    //Displays the main game menu

    private void displayMenu() {
        System.out.println("\n" + "=".repeat(40));
        System.out.println("             MENU PRINCIPAL");
        System.out.println("=".repeat(40));
        System.out.println("1. Créer un personnage");
        System.out.println("2. Combattre une créature");
        System.out.println("3. Utiliser une potion");
        System.out.println("4. Afficher le score");
        System.out.println("5. Quitter");
        System.out.print("\nVotre choix: ");
    }

    private int readUserChoice() {
        try {
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            return choice;
        } catch (Exception e) {
            scanner.nextLine(); // Clear invalid input
            return -1; // Invalid choice
        }
    }

    //Creates a new character with random attributes
    private void createCharacter() {
        character = new Character();
        System.out.println("\n NOUVEAU PERSONNAGE CRÉÉ !");
        System.out.println(character);

        System.out.println("\nInventaire de départ:");
        List<Potion> inventory = character.getInventory();
        for (int i = 0; i < inventory.size(); i++) {
            System.out.println((i + 1) + ". " + inventory.get(i));
        }
    }

   //Handles creature combat encounters
    private void fightCreature() {
        // Check if character exists and is alive
        if (character == null || !character.isAlive()) {
            if (character != null) {
                System.out.println(" Votre personnage est mort. Son score était de " +
                        character.getScore() + " points.");
                System.out.println("Veuillez créer un nouveau personnage.");
            } else {
                System.out.println("Vous devez d'abord créer un personnage !");
            }
            return;
        }

        // Create random creature encounter
        Creature creature = createRandomCreature();

        // Execute combat
        boolean victory = CombatSystem.fight(character, creature);

        if (victory) {
            // Handle post-combat rewards
            CombatSystem.handleReward(character);
        }
    }

   //Creates a random creature for combat encounters
    private Creature createRandomCreature() {
        int creatureType = random.nextInt(3);

        switch (creatureType) {
            case 0:
                return new Wolf();
            case 1:
                return new Goblin();
            case 2:
                return new Troll();
            default:
                return new Wolf(); // Fallback case
        }
    }

    /**
     * Handles potion usage from the character's inventory.
     */
    private void usePotion() {
        if (character == null) {
            System.out.println("Vous devez d'abord créer un personnage !");
            return;
        }

        List<Potion> inventory = character.getInventory();

        if (inventory.isEmpty()) {
            System.out.println("Votre inventaire est vide ! Vous n'avez aucune potion à utiliser.");
            return;
        }

        System.out.println("\n=== INVENTAIRE DES POTIONS ===");
        for (int i = 0; i < inventory.size(); i++) {
            System.out.println((i + 1) + ". " + inventory.get(i));
        }

        System.out.print("\nQuelle potion souhaitez-vous utiliser ? (0 pour annuler): ");

        try {
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (choice == 0) {
                System.out.println("Utilisation de potion annulée.");
                return;
            }

            if (choice >= 1 && choice <= inventory.size()) {
                boolean success = character.usePotion(choice - 1);
                if (success) {
                    System.out.println("\n" + character);
                } else {
                    System.out.println("Erreur lors de l'utilisation de la potion.");
                }
            } else {
                System.out.println("Choix invalide !");
            }
        } catch (Exception e) {
            scanner.nextLine(); // Clear invalid input
            System.out.println("Veuillez entrer un nombre valide !");
        }
    }

    /**
     * Displays the current character's score and status.
     */
    private void displayScore() {
        if (character == null) {
            System.out.println("Vous devez d'abord créer un personnage !");
            return;
        }

        System.out.println("\n=== SCORE ET STATISTIQUES ===");
        System.out.println(character);

        if (!character.isAlive()) {
            System.out.println("\n PERSONNAGE DÉCÉDÉ");
            System.out.println("Score final: " + character.getScore() + " points");
        }
    }

    //Main method

    public static void main(String[] args) {
        RPGGame game = new RPGGame();
        game.play();
    }
}
