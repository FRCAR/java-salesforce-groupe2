package pokemoncorp.src.referentiel;

public abstract class Pokemon {

    // déclaration des vartiables de la classe
    private static int nbPokemonCrees = 0;
    protected final int id;
    protected final String prenom;
    protected final TypePokemon type;
    protected int experience;
    protected final int ptDeVieMax;
    protected int ptDeVie;
    protected final Attaque attaque;
    protected final String nomClass;

    /**
     * constructeur de la classe Pokémon qui doit prends des parametres et fait
     * appel à la métode qui autoincrémente le nombre de pokémon crées
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

    /**
     * get nombre de pokémons crées
     */
    public static int getNbPokemonCrees() {
        return nbPokemonCrees;
    }

    /**
     * mise à jour du nombre de Pokemon crées
     * supprimé pour éviter une corruption du référentiel
     */
    // private void setNbPokemonCrees(int nbPokemonCrees) {
    // Pokemon.nbPokemonCrees = nbPokemonCrees;
    // }

    /**
     * définition de la métode qui incrémente le nombre de Pokémon crées
     */
    private void incrementNbPokemonCrees() {
        Pokemon.nbPokemonCrees++;
    }

    /**
     * get id Pokemon
     */
    public int getId() {
        return id;
    }

    /**
     * get prénom du pokemon
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * get Type pokemon
     */
    public TypePokemon getType() {
        return type;
    }

    /**
     * get Experience pokemon
     */
    public int getExperience() {
        return experience;
    }

    /**
     * mise à jour expérience Pokemon
     */
    void setExperience(int experience) {
        this.experience = experience;
    }

    /**
     * get Attaque
     */
    public Attaque getAttaque() {
        return attaque;
    }

    /**
     * get points de vie Max
     */
    public int getPtDeVieMax() {
        return ptDeVieMax;
    }

    /**
     * get points de vie
     */
    public int getPtDeVie() {
        return ptDeVie;
    }

    /**
     * définition de la méthode qui permet de réinitialiser les points de vie de
     * Pokémon avec ses points de vie max initiaux
     */
    public void resetPdtVie() {
        this.ptDeVie = ptDeVieMax;
    }

    /**
     * get le nom de Class
     */
    public String getNomClass() {
        return nomClass;
    }

    /**
     * ici on calcule le modificateur de dégat par type attaque
     * et on initialise les points de vie par cette valeur
     */
    public void ajoutDegat(int degat) {

        this.ptDeVie = this.ptDeVie - degat;
    }

    /**
     * définition de la méthode attaquePokemon qui calcul le bonus en fonction du
     * type attaque et de type Pokemon
     */
    public void attaquePokemon(Pokemon pokemonCible) {
        int degatTotaux = (int) ((double) this.attaque.getDegats()
                * (double) this.attaque.getBonus(pokemonCible.getType())
                / 100);
        pokemonCible.ajoutDegat(degatTotaux);
        System.out.println(this.prenom + " a infligé " + degatTotaux + " points de dégats au Pokémon "
                + pokemonCible.getPrenom() + "\n");
    }

}