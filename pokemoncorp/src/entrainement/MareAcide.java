package pokemoncorp.src.entrainement;

import pokemoncorp.src.referentiel.Pokemon;

/**
 * Classe fille de Arène
 */ 
public class MareAcide extends Arene {

    public MareAcide(){
        super("Mare Acide");
    };

    @Override
    public void effetDebutCombat(Pokemon pkA, Pokemon pkB) {
    };

    @Override
    public void effetTourDeCombat(Pokemon pkA, Pokemon pkB){
        pkA.ajoutDegat(5);
        pkB.ajoutDegat(5);
        System.out.println("L'arène Mare Acide inflige 5 points de dégats à tous les Pokémon !");
    };

}
