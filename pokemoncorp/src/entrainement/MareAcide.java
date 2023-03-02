package pokemoncorp.src.entrainement;

import pokemoncorp.src.referentiel.Pokemon;

public class MareAcide extends Arene {

    public MareAcide(){
        super("MareAcide");
    };

    @Override
    public void effetDebutCombat(Pokemon pkA, Pokemon pkB) {
    };

    @Override
    public void effetTourDeCombat(Pokemon pkA, Pokemon pkB){
        pkA.ajoutDegat(5);
        pkB.ajoutDegat(5);
    }

}
