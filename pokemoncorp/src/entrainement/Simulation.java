package pokemoncorp.src.entrainement;

import java.util.HashSet;
import java.util.Scanner;

import pokemoncorp.src.referentiel.Api;

public class Simulation {

    private static Api api;
    private static HashSet<Arene> arenes = new HashSet<>();

    public static void main(String[] args) {

        // initialisation API
        api = new Api();

        // initialisations des arènes
        // arenes.add(new Volcan());
        // arenes.add(new Prairie());
        // arenes.add(new MareAcide());

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
     * Puis affiche leur id + nom
     */
    private static void displayAllPokemon() {
        System.out.println("\n-----------------------------------------------------------");
        System.out.println("Affichage de tous les pokemons (id et nom) : ");
        api.getAllPokemon()
                .values()
                .stream()
                .forEach(poke -> {
                    System.out.println("ID : " + poke.getId() + " / Nom : " + poke.getNom());
                });

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
