package pokemoncorp.src.entrainement;

import pokemoncorp.src.referentiel.Pokemon;

/**
 * Classe fille de Arène
 */
public class Volcan extends Arene {

    public Volcan(){
        super("Volcan");
    };

    @Override
    public void effetDebutCombat(Pokemon pkA, Pokemon pkB){
        pkA.ajoutDegat(20);
        pkB.ajoutDegat(20);
        System.out.println("L'arène Mare Acide inflige 20 points de dégats à tous les Pokémon !");
    }

    @Override
    public void effetTourDeCombat(Pokemon pkA, Pokemon pkB) {
    };
}
