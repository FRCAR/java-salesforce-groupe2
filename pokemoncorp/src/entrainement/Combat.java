package pokemoncorp.src.entrainement;

import pokemoncorp.src.referentiel.Pokemon;

public class Combat {
    private Pokemon pokemon1;
    private Pokemon pokemon2;
    private Arene arene;
    private boolean tourDeCombat;

    public boolean tourDeCombat() {
        this.tourDeCombat = Math.random() > 0.5;
        return this.tourDeCombat;
    }

    public Pokemon getpokemon1() {
        return pokemon1;
    }

    public Pokemon getpokemon2() {
        return pokemon2;
    }

    public Arene getArene() {
        return arene;
    }

    public Combat(Pokemon pokemon1, Pokemon pokemon2, Arene arene) {
        this.pokemon1 = pokemon1;
        this.pokemon2 = pokemon2;
        this.arene = arene;
    }

    Combat() {

    }

    /**
     * @return "pokemon1" si pokemon 1 gagne
     * @return "pokemon2" si pokemon 2 gagne
     * @return "null" si aucun pokemon ne gagne
     */
    public Pokemon lancerCombat() {
        // Le combat commence
        // application de l'effect unique de l'arène sur les deux pokemons
        this.arene.effetDebutCombat(pokemon2, pokemon1);
        Pokemon pokemonGagnant = null;

        boolean combatEnCours = true;
        while (combatEnCours) {
            // application de l'effet permanent de l'arène sur les deux pokemons
            // Gestion des cas où un des deux pokemons est mort (ou bien les deux meurent)
            this.arene.effetTourDeCombat(pokemon2, pokemon1);
            if (pokemon1.getPtDeVie() <= 0 && pokemon2.getPtDeVie() <= 0) {
                System.out.println("Les deux pokémons sont morts à cause de l'effet de l'arène, ÉGALITÉ !");
                combatEnCours = false;
            } else if (pokemon1.getPtDeVie() <= 0) {
                pokemonGagnant = pokemon2;
                System.out.println("Le pokémon 1 est mort à cause de l'effet de l'arène, Le pokémon 2 a gagné !");
                combatEnCours = false;
            } else if (pokemon2.getPtDeVie() <= 0) {
                pokemonGagnant = pokemon1;
                System.out.println("Le pokémon 2 est mort à cause de l'effet de l'arène, Le pokémon 1 a gagné !");
                combatEnCours = false;
            }

            if (tourDeCombat()) {
                // Cas ou le pokemon 1 est choisi aléatoirement pour attaquer en premier

                pokemon1.attaquePokemon(pokemon2);
                if (pokemon2.getPtDeVie() <= 0) {
                    pokemonGagnant = pokemon1;
                    System.out.println("Le pokémon 2 est KO, Le pokémon 1 a gagné !");
                    combatEnCours = false;
                } else {
                    pokemon2.attaquePokemon(pokemon1);
                    if (pokemon1.getPtDeVie() <= 0) {
                        pokemonGagnant = pokemon2;
                        System.out.println("Le pokémon 1 est KO, Le pokémon 2 a gagné !");
                        combatEnCours = false;
                    }

                }

                // Cas ou le pokemon 2 est choisi aléatoirement pour attaquer en premier

            } else {
                pokemon2.attaquePokemon(pokemon1);
                if (pokemon1.getPtDeVie() <= 0) {
                    pokemonGagnant = pokemon2;
                    System.out.println("Le pokémon 1 est KO, Le pokémon 2 a gagné !");
                    combatEnCours = false;
                } else {
                    pokemon1.attaquePokemon(pokemon2);
                    if (pokemon2.getPtDeVie() <= 0) {
                        pokemonGagnant = pokemon1;
                        System.out.println("Le pokémon 2 est KO, Le pokémon 1 a gagné !");
                        combatEnCours = false;
                    }

                }

            }

        }

        return pokemonGagnant;
    }

}