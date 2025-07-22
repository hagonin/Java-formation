package fr.OOP;

public enum Couleur {
    ROUGE('R'),
    VERT('V'),
    BLEU('B'),
    JAUNE('J'),
    NOIR('N');

    private final char code;

    Couleur(char code) {
        this.code = code;
    }

    public char getCode() {
        return code;
    }

    public static Couleur getCouleurDefaut() {
        return NOIR;
    }

    public static Couleur getRandomCouleur() {
        Couleur[] values = values();
        return values[(int) (Math.random() * values.length)];
    }

    public static Couleur valueOfCode(char code) {
        for (Couleur c : values()) {
            if (c.getCode() == code) return c;
        }
        throw new IllegalArgumentException("Unknown color code: " + code);
    }
} 