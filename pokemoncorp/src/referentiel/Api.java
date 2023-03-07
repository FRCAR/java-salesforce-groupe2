package pokemoncorp.src.referentiel;

import java.util.HashMap;

public class Api {
    /**
     * this class acts as an external data source, it provides functions to retrieve
     * :
     * - all pokemons
     * - One pokemon by providing its Id
     * This api provides the possibilty to update a pokemon (add experience)
     */
    private static HashMap<Integer, Pokemon> mesPokemons = new HashMap<>();

    static {
        /**
         * this function is set first of all to create & intialize pokemons
         * in the second part, we add the pokemons created to the HashMap
         */
        Pokemon pokemon1 = new Racaillou("Muscle");
        Pokemon pokemon2 = new Roucoul("Windy");
        Pokemon pokemon3 = new Carapuce("Caracara");
        Pokemon pokemon4 = new Salameche("Salam");
        Pokemon pokemon5 = new Racaillou("Rock");
        Pokemon pokemon6 = new Roucoul("Ailes");
        Pokemon pokemon7 = new Carapuce("Turtle");
        Pokemon pokemon8 = new Salameche("Backfire");
        // Adding pokemons to the HashMap
        mesPokemons.put(pokemon1.getId(), pokemon1);
        mesPokemons.put(pokemon2.getId(), pokemon2);
        mesPokemons.put(pokemon3.getId(), pokemon3);
        mesPokemons.put(pokemon4.getId(), pokemon4);
        mesPokemons.put(pokemon5.getId(), pokemon5);
        mesPokemons.put(pokemon6.getId(), pokemon6);
        mesPokemons.put(pokemon7.getId(), pokemon7);
        mesPokemons.put(pokemon8.getId(), pokemon8);
    }

    /**
     * @return all pokemons from the HashMap
     */
    public HashMap<Integer, Pokemon> getAllPokemon() {
        return mesPokemons;
    }

    /**
     * @param id
     * @return one pokemon by its ID
     */
    public Pokemon getPokemonByID(Integer id) {
        return mesPokemons.get(id);
    }

    /**
     * @param pokemon         to get access to the Pokemon class
     * @param addedExperience to the pokemons (combat result)
     */
    public void updatePokemon(Pokemon pokemon, int addedExperience) {
        pokemon.setExperience(pokemon.getExperience() + addedExperience);
    }

}
