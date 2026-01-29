package pokemonTCG;

import java.util.Scanner;

public class main {

    public static void iniciarJuego(){

        Scanner scanner = new Scanner(System.in);
        int acabarJuego = 0;
        estadoJugador.inicializarEstado();

        while (acabarJuego != 5) {

            System.out.printf("%s%n%25s%n%s%n", "=".repeat(29), "POKEMON TERMINAL GAME", "=".repeat(29));
            System.out.println("1. Conseguir sobre");
            System.out.println("2. Abrir sobre");
            System.out.println("3. Listar cartas");
            System.out.println("4. Luchar");
            System.out.println("5. Salir");
            System.out.println("=".repeat(29));
            System.out.println("Elige una opción (1-5): ");
            int opcion = scanner.nextInt();
            acabarJuego = opcion;

            switch (opcion) {

                case 1:
                    gestionSobres.contarEnterParaSobre();
                    estadoJugador.guardarEstado();
                    break;

                case 2:
                    gestionSobres.abrirSobre();
                    estadoJugador.guardarEstado();
                    break;

                case 3:
                    gestionCartas.listarCartas();
                    break;

                case 4:
                    lucha.luchar();
                    break;

                case 5:
                    return;


            }
        }
    }

    static void main(String[] args) {
        iniciarJuego();
    }
    }