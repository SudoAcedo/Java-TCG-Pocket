package pokemonTCG;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class lucha {

    public static void luchar() {

        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        ArrayList<HashMap<String, String>> todosLosPokemon = utilidades.cargarPokemonData("C:\\Users\\pablo\\Desktop\\TCGjava\\pokemon_data.txt");

        ArrayList<HashMap<String, String>> pokemonObtenidos = new ArrayList<>();

        for (HashMap<String, String> pokemon : todosLosPokemon) {

            if (estadoJugador.estadoJugador.get(pokemon.get("Nombre")) > 0) {
                pokemonObtenidos.add(pokemon);
            }
        }

        if (pokemonObtenidos.size() < 2) {
            System.out.println("❌ ERROR: Necesitas tener 2 cartas pokemon diferentes");
            return;
        }

        int pokemon1 = random.nextInt(pokemonObtenidos.size());
        int pokemon2 = random.nextInt(pokemonObtenidos.size());

        while (pokemon1 == pokemon2) {
            pokemon2 = random.nextInt(pokemonObtenidos.size());
        }

        HashMap<String, String> datosPokemon1 = pokemonObtenidos.get(pokemon1);
        HashMap<String, String> datosPokemon2 = pokemonObtenidos.get(pokemon2);

        System.out.println();
        System.out.println("¡Bienvenido a la Arena Pokémon!");
        System.out.println("-".repeat(22));
        System.out.println("Tu batalla será entre:");
        System.out.println();
        System.out.println("POKÉMON 1: " + datosPokemon1.get("Nombre"));
        System.out.println(utilidades.cargarAsciiArt("C:\\Users\\pablo\\Desktop\\ascii_art\\" + datosPokemon1.get("Imagen_ASCII")));
        System.out.println("-".repeat(22));
        System.out.println();

        System.out.println("POKÉMON 2: " + datosPokemon2.get("Nombre"));
        System.out.println(utilidades.cargarAsciiArt("C:\\Users\\pablo\\Desktop\\ascii_art\\" + datosPokemon2.get("Imagen_ASCII")));
        System.out.println("-".repeat(22));
        System.out.println();


        System.out.print("Apuesta por un pokemon (1 para " + datosPokemon1.get("Nombre") + ", 2 para " + datosPokemon2.get("Nombre") + "): ");
        int apuesta = scanner.nextInt();

        // 7. Calcular fuerza total [cite: 492]
        // Las estadísticas están en el HashMap como Strings, hay que pasarlas a int/double
        int fuerzaPokemon1 = Integer.parseInt(datosPokemon1.get("HP")) +
                Integer.parseInt(datosPokemon1.get("Ataque")) +
                Integer.parseInt(datosPokemon1.get("Defensa")) +
                Integer.parseInt(datosPokemon1.get("Ataque Esp")) +
                Integer.parseInt(datosPokemon1.get("Defensa Esp")) +
                Integer.parseInt(datosPokemon1.get("Velocidad"));

        int fuerzaPokemon2 = Integer.parseInt(datosPokemon2.get("HP")) +
                Integer.parseInt(datosPokemon2.get("Ataque")) +
                Integer.parseInt(datosPokemon2.get("Defensa")) +
                Integer.parseInt(datosPokemon2.get("Ataque Esp")) +
                Integer.parseInt(datosPokemon2.get("Defensa Esp")) +
                Integer.parseInt(datosPokemon2.get("Velocidad"));

        System.out.println();
        System.out.println("Calculando resultados...");
        System.out.println(datosPokemon1.get("Nombre") + ": " + fuerzaPokemon1 + " puntos de fuerza");
        System.out.println(datosPokemon2.get("Nombre") + ": " + fuerzaPokemon2 + " puntos de fuerza");

        int ganador = 0;
        if (fuerzaPokemon1 > fuerzaPokemon2) {
            System.out.println("🥳 ¡" + datosPokemon1.get("Nombre") + " ha ganado la batalla! 🥳");
            ganador = 1;
        } else if (fuerzaPokemon2 > fuerzaPokemon1) {
            System.out.println("🥳 ¡" + datosPokemon2.get("Nombre") + " ha ganado la batalla! 🥳");
            ganador = 2;
        } else {
            System.out.println("🏁 ¡Es un empate! 🏁");
        }


        if (apuesta == ganador)  {
            System.out.println("🎉 ¡Felicidades! Has ganado la batalla.");
        } else {
            System.out.println("😢 Lo siento, Has perdido la batalla.");
        }
    }
}