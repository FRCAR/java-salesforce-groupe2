package pokemoncorp.src.entrainement;

import pokemoncorp.src.referentiel.Pokemon;

public class Combat {
    private Pokemon pokemonA;
    private Pokemon pokemonB;
    private Arene arene;
    private boolean tourDeCombat;


    public boolean tourDeCombat() {
        return tourDeCombat;
    }


    public Pokemon getPokemonA() {
        return pokemonA;
    }


    public Pokemon getPokemonB() {
        return pokemonB;
    }


    public Arene getArene() {
        return arene;
    }


    public Combat(Pokemon pokemonA, Pokemon pokemonB, Arene arene, boolean tourDeCombat) {
        this.pokemonA = pokemonA;
        this.pokemonB = pokemonB;
        this.arene = arene;
        this.tourDeCombat = tourDeCombat;
    }


    Combat(){

    }


    
    
}
