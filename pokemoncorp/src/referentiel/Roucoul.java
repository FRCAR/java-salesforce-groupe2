package pokemoncorp.src.referentiel;

public class Roucoul extends Pokemon {

    /**
     * Création d'un nouveau Pokemon
     * avec le constructeur de la clase mère Pokemon
     */
    Roucoul(String prenom) {
        super(prenom, "Roucoul", TypePokemon.AIR, 90, new Battement());
    }
}
