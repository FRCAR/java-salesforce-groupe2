package pokemoncorp.src.referentiel;

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
        System.out.println("Degats : " + testPlouf.degats);
        for (TypePokemon type : TypePokemon.values()) {
            System.out.println("Bonus vs " + type + " : " + testPlouf.getBonus(type));
        }
    }

}
