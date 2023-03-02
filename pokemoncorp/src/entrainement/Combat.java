package pokemoncorp.src.entrainement;

import pokemoncorp.src.referentiel.Pokemon;

public class Combat {
    private Pokemon pokemon1;
    private Pokemon pokemon2;
    private Arene arene;
    private boolean tourDeCombat;

    public boolean tourDeCombat() {
        this.tourDeCombat = Math.random() > 0.5;
        return this.tourDeCombat;
    }

    public Pokemon getpokemon1() {
        return pokemon1;
    }

    public Pokemon getpokemon2() {
        return pokemon2;
    }

    public Arene getArene() {
        return arene;
    }

    public Combat(Pokemon pokemon1, Pokemon pokemon2, Arene arene) {
        this.pokemon1 = pokemon1;
        this.pokemon2 = pokemon2;
        this.arene = arene;
    }

    Combat() {

    }

    public int lancerCombat() {
        int idGagant = 0;       

        boolean combatEnCours = true;
        while (combatEnCours) {
            // Le combat commence 
            if (tourDeCombat()) {
                // Cas ou le pokemon 1 est choisi aléatoirement pour attaquer en premier
                
                pokemon1.attaquePokemon(pokemon2);
                if (pokemon2.getPtDeVie() <= 0) {
                    idGagant = 1;
                    System.out.println("Le pokémon 2 est KO, Le pokémon 1 a gagné !");
                    combatEnCours = false;
                } else {
                    pokemon2.attaquePokemon(pokemon1);
                    if (pokemon1.getPtDeVie() <= 0) {
                        idGagant = 2;
                        System.out.println("Le pokémon 1 est KO, Le pokémon 2 a gagné !");
                        combatEnCours = false;
                    }

                }

                // Cas ou le pokemon 2 est choisi aléatoirement pour attaquer en premier

            } else {
                pokemon2.attaquePokemon(pokemon1);
                if (pokemon1.getPtDeVie() <= 0) {
                    idGagant = 2;
                    System.out.println("Le pokémon 1 est KO, Le pokémon 2 a gagné !");
                    combatEnCours = false;
                } else {
                    pokemon1.attaquePokemon(pokemon2);
                    if (pokemon2.getPtDeVie() <= 0) {
                        idGagant = 1;
                        System.out.println("Le pokémon 2 est KO, Le pokémon 1 a gagné !");
                        combatEnCours = false;
                    }
                    
                }


            }

        }
    
        return idGagant;
    }   
            
            
}