package pokemonTCG;

import java.io.*;
import java.util.HashMap;

public class estadoJugador {

    public static HashMap<String, Integer> estadoJugador = new HashMap<>();

    public static void inicializarEstado() {

        File file = new File("C:\\Users\\pablo\\Desktop\\TCGjava\\jugador_data.txt");
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            String linea;
            while ((linea = br.readLine()) != null) {

                linea = linea.replace("{","").replace("}","");

                String[] division = linea.split(",");

                for (String datos : division) {

                    String[] datosJugador = datos.split("=");

                    String nombre = datosJugador[0].trim();
                    Integer cantidad = Integer.parseInt(datosJugador[1].trim());

                    estadoJugador.put(nombre, cantidad);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void guardarEstado() {

        File file = new File("C:\\Users\\pablo\\Desktop\\TCGjava\\jugador_data.txt");
        try {
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write(estadoJugador.toString());
            bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
