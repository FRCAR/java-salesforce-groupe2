package pokemoncorp.src.entrainement;

import pokemoncorp.src.referentiel.Pokemon;

public class MareAcide extends Arene {
    
    public MareAcide(){
        super("MareAcide");
    };

    @Override
    public void effetTourDeCombat(Pokemon pokemon1, Pokemon pokemon2){
        //perte de 5pts de vie
    }

    @Override
    public void effetDebutCombat(Pokemon pkA, Pokemon pkB) {
    };

}
