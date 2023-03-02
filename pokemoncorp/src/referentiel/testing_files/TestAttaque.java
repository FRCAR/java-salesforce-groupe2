package pokemoncorp.src.referentiel.testing_files;

import pokemoncorp.src.referentiel.Battement;
import pokemoncorp.src.referentiel.Ecrasement;
import pokemoncorp.src.referentiel.Flameche;
import pokemoncorp.src.referentiel.Plouf;
import pokemoncorp.src.referentiel.TypePokemon;

/**
 * Dev Class to test Attaque.
 */
public class TestAttaque {

    public static void main(String[] args) {
        Plouf testPlouf = new Plouf();
        Flameche testFlameche = new Flameche();
        Battement testBatttement = new Battement();
        Ecrasement testEcrasement = new Ecrasement();

        System.out.println("Plouf : ");
        System.out.println("Degats : " + testPlouf.getDegats());
        for (TypePokemon type : TypePokemon.values()) {
            System.out.println("Bonus vs " + type + " : " + testPlouf.getBonus(type));
        }

        System.out.println(testPlouf.getClass());
    }

}
