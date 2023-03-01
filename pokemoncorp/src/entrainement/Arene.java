package pokemoncorp.src.entrainement;

import pokemoncorp.src.referentiel.Pokemon;
import pokemoncorp.src.referentiel.TypePokemon;

public abstract class Arene {
    protected final TypePokemon typePokemon;

    public TypePokemon getTypePokemon() {
        return typePokemon;
    };

    public abstract void effetDebutCombat(Pokemon pokemon1, Pokemon pokemon2);

    public abstract void effetTourDeCombat(Pokemon pokemon1, Pokemon pokemon2);
}