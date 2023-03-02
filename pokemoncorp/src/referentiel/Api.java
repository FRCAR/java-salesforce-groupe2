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
    private HashMap<Integer, Pokemon> mesPokemons = new HashMap<>() {
        {
            put(1, new Racaillou());
            put(2, new Roucoul());
            put(3, new Carapuce());
            put(4, new Salameche());
        }
    };

    // Api Constructor with no parameters
    Api() {

    }

    // Retrieving all pokemons
    public HashMap<Integer, Pokemon> getAllPokemon() {
        return mesPokemons;
    }

    // Retrieving one pokemon by Id
    public Pokemon getPokemonByID(int id) {
        return mesPokemons.get((Integer) id);

    }

    // Adding experience to a specific Pokemon
    public void updatePokemon(Pokemon pokemon, int addedExperience) {
        pokemon.setExperience(pokemon.getExperience() + addedExperience);
        mesPokemons.replace(pokemon.getId(), pokemon);
    }

}
