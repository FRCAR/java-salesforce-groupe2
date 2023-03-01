package pokemoncorp.src.referentiel;
import java.util.HashMap;

public class Api {
    private HashMap <Integer , Pokemon> mesPokemons = new HashMap<>(){{
    put(1, new Racaillou());
    put(2, new Roucoul());
    put(3, new Carapuce());
    put(4, new Salameche());
}};

    Api (){
    
    }

    public HashMap <Integer, Pokemon> getAllPokemon (){
        return mesPokemons;
    }
    
    public Pokemon getPokemonByID(int id){
        return mesPokemons.get((Integer) id);
        
    }

    public void updatePokemon (Pokemon pokemon , int addedExperience){
        pokemon.setExperience(pokemon.getExperience() + addedExperience);  
        mesPokemons.replace(pokemon.getId(), pokemon);
    }
    
}
