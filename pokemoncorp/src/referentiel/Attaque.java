package pokemoncorp.src.referentiel;

public abstract class Attaque {

    protected final TypePokemon type;
    protected final int degats;

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