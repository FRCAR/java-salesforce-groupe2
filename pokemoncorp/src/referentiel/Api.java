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
    public Pokemon getPokemonByID(int id) {
        return mesPokemons.get((Integer) id);

    }


    /**
     * @param pokemon to get access to the Pokemon class
     * @param addedExperience to the pokemons (combat result)
     */
    public void updatePokemon(Pokemon pokemon, int addedExperience) {
        pokemon.setExperience(pokemon.getExperience() + addedExperience);
    }

}
