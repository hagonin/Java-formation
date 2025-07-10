package fr.tableaux;

import java.util.Arrays;

/**
 * Classe SortedArray
 * 
 * Cette classe permet de trier un tableau d'entiers en ordre croissant ou décroissant.
 * Elle utilise l'algorithme de tri à bulles (bubble sort) et inclut une gestion
 * d'erreurs robuste pour les cas de tableaux null ou vides.
 * 
 * Fonctionnalités :
 * - Tri d'un tableau d'entiers en ordre croissant ou décroissant
 * - Validation des paramètres d'entrée
 * - Gestion d'erreurs pour les cas invalides
 * - Affichage du tableau trié
 */
public class SortedArray {

    private int [] data;
    // Indicateur de l'ordre de tri (true = croissant, false = décroissant)
    private boolean ascending;

    /**
     * Constructeur de la classe SortedArray
     * 
     * @param data tableau d'entiers à trier
     * @param ascending true pour un tri croissant, false pour un tri décroissant
     * @throws IllegalArgumentException si le tableau est null ou vide
     */
    public SortedArray(int [] data, boolean ascending) {
        // Validation des paramètres d'entrée
        if (data == null || data.length == 0) {
            throw new IllegalArgumentException("Le tableau ne peut pas être null ou vide");
        }
        this.data = data;
        this.ascending = ascending;
    }

    /**
     * Trie le tableau en utilisant l'algorithme de tri à bulles
     * Affiche un message d'erreur et s'arrête si le tableau est null ou vide
     */
    public void sort(){
        if (data == null || data.length == 0) {
            System.out.println("Erreur: Aucun nombre à trier!");
            return;
        }
        
        try {
            for (int i = 0; i < data.length - 1; i++) {
                for (int j = i + 1; j < data.length; j++) {
                    if ((ascending && data [i] > data [j]) || (!ascending && data [i] < data [j])) {
                        int temp = data [i];
                        data [i] = data [j];
                        data [j] = temp;
                    }
                }
            }
            System.out.println("Tri terminé avec succès.");
        } catch (Exception e) {
            System.err.println("Erreur lors du tri: " + e.getMessage());
        }
    }

    /**
     * Affiche le tableau ou un message spécifique s'il est null ou vide
     */
    public void display(){
        try {
            if (data == null) {
                System.out.println("Erreur: Aucun nombre à afficher");
            } else if (data.length == 0) {
                System.out.println("[]");
            } else {
                System.out.println(Arrays.toString(data));
            }
        } catch (Exception e) {
            System.err.println("Erreur lors de l'affichage: " + e.getMessage());
        }
    }
}

