package pokemoncorp.src.referentiel;

public class Pokemon {

    private int nbPokemonCrees;
    protected final int id;
    protected int experience;
    protected final int ptDeVieMax;
    protected int ptDeVie;
    protected final TypePokemon type;
    protected Attaque attaque;

    // constructeur de la classe Pokémon
    public Pokemon(int id, TypePokemon type, int ptVieMax, Attaque attaque) {
        this.id = id;
        this.type = type;
        this.ptDeVieMax = ptVieMax;
        this.ptDeVie = ptVieMax;
        this.attaque = attaque;
    };

    // définition de la métode qui incrémente le nombre de Pokémon crées
    public void incrementNbPokemonCrees() {
        this.nbPokemonCrees++;

    }

    // définition de la méthode attaquePokemon
    public void attaquePokemon(Pokemon pokemonCible) {

    }

    public int getNbPokemonCrees() {
        return nbPokemonCrees;
    }

    public void setNbPokemonCrees(int nbPokemonCrees) {
        this.nbPokemonCrees = nbPokemonCrees;
    }

    public int getId() {
        return id;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getPtDeVieMax() {
        return ptDeVieMax;
    }

    public int getPtDeVie() {
        return ptDeVie;
    }

    public TypePokemon getType() {
        return type;
    }

    public Attaque getAttaque() {
        return attaque;
    }

}