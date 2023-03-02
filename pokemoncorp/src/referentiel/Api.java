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
        // Initilaizing pokemons
        Pokemon racaillouRoche = new Racaillou("Racaillou Roche");
        Pokemon roucoulDodu = new Roucoul("Roucoul Dodu");
        Pokemon carapuceTortue = new Carapuce("Carapuce Tortue");
        Pokemon salamecheDragon = new Salameche("Salamèche Dragon");
        // Adding pokemons to the HashMap
        mesPokemons.put(racaillouRoche.getId(), racaillouRoche);
        mesPokemons.put(roucoulDodu.getId(), roucoulDodu);
        mesPokemons.put(carapuceTortue.getId(), carapuceTortue);
        mesPokemons.put(salamecheDragon.getId(), salamecheDragon);
    }

    // Api Constructor with no parametrs

    public Api() {
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
    }

}
