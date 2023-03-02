package pokemoncorp.src.entrainement;

import pokemoncorp.src.referentiel.Pokemon;

public class Volcan extends Arene {

    public Volcan(){
        super("Volcan");
    };

    @Override
    public void effetDebutCombat(Pokemon pkA, Pokemon pkB){
        pkA.ajoutDegat(20);
        pkB.ajoutDegat(20);
    }

    @Override
    public void effetTourDeCombat(Pokemon pkA, Pokemon pkB) {
    };
}
