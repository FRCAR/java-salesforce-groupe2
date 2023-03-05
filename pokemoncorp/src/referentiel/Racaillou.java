package pokemoncorp.src.referentiel;

public class Racaillou extends Pokemon {

    /**
     * Création d'un nouveau Pokemon
     * avec le constructeur de la clase mère Pokemon
     */
    Racaillou(String prenom) {
        super(prenom, "Racaillou", TypePokemon.SOL, 110, new Ecrasement());
    }

}