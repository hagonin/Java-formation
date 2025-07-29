package dev;

import com.github.lalyos.jfiglet.FigletFont;
import java.io.IOException;

public class App {
    public static void main(String[] args) {
        try {
            String asciiArt = FigletFont.convertOneLine("Hello World");
            System.out.println(asciiArt);
        } catch (IOException e) {
            System.err.println("Error generating ASCII art: " + e.getMessage());
        }
    }
}
