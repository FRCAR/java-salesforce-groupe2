package pokemoncorp.src.referentiel;

public class Pokemon {

    private int nbPokemonCrees = 0;
    protected final int id;
    protected final String nom;
    protected int experience;
    protected final int ptDeVieMax;
    protected int ptDeVie;
    protected final TypePokemon type;
    protected Attaque attaque;

    // constructeur de la classe Pokémon
    public Pokemon(int id, String nom, TypePokemon type, int ptVieMax, Attaque attaque) {
        this.id = nbPokemonCrees;
        this.nom = nom;
        this.type = type;
        this.ptDeVieMax = ptVieMax;
        this.ptDeVie = ptVieMax;
        this.attaque = attaque;
        incrementNbPokemonCrees();

    };

    // définition de la métode qui incrémente le nombre de Pokémon crées
    public void incrementNbPokemonCrees() {
        this.nbPokemonCrees++;

    }

    // ic on calcule les dégats par attaque
    public void ajoutDegat(int degat) {
        this.ptDeVie = this.ptDeVie - (degat / 100);
    }

    // définition de la méthode attaquePokemon
    public void attaquePokemon(Pokemon pokemonCible) {
        pokemonCible.ajoutDegat(this.attaque.getBonus(pokemonCible.getType()));

    }

    public String getNom() {
        return nom;
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