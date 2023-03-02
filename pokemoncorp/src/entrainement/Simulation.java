package pokemoncorp.src.entrainement;

import java.util.Comparator;
import java.util.ArrayList;
import java.util.Scanner;

import pokemoncorp.src.referentiel.Api;
import pokemoncorp.src.referentiel.Pokemon;

public class Simulation {

    private static Api api;
    private static ArrayList<Arene> arenes = new ArrayList<>();
    private static Scanner scan;

    public static void main(String[] args) {

        scan = new Scanner(System.in);

        // initialisation API
        api = new Api();

        // initialisations des arènes
        arenes.add(new Volcan());
        arenes.add(new Prairie());
        arenes.add(new MareAcide());

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
            System.out.print("Votre choix : ");
            int option = 0;
            if (scan.hasNextInt()) {
                option = scan.nextInt();
            } else {
                scan.next();
            }

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

        scan.close();

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
                    System.out.println("ID : " + poke.getId() + " / Nom : " + poke.getPrenom());
                });

    }

    /**
     * Récupère tous les pokemons existants dans le référentiel via l'API
     * triés par leur expérience
     * Puis affiche leur id + nom
     */
    private static void displayAllPokemonSortedByXP() {
        System.out.println("\n-----------------------------------------------------------");
        System.out.println("Affichage de tous les pokemons (id et nom) triés par expérience : ");
        api.getAllPokemon()
                .values()
                .stream()
                .sorted(Comparator.comparingInt(Pokemon::getExperience)
                        .reversed())
                .forEach(poke -> {
                    System.out.println("ID : " + poke.getId() + " / Nom : " + poke.getPrenom() + " / Experience : "
                            + poke.getExperience());
                });

    }

    /**
     * Affiche les détails d'un pokemon, choisi par son id
     */
    private static void displayPokemonByID() {
        System.out.println("\n-----------------------------------------------------------");
        System.out.println("Affichage d'un pokemon : ");

        // Récupération de l'ID choisie par l'utilisateur
        System.out.print("Veuillez entrer l'ID du pokemon choisi : ");
        Pokemon lePokemon = getPokemonById();
        if (lePokemon == null) {
            return;
        }

        // On affiche ses attributs
        System.out.println("Le Pokemon choisi s'appelle : " + lePokemon.getPrenom());
        System.out.println("Le Pokemon choisi est de type : " + lePokemon.getType());
        System.out.println("Le Pokemon choisi est de l'espèce : " + lePokemon.getNomClass());
        System.out.println("Le Pokemon choisi a comme attaque : " + lePokemon.getAttaque().getNomClasse());
        System.out.println("Le Pokemon choisi a au maximum : " + lePokemon.getPtDeVieMax() + " HP");
        System.out.println("Le Pokemon choisi a : " + lePokemon.getExperience() + " XP");

    }

    /**
     * Affiche la liste des Arènes
     */
    private static void displayAllArene() {
        System.out.println("\n-----------------------------------------------------------");
        System.out.println("Affichage de toutes les arènes  disponibles : ");

        for (Arene monArene : arenes) {
            System.out.println(monArene.getNomClasse());
        }
    }

    /**
     * Lance un combat
     * L'utilisateurice choisit successivement 2 pokemons
     * Puis choisit une arène
     * Appelle ensuite la classe Combat qui gère le combat en lui-même
     * Le vainqueur gagne de l'expérience, via un appel de l'API.
     */
    private static void lancerUnCombat() {
        System.out.println("\n-----------------------------------------------------------");
        System.out.println("Combat de Pokemons ! ");

        // Récupération des pokemons choisis par l'utilisateur
        System.out.print("Veuillez entrer l'ID du premier pokemon choisi : ");
        Pokemon pokemon1 = getPokemonById();
        if (pokemon1 == null) {
            return;
        }

        System.out.print("Veuillez entrer l'ID du second pokemon choisi : ");
        Pokemon pokemon2 = getPokemonById();
        if (pokemon2 == null) {
            return;
        }

        // Verification que les pokemon choisis sont distincts
        if (pokemon1 == pokemon2) {
            System.out.println("On est pas dans Fight Club, merci.");
            return;
        }

        // choix Arene
        System.out.println("\n-----------------------------------------------------------");
        System.out.println("Veuillez choisir une arène parmi : ");
        for (int i = 0; i < arenes.size(); i++) {
            System.out.println(i + ". " + arenes.get(i).getNomClasse());
        }
        int numArene = 0;
        System.out.print("Veuillez entrer le numéro de l'arène choisie : ");
        if (scan.hasNextInt()) {
            numArene = scan.nextInt();
        } else {
            System.out.println("L'ID entré doit être un nombre.");
            scan.next();
            return;
        }

        // Vérification de l'existence d'une arène avec ce numéro
        if (numArene < 0 || numArene > arenes.size() - 1) {
            System.out.println("Aucune arène ne correspond à ce numéro : " + numArene);
            return;
        }

        Arene arene = arenes.get(numArene);

        // On lance le combat
        Combat unCombat = new Combat(pokemon1, pokemon2, arene);
        Pokemon vainqueur = unCombat.lancerCombat();

        // traitement du gain d'XP
        if (vainqueur != null) {
            Pokemon loser = vainqueur == pokemon1 ? pokemon2 : pokemon1;
            // calcul XP
            int experience = loser.getExperience() / 3;
            if (experience < 100) {
                experience = 100; // minimum de 100
            }

            System.out.println("Le vainqueur du combat, " + vainqueur.getPrenom()
                    + " gagne " + experience + " XP !");
            // on met à jour le pokemon via l'API
            api.updatePokemon(vainqueur, experience);
        }

    }

    /**
     * Use API to get a pokemon via its ID given by the user
     * Null if ID is not a number, or an unknown ID
     *
     * @return the selected Pokemon
     */
    private static Pokemon getPokemonById() {
        int id = 0;
        if (scan.hasNextInt()) {
            id = scan.nextInt();
        } else {
            System.out.println("L'ID entré doit être un nombre.");
            scan.next();
            return null;
        }

        // Vérification de l'existence d'un pokemon avec cet ID
        if (!api.getAllPokemon().containsKey(id)) {
            System.out.println("Aucun pokemon ne correspond à l'ID : " + id);
            return null;
        }

        // On récupère le pokemon et on affiche ses attributs
        return api.getPokemonByID(id);
    }

}
