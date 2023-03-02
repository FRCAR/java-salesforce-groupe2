package pokemoncorp.src.referentiel.testing_files;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.print.attribute.HashAttributeSet;

import pokemoncorp.src.referentiel.Carapuce;
import pokemoncorp.src.referentiel.Pokemon;
import pokemoncorp.src.referentiel.Racaillou;
import pokemoncorp.src.referentiel.Roucoul;
import pokemoncorp.src.referentiel.Salameche;
//import pokemoncorp.src.referentiel.TypePokemon;

public class TestPokemon {

    public static void main(String[] args) {

        Set<Pokemon> listePokemons = new HashSet<Pokemon>();
        listePokemons.add(new Racaillou("Rattata"));
        listePokemons.add(new Roucoul("Pidgey"));
        listePokemons.add(new Carapuce("Raticate"));
        listePokemons.add(new Salameche("Kakuna"));
        for (

        Pokemon monPokemon : listePokemons) {
            System.out.println(monPokemon.getPrenom());
            System.out.println("mon pokemon appartient à la classe : " + monPokemon.getNomClass());
        }
    }

}
