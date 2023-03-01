package pokemoncorp.src.referentiel;

import java.util.HashMap;

public abstract class Attaque {

    protected static HashMap<TypePokemon, HashMap<TypePokemon, Integer>> tableBonus = new HashMap<TypePokemon, HashMap<TypePokemon, Integer>>();
    protected final TypePokemon type;
    protected final int degats;

    static {
        for (iterable_type iterable_element : TypePokemon.values()) {

        }
    }

    public TypePokemon getType() {
        return type;
    }

    public int getDegats() {
        return degats;
    }

    public Attaque(int degats, TypePokemon type) {
        this.degats = degats;
        this.type = type;
    }

    public int getBonus(TypePokemon typePokemonCible) {

        return 0;
    }

}