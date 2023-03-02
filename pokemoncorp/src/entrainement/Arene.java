package pokemoncorp.src.entrainement;

import pokemoncorp.src.referentiel.Pokemon;

/**
 * Classe mère Arène 
 */
public abstract class Arene {
    protected final String nomClasse;

    public Arene(String nomClasse){
        this.nomClasse = nomClasse;
    }

    public String getNomClasse() {
        return nomClasse;
    }

    public abstract void effetDebutCombat(Pokemon pkA, Pokemon pkB);

    public abstract void effetTourDeCombat(Pokemon pkA, Pokemon pkB);
}
