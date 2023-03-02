package pokemoncorp.src.entrainement;

import pokemoncorp.src.referentiel.Pokemon;

public class Volcan extends Arene {

    public Volcan(){
        super("Volcan");
    };

    @Override
    public void effetDebutCombat(Pokemon pokemon1, Pokemon pokemon2){
        //perte de 20pts de vie
    }

    @Override
    public void effetTourDeCombat(Pokemon pkA, Pokemon pkB) {
    };
}
