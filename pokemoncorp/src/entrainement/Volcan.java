package pokemoncorp.src.entrainement;

import pokemoncorp.src.referentiel.Pokemon;

public abstract class Volcan extends Arene {
    Volcan(){

    };

    @Override
    public void effetDebutCombat(Pokemon pokemon1, Pokemon pokemon2){
        //perte de 20pts de vie
    };
}
