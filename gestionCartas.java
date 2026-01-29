package pokemonTCG;

import java.util.ArrayList;
import java.util.HashMap;

public class gestionCartas {

    public static void listarCartas() {
        System.out.println("==========================");
        System.out.println("  Pokemons Coleccionados");
        System.out.println("==========================");
        System.out.printf("%-5s%s %-10s%s %-22s%s %-10s%s %-9s%s %-6s%s %-4s%s %-8s%s %-8s%s %-13s%s %-14s%s %-10s%s %-7s%s", "ID", "|", "Nombre", "|", "Tipo", "|", "Hábitat", "|", "Altura", "|", "Peso", "|", "HP", "|", "Ataque", "|", "Defensa", "|", "Ataque esp.", "|", "Defensa esp.", "|", "Velocidad", "|", "Rareza", "|");
        System.out.println();

        ArrayList<HashMap<String,String>> pokemons = utilidades.cargarPokemonData("C:\\Users\\pablo\\Desktop\\TCGjava\\pokemon_data.txt");

        for (HashMap<String,String> pokemon : pokemons) {
            if (estadoJugador.estadoJugador.get(pokemon.get("Nombre")) != 0) {
                System.out.printf("%-5s%s %-10s%s %-15s%s %-10s%s %-9s%s %-6s%s %-4s%s %-8s%s %-8s%s %-13s%s %-14s%s %-10s%s %-7s%s", pokemon.get("Numero Pokedex"), "|", pokemon.get("Nombre"), "|", pokemon.get("Tipo/s"), "|", pokemon.get("Habitat"), "|", pokemon.get("Altura"), "|", pokemon.get("Peso"), "|", pokemon.get("HP"), "|", pokemon.get("Ataque"), "|", pokemon.get("Defensa"), "|", pokemon.get("Ataque Esp"), "|", pokemon.get("Defensa Esp"), "|", pokemon.get("Velocidad"), "|", pokemon.get("Rareza"), "|");
                System.out.println();
            }
            else {
                System.out.printf("%-5s%s %-10s%s %-15s%s %-10s%s %-9s%s %-6s%s %-4s%s %-8s%s %-8s%s %-13s%s %-14s%s %-10s%s %-7s%s", pokemon.get("Numero Pokedex"), "|", "???", "|", "???", "|", "???", "|", "???", "|", "???", "|", "???", "|", "???", "|", "???", "|", "???", "|", "???", "|", "???", "|", "???", "|");
                System.out.println();
            }
        }

    }
}
