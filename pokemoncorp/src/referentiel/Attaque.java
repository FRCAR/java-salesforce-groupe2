package pokemoncorp.src.referentiel;

import java.util.HashMap;

public abstract class Attaque {

    protected static final int DEFAULT_BONUS = 100;
    protected static final HashMap<TypePokemon, HashMap<TypePokemon, Integer>> tableBonus = new HashMap<TypePokemon, HashMap<TypePokemon, Integer>>();
    protected final TypePokemon type;
    protected final int degats;

    // code executed at initialization of class (first call ?)
    static {
        // Creates all the 'lines' of the table. => the attaque type
        for (TypePokemon typePokemon : TypePokemon.values()) {
            tableBonus.put(typePokemon, new HashMap<TypePokemon, Integer>());
        }

        // Put all the values
        // i.e. tableBonus.get(attaque type).put(targeted pokemon type, bonus
        // percentage);
        tableBonus.get(TypePokemon.EAU).put(TypePokemon.EAU, 100);
        tableBonus.get(TypePokemon.EAU).put(TypePokemon.AIR, 75);
        tableBonus.get(TypePokemon.EAU).put(TypePokemon.SOL, 100);
        tableBonus.get(TypePokemon.EAU).put(TypePokemon.FEU, 125);

        tableBonus.get(TypePokemon.AIR).put(TypePokemon.EAU, 125);
        tableBonus.get(TypePokemon.AIR).put(TypePokemon.AIR, 100);
        tableBonus.get(TypePokemon.AIR).put(TypePokemon.SOL, 75);
        tableBonus.get(TypePokemon.AIR).put(TypePokemon.FEU, 100);

        tableBonus.get(TypePokemon.SOL).put(TypePokemon.EAU, 100);
        tableBonus.get(TypePokemon.SOL).put(TypePokemon.AIR, 125);
        tableBonus.get(TypePokemon.SOL).put(TypePokemon.SOL, 100);
        tableBonus.get(TypePokemon.SOL).put(TypePokemon.FEU, 75);

        tableBonus.get(TypePokemon.FEU).put(TypePokemon.EAU, 75);
        tableBonus.get(TypePokemon.FEU).put(TypePokemon.AIR, 100);
        tableBonus.get(TypePokemon.FEU).put(TypePokemon.SOL, 125);
        tableBonus.get(TypePokemon.FEU).put(TypePokemon.FEU, 100);
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
        if (getTableBonus().containsKey(this.type)) {
            if (getTableBonus().get(this.type).containsKey(typePokemonCible)) {
                return getTableBonus().get(this.type).get(typePokemonCible);
            }
        }
        return DEFAULT_BONUS;
    }

    public static HashMap<TypePokemon, HashMap<TypePokemon, Integer>> getTableBonus() {
        return tableBonus;
    }

}