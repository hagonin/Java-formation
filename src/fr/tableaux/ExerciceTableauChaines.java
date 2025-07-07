package fr.tableaux;

public class ExerciceTableauChaines {
    public static void main(String[] args) {
        String[] cities ={"Paris","Montpellier","Lyon","Montbéliard","Strabourg"};
        for(int i=0; i < cities.length; i++){
            System.out.println("Ville " + i + " : " + cities[i]);
        }
        System.out.println("Longueur du tableau : " + cities.length);
        System.out.println("-------Après modification--------");
        cities[3] = "Toulon";
        for(int i=0; i < cities.length; i++){
            System.out.println("Ville " + i + " : " + cities[i]);
        }
    }
}
