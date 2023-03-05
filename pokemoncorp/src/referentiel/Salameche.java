package pokemoncorp.src.referentiel;

public class Salameche extends Pokemon {

    /**
     * Création d'un nouveau Pokemon
     * avec le constructeur de la clase mère Pokemon
     */
    Salameche(String prenom) {
        super(prenom, "Salameche", TypePokemon.FEU, 100, new Flameche());
    }
}
