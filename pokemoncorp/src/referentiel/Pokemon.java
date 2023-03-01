package referentiel;

public class Pokemon {

    private int nbPokemonCrees;
    protected final int id;
    protected int experience;
    protected final int ptDeVieMax;
    protected int ptDeVie;
    protected final TypePokemon type;
    protected Attaque attaque;

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