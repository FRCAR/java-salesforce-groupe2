package pokemoncorp.src.referentiel;

public class Pokemon {

    // déclataion des vartiables de la classe
    private static int nbPokemonCrees = 0;
    protected int id;
    protected String nomClass;
    protected final String prenom;
    protected int experience;
    protected final int ptDeVieMax;
    protected int ptDeVie;
    protected final TypePokemon type;
    protected Attaque attaque;

    // get le nom de Class
    public String getNomClass() {
        return nomClass;
    }

    // det le nom de class
    public void setNomClass(String nomClass) {
        this.nomClass = nomClass;
    }

    /*
     * constructeur de la classe Pokémon qui doit prends des parametres et fait
     ** appel à la métode qui autoincrémente le nombre de pokémon crées
     */
    public Pokemon(String prenom, String nomClass, TypePokemon type, int ptVieMax, Attaque attaque) {
        this.id = nbPokemonCrees;
        this.prenom = prenom;
        this.nomClass = nomClass;
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

    /*
     * / ic on calcule le modificateur de dégat par type attaque
     * et on initialise les points de vie par cette valeur
     */

    public void ajoutDegat(int degat) {
        this.ptDeVie = this.ptDeVie - degat;
    }

    /*
     * définition de la méthode attaquePokemon qui calcul le bonus en fonction du
     ** type attaque et de type Pokemon
     */
    public void attaquePokemon(Pokemon pokemonCible) {
        pokemonCible.ajoutDegat(this.attaque.getBonus(pokemonCible.getType()));
        System.out.println(this.prenom + " a infligé " + this.attaque.getBonus(pokemonCible.getType()) + " au Pokemon "
                + pokemonCible.getPrenom());
    }

    /*
     * définition de la méthode qui permet de réinitialiser les points de vie de
     ** Pokémon avec ses points de vie max initiaux
     */
    public void resetPdtVie() {
        this.ptDeVie = ptDeVieMax;
    }

    // get prénom du pokemon
    public String getPrenom() {
        return prenom;
    }

    // get nombre de pokémons crées
    public int getNbPokemonCrees() {
        return nbPokemonCrees;
    }

    // mise à jour du nombre de Pokemon crées
    public void setNbPokemonCrees(int nbPokemonCrees) {
        Pokemon.nbPokemonCrees = nbPokemonCrees;
    }

    // get id Pokemon
    public int getId() {
        return id;
    }

    // get Experience pokemon
    public int getExperience() {
        return experience;
    }

    // mise à jour expérience Pokemon
    public void setExperience(int experience) {
        this.experience = experience;
    }

    // get points de vie Max
    public int getPtDeVieMax() {
        return ptDeVieMax;
    }

    // Get points de vie
    public int getPtDeVie() {
        return ptDeVie;
    }

    // get Type pokemon
    public TypePokemon getType() {
        return type;
    }

    // get Attaque
    public Attaque getAttaque() {
        return attaque;
    }

}