package pokemonTCG;

import java.util.*;

public class gestionSobres {


    public static void contarEnterParaSobre() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Pulsa ENTER 10 veces para conseguir un sobre o `q` para volver");

        String enter = "";
        String salir = "q";
        int contador = 0;



        while (true) {

            String valorUsuario = scanner.nextLine();
            String respuestaUsuario = scanner.nextLine().toLowerCase();

            if (valorUsuario.toLowerCase().equals(salir)) {
                break;
            }

            if (valorUsuario.equals(enter)) {
                contador++;
                System.out.println("Progreso: " + contador + "/100");
            }

            if (contador == 10) {
                estadoJugador.estadoJugador.put("sobres", estadoJugador.estadoJugador.get("sobres") + 1);

                System.out.println("¡Has conseguido un sobre! 🥳");
                return;
            }
        }
    }

    public static void abrirSobre() {

        if (estadoJugador.estadoJugador.get("sobres") < 1) {

            System.out.println("No tienes sobres, te toca farmear unos cuantos 😁");
            return;
        } else {

            estadoJugador.estadoJugador.put("sobres", estadoJugador.estadoJugador.get("sobres") - 1);

            HashMap<String, String> pokemon1 = seleccionarCartaAleatoria();
            System.out.println(utilidades.cargarAsciiArt("C:\\Users\\pablo\\Desktop\\ascii_art\\" + pokemon1.get("Imagen_ASCII")));
            System.out.println(pokemon1.get("Nombre"));
            System.out.println(pokemon1.get("Rareza"));
            estadoJugador.estadoJugador.put(pokemon1.get("Nombre"), estadoJugador.estadoJugador.get(pokemon1.get("Nombre")) + 1);

            HashMap<String, String> pokemon2 = seleccionarCartaAleatoria();
            System.out.println(utilidades.cargarAsciiArt("C:\\Users\\pablo\\Desktop\\ascii_art\\" + pokemon2.get("Imagen_ASCII")));
            System.out.println(pokemon2.get("Nombre"));
            System.out.println(pokemon2.get("Rareza"));
            estadoJugador.estadoJugador.put(pokemon2.get("Nombre"), estadoJugador.estadoJugador.get(pokemon2.get("Nombre")) + 1);

            HashMap<String, String> pokemon3 = seleccionarCartaAleatoria();
            System.out.println(utilidades.cargarAsciiArt("C:\\Users\\pablo\\Desktop\\ascii_art\\" + pokemon3.get("Imagen_ASCII")));
            System.out.println(pokemon3.get("Nombre"));
            System.out.println(pokemon3.get("Rareza"));
            estadoJugador.estadoJugador.put(pokemon3.get("Nombre"), estadoJugador.estadoJugador.get(pokemon3.get("Nombre")) + 1);

            HashMap<String, String> pokemon4 = seleccionarCartaAleatoria();
            System.out.println(utilidades.cargarAsciiArt("C:\\Users\\pablo\\Desktop\\ascii_art\\" + pokemon4.get("Imagen_ASCII")));
            System.out.println(pokemon4.get("Nombre"));
            System.out.println(pokemon4.get("Rareza"));
            estadoJugador.estadoJugador.put(pokemon4.get("Nombre"), estadoJugador.estadoJugador.get(pokemon4.get("Nombre")) + 1);

            HashMap<String, String> pokemon5 = seleccionarCartaAleatoria();
            System.out.println(utilidades.cargarAsciiArt("C:\\Users\\pablo\\Desktop\\ascii_art\\" + pokemon5.get("Imagen_ASCII")));
            System.out.println(pokemon5.get("Nombre"));
            System.out.println(pokemon5.get("Rareza"));
            estadoJugador.estadoJugador.put(pokemon5.get("Nombre"), estadoJugador.estadoJugador.get(pokemon5.get("Nombre")) + 1);
        }

    }

    public static HashMap<String, String> seleccionarCartaAleatoria() {
        Random random = new Random();

        Double probabilidadRandom = random.nextDouble(1);
        Double sumaProbabilidades = 0.0;

        ArrayList<HashMap<String, String>> pokemonsData = utilidades.cargarPokemonData("C:\\Users\\pablo\\Desktop\\TCGjava\\pokemon_data.txt");

        HashMap<String, String> cartaSeleccionada = new HashMap<>();

        for (HashMap<String, String> pokemon : pokemonsData) {

            String probabilidad = pokemon.get("Probabilidad");

            sumaProbabilidades += Double.parseDouble(probabilidad);

            if (sumaProbabilidades >= probabilidadRandom) {

                cartaSeleccionada = pokemon;
                break;
            }
        }
        return cartaSeleccionada;
    }
}
