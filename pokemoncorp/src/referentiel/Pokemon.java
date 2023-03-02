package pokemoncorp.src.referentiel;

public class Pokemon {

    private static int nbPokemonCrees = 0;
    protected static int id;
    protected final String prenom;
    protected int experience;
    protected final int ptDeVieMax;
    protected int ptDeVie;
    protected final TypePokemon type;
    protected Attaque attaque;

    // constructeur de la classe Pokémon
    public Pokemon(String prenom, TypePokemon type, int ptVieMax, Attaque attaque) {
        Pokemon.id = nbPokemonCrees;
        this.prenom = prenom;
        this.type = type;
        this.ptDeVieMax = ptVieMax;
        this.ptDeVie = ptVieMax;
        this.attaque = attaque;
        incrementNbPokemonCrees();

    };

    // définition de la métode qui incrémente le nombre de Pokémon crées
    public void incrementNbPokemonCrees() {
        Pokemon.nbPokemonCrees++;

    }

    // ic on calcule le modificateur de dégat par attaque
    // A rajouter --> vérifictaion si degat>0 a voir dans simulation si on appel
    // reset PointdeVie
    public void ajoutDegat(int degat) {
        this.ptDeVie = this.ptDeVie * Math.round(degat / 100);
    }

    // définition de la méthode attaquePokemon
    public void attaquePokemon(Pokemon pokemonCible) {
        pokemonCible.ajoutDegat(this.attaque.getBonus(pokemonCible.getType()));
    }

    // définition de la méthode qui permet de réinitialiser les points de vie de
    // Pokémon
    public void resetPdtVie() {
        this.ptDeVie = ptDeVieMax;
    }

    public String getPrenom() {
        return prenom;
    }

    public int getNbPokemonCrees() {
        return nbPokemonCrees;
    }

    public void setNbPokemonCrees(int nbPokemonCrees) {
        Pokemon.nbPokemonCrees = nbPokemonCrees;
    }

    public static int getId() {
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