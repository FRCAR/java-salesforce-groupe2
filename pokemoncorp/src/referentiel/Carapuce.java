package pokemoncorp.src.referentiel;

public class Carapuce extends Pokemon {

    /**
     * Création d'un nouveau Pokemon
     * avec le constructeur de la clase mère Pokemon
     */
    Carapuce(String prenom) {
        super(prenom, "Carapuce", TypePokemon.EAU, 100, new Plouf());
    }
}
