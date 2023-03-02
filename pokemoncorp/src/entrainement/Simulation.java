package pokemoncorp.src.entrainement;

import java.util.Scanner;

import pokemoncorp.src.referentiel.Api;

public class Simulation {

    private static Api api;

    public static void main(String[] args) {

        // initialisation API
        api = new Api();

        System.out.println("\nBienvenue sur le module d'entraînement de pokémons !");
        System.out.println("(merci de ne pas prévenir les avocats de Nintendo)");

        mainLoop: while (true) {
            // Affichage des options
            System.out.println("\n-----------------------------------------------------------");
            System.out.println("Veuillez entrez un nombre correspondant à l'option choisie :");
            System.out.println("1. Afficher tous les pokemons");
            System.out.println("2. Afficher tous les pokemons triés par niveau d'expérience");
            System.out.println("3. Afficher un pokemon grace à son ID");
            System.out.println("4. Afficher toutes les arènes");
            System.out.println("5. Lancer un combat de pokemons");
            System.out.println("6. Quitter ce magnifique module :'(");

            // récupération du choix
            Scanner scan = new Scanner(System.in);
            System.out.print("Votre choix : ");
            int option = 0;
            if (scan.hasNextInt()) {
                option = scan.nextInt();
            }
            scan.close();

            // Vérification du choix
            if (option < 1 || option > 6) {
                System.out.println("Veuillez entrer un nombre entre 1 et 5.");
                continue;
            }

            // on lance la méthode correspondante
            switch (option) {
                case (1) -> {
                    displayAllPokemon();
                }
                case (2) -> {
                    displayAllPokemonSortedByXP();
                }
                case (3) -> {
                    displayPokemonByID();
                }
                case (4) -> {
                    displayAllArene();
                }
                case (5) -> {
                    lancerUnCombat();
                }
                case (6) -> {
                    System.out.println("Ciao !");
                    break mainLoop;
                }
            }

        }

    }

    /**
     * Récupère tous les pokemons existants dans le référentiel via l'API
     */
    private static void displayAllPokemon() {

    }

    private static void displayAllPokemonSortedByXP() {

    }

    private static void displayPokemonByID() {

    }

    private static void displayAllArene() {

    }

    private static void lancerUnCombat() {

    }

}
