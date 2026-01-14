package org.example;

import java.util.Scanner;

public class Main {

    private static int saciedad = 6;
    private static int energia = 6;
    private static int diversion = 6;

    private static Scanner sc = new Scanner(System.in);

    private static int menuPrincipal() {
        int opcion = -1;
        do {
            System.out.println("\n==========================");
            System.out.println("1. Estado");
            System.out.println("2. Comer");
            System.out.println("3. Jugar");
            System.out.println("4. Dormir");
            System.out.println("5. Lavarse");
            System.out.println("----------------");
            System.out.println("0. Salir");
            System.out.println("==========================");
            System.out.print("Seleccione una opción del menú: ");

            String linea = sc.nextLine();
            try {
                opcion = Integer.parseInt(linea);
            } catch (NumberFormatException e) {
                System.out.println("Opción no válida. Inténtelo de nuevo.");
                opcion = -1;
            }

            if (opcion < 0 || opcion > 5) {
                System.out.println("Opción no válida. Inténtelo de nuevo.");
            }

        } while (opcion < 0 || opcion > 5);

        return opcion;
    }

    private static void mostrarEstado() {
        if (saciedad == 0 || energia == 0 || diversion == 0) {
            System.out.println("Fin del juego");
            System.out.println("(x_x) :( Game Over ):\n" +
                    "/|_|\\\n" +
                    " | |");
        } else if (saciedad <= 4) {
            System.out.println("Hambriento (Saciedad: " + saciedad + ")");
            System.out.println("(•︵•) ¡ Tengo hambre! \uD83C\uDF57\n" +
                    "/|x|\\\n" +
                    " | | ");
        } else if (energia <= 4) {
            System.out.println("Cansado (Energía: " + energia + ")");
            System.out.println("(-_-) Zzz\n" +
                    "/|_|\\\n" +
                    " | |");
        } else if (diversion <= 4) {
            System.out.println("Triste (Diversión: " + diversion + ")");
            System.out.println("(-︵-) Estoy aburrido\n" +
                    "/|_|\\ ¡Juega conmigo!\n" +
                    " / \\");
        } else if (saciedad > 5 && energia > 5 && diversion > 5) {
            System.out.println("Contento (S:" + saciedad + " E:" + energia + " D:" + diversion + ")");
            System.out.println("(•‿•) ¡Estoy feliz!\n" +
                    "/|_|\\\n" +
                    " | |");
        } else {
            System.out.println("Estado normal (S:" + saciedad + " E:" + energia + " D:" + diversion + ")");
        }
    }

    private static void opcionEstado() {
        mostrarEstado();
    }

    private static void opcionComer() {
        if (saciedad < 10) {
            saciedad = Math.min(saciedad + 4, 10);
            diversion = Math.max(diversion - 2, 0);
            mostrarEstado();
        } else {
            System.out.println("No tengo hambre");
        }
    }

    private static void opcionLavarse() {
        if (energia < 10) {
            diversion = Math.min(diversion + 2, 10);
            energia = Math.min(energia + 1, 10);
            saciedad = Math.max(saciedad - 1, 0);
            mostrarEstado();
        } else {
            System.out.println("No me apetece bañarme ahora");
        }
    }

    private static void opcionJugar() {
        if (diversion < 10) {
            diversion = Math.min(diversion + 5, 10);
            saciedad = Math.max(saciedad - 2, 0);
            energia = Math.max(energia - 3, 0);
            mostrarEstado();
        } else {
            System.out.println("Ahora no me apetece jugar");
        }
    }

    private static void opcionDormir() {
        if (energia < 10) {
            energia = Math.min(energia + 6, 10);
            saciedad = Math.max(saciedad - 4, 0);
            diversion = Math.max(diversion - 3, 0);
            mostrarEstado();
        } else {
            System.out.println("No tengo sueño");
        }
    }

    public static void main(String[] args) {
        int opcion;

        System.out.println("¡Bienvenido a tu Tamagotchi!");
        mostrarEstado();

        do {
            opcion = menuPrincipal();

            switch (opcion) {
                case 1:
                    opcionEstado();
                    break;
                case 2:
                    opcionComer();
                    break;
                case 3:
                    opcionJugar();
                    break;
                case 4:
                    opcionDormir();
                    break;
                case 5:
                    opcionLavarse();
                    break;
                case 0:
                    System.out.println("¡Adiós!");
                    break;
            }

            if (saciedad == 0 || energia == 0 || diversion == 0) {
                System.out.println("Tu Tamagotchi ha terminado el juego.");
                break;
            }

        } while (opcion != 0);
    }
}

