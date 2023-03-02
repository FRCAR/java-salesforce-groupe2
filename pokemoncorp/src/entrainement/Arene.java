package pokemoncorp.src.entrainement;

import pokemoncorp.src.referentiel.Pokemon;

public abstract class Arene {
    protected final String nomClasse;

    public Arene(String nomClasse){
        this.nomClasse = nomClasse;
    }

    public String getNomClasse() {
        return nomClasse;
    }

    public abstract void effetDebutCombat(Pokemon pk1, Pokemon pk2);

    public abstract void effetTourDeCombat(Pokemon pk1, Pokemon pk2);
}
