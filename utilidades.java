package pokemonTCG;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class utilidades {

    public static ArrayList<HashMap<String,String>> cargarPokemonData(String ruta) {

        File file = new File("C:\\Users\\pablo\\Desktop\\TCGjava\\pokemon_data.txt");

        try {

            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            String linea;


            ArrayList<HashMap<String,String>> pokemonsArray = new ArrayList<>();

            while ((linea = br.readLine()) != null) {
                String[] datosSeparados = new String[15];
                datosSeparados = linea.split(",");

                HashMap<String, String> pokemons = new HashMap<>();

                pokemons.put("Numero Pokedex", datosSeparados[0]);
                pokemons.put("Nombre", datosSeparados[1]);
                pokemons.put("Tipo/s", datosSeparados[2]);
                pokemons.put("Habitat", datosSeparados[3]);
                pokemons.put("Altura", datosSeparados[4]);
                pokemons.put("Peso", datosSeparados[5]);
                pokemons.put("HP", datosSeparados[6]);
                pokemons.put("Ataque", datosSeparados[7]);
                pokemons.put("Defensa", datosSeparados[8]);
                pokemons.put("Ataque Esp", datosSeparados[9]);
                pokemons.put("Defensa Esp", datosSeparados[10]);
                pokemons.put("Velocidad", datosSeparados[11]);
                pokemons.put("Probabilidad", datosSeparados[12]);
                pokemons.put("Rareza", datosSeparados[13]);
                pokemons.put("Imagen_ASCII", datosSeparados[14]);

                pokemonsArray.add(pokemons);


            }

            return pokemonsArray;


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String cargarAsciiArt(String ruta) {

        File file = new File(ruta);

        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            String pokemon = "";
            String linea;
            while ((linea = br.readLine()) != null) {
                pokemon += linea;
                pokemon += "\n";
            }

            return  pokemon;


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}