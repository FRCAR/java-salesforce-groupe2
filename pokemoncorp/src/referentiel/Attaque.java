package pokemoncorp.src.referentiel;

import java.util.HashMap;

import pokemoncorp.src.referentiel.exceptions.InvalidPokemonTypeException;

/**
 * Abstract class. Children initializes degats and type.
 * Static attribute tableBonus stores the type weaknessed and strength
 * A bonus can be accessed with getBonus(TypePokemon typePokemonCible)
 */
public abstract class Attaque {

    protected static final HashMap<TypePokemon, HashMap<TypePokemon, Integer>> tableBonus = new HashMap<TypePokemon, HashMap<TypePokemon, Integer>>();
    protected final TypePokemon type;
    protected final int degats;
    protected final String nomClasse;

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

    private static HashMap<TypePokemon, HashMap<TypePokemon, Integer>> getTableBonus() {
        return tableBonus;
    }

    Attaque(int degats, TypePokemon type, String nomClasse) {
        this.degats = degats;
        this.type = type;
        this.nomClasse = nomClasse;
    }

    public TypePokemon getType() {
        return type;
    }

    public String getNomClasse() {
        return nomClasse;
    }

    public int getDegats() {
        return degats;
    }

    /**
     * get the bonus of this attaque against a
     * pokemon of the specified type
     * If the couple of types is unknown, returns a default value
     *
     * @param typePokemonCible : the TypePokemon of the targeted pokemon
     * @return bonus multiplier in percentage
     */
    public int getBonus(TypePokemon typePokemonCible) throws InvalidPokemonTypeException {
        if (getTableBonus().containsKey(this.type)) {
            if (getTableBonus().get(this.type).containsKey(typePokemonCible)) {
                return getTableBonus().get(this.type).get(typePokemonCible);
            }
        }

        throw new InvalidPokemonTypeException(
                "Le couple " + this.type + " / " + typePokemonCible + " n'existe pas dans la table des bonus.");

    }

}