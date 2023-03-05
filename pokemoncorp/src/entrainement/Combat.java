package pokemoncorp.src.entrainement;

import pokemoncorp.src.referentiel.Pokemon;

/*
* creating combat class with the atributes needed
*/
public class Combat {
    private Pokemon pokemon1;
    private Pokemon pokemon2;
    private Arene arene;
    private boolean tourDeCombat;

    /*
     * function who picks randomly a pokemon 1 or 2 to start first in the combat
     */
    private boolean tourDeCombat() {
        this.tourDeCombat = Math.random() > 0.5;
        return this.tourDeCombat;
    }

    /**
     * @return pokemon1
     */
    public Pokemon getpokemon1() {
        return pokemon1;
    }

    /**
     * @return pokemon 2
     */
    public Pokemon getpokemon2() {
        return pokemon2;
    }

    /**
     * @return arenes 
     */
    public Arene getArene() {
        return arene;
    }

    /**
     * @param pokemon1
     * @param pokemon2
     * @param arene
     */
    public Combat(Pokemon pokemon1, Pokemon pokemon2, Arene arene) {
        this.pokemon1 = pokemon1;
        this.pokemon2 = pokemon2;
        this.arene = arene;
    }

    /**
     * @return to Simulation Pokemon 1 if pokemon 1 wins
     * @return to Simulation Pokemon 2 if pokemon 2 wins
     * @return to Simulation "null" if draw..
     */

    public Pokemon lancerCombat() {
        // Fight starts
        // Initialazing HP of pokemons to max HP (function resetPdtVie)
        pokemon1.resetPdtVie();
        pokemon2.resetPdtVie();
        // Applying arena first effect on both pokemons
        this.arene.effetDebutCombat(pokemon2, pokemon1);
        Pokemon pokemonGagnant = null;

        boolean combatEnCours = true;
        // while the fight is ongoing ..
        while (combatEnCours) {
            // Applying the arena tour effect on both pokemons
            // Gestion des cas où un des deux pokemons est mort (ou bien les deux meurent)
            this.arene.effetTourDeCombat(pokemon2, pokemon1);
            if (pokemon1.getPtDeVie() <= 0 && pokemon2.getPtDeVie() <= 0) {
                System.out.println("Les deux pokémons sont morts à cause de l'effet de l'arène, ÉGALITÉ !");
                combatEnCours = false;
                break;
            } else if (pokemon1.getPtDeVie() <= 0) {
                pokemonGagnant = pokemon2;
                System.out.println(pokemon1.getPrenom() + " est mort à cause de l'effet de l'arène, "
                        + pokemon2.getPrenom() + " a gagné !");
                combatEnCours = false;
                break;
            } else if (pokemon2.getPtDeVie() <= 0) {
                pokemonGagnant = pokemon1;
                System.out.println(pokemon2.getPrenom() + " est mort à cause de l'effet de l'arène, "
                        + pokemon1.getPrenom() + " a gagné !");
                combatEnCours = false;
                break;
            }

            // Heads or tails, function random..
            if (tourDeCombat()) {
                // If pokemon 1 is chosen to attack first..

                pokemon1.attaquePokemon(pokemon2);
                if (pokemon2.getPtDeVie() <= 0) {
                    pokemonGagnant = pokemon1;
                    System.out.println(pokemon2.getPrenom() + "est KO, " + pokemon1.getPrenom() + " a gagné !");
                    combatEnCours = false;
                } else {
                    pokemon2.attaquePokemon(pokemon1);
                    if (pokemon1.getPtDeVie() <= 0) {
                        pokemonGagnant = pokemon2;
                        System.out.println(pokemon1.getPrenom() + "est KO, " + pokemon2.getPrenom() + " a gagné !");
                        combatEnCours = false;
                    }

                }

                // If pokemon 2 is chosen to attack first..

            } else {
                pokemon2.attaquePokemon(pokemon1);
                if (pokemon1.getPtDeVie() <= 0) {
                    pokemonGagnant = pokemon2;
                    System.out.println(pokemon1.getPrenom() + "est KO, " + pokemon2.getPrenom() + " a gagné !");
                    combatEnCours = false;
                } else {
                    pokemon1.attaquePokemon(pokemon2);
                    if (pokemon2.getPtDeVie() <= 0) {
                        pokemonGagnant = pokemon1;
                        System.out.println(pokemon2.getPrenom() + "est KO, " + pokemon1.getPrenom() + " a gagné !");
                        combatEnCours = false;
                    }

                }

            }

        }

        return pokemonGagnant;
    }

}