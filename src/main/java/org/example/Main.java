package org.example;

import java.util.Scanner;

public class Main {

    // Variables globales del Tamagotchi
    private static int saciedad = 6;
    private static int energia = 6;
    private static int diversion = 6;

    private static Scanner sc = new Scanner(System.in);

    // Menú principal con validación
    private static int menuPrincipal() {
        int opcion;
        do {
            System.out.println("\n==========================");
            System.out.println("1. Estado");
            System.out.println("2. Comer");
            System.out.println("3. Jugar");
            System.out.println("4. Dormir");
            System.out.println("----------------");
            System.out.println("0. Salir");
            System.out.println("==========================");
            System.out.print("Seleccione una opción del menú: ");

            if (sc.hasNextInt()) {
                opcion = sc.nextInt();
            } else {
                System.out.println("Opción no válida. Inténtelo de nuevo.");
                sc.next(); // descarta entrada inválida
                opcion = -1; // fuerza repetir bucle
            }

            if (opcion < 0 || opcion > 4) {
                System.out.println("Opción no válida. Inténtelo de nuevo.");
            }
        } while (opcion < 0 || opcion > 4);

        return opcion;
    }

    // Muestra el estado del Tamagotchi
    private static void mostrarEstado() {
        if (saciedad == 0 || energia == 0 || diversion == 0) {
            System.out.println("💀 Fin del juego");
        } else if (saciedad <= 4) {
            System.out.println("😫 Hambriento (Saciedad: " + saciedad + ")");
        } else if (energia <= 4) {
            System.out.println("😴 Cansado (Energía: " + energia + ")");
        } else if (diversion <= 4) {
            System.out.println("😢 Triste (Diversión: " + diversion + ")");
        } else if (saciedad > 5 && energia > 5 && diversion > 5) {
            System.out.println("😃 Contento (S:" + saciedad + " E:" + energia + " D:" + diversion + ")");
        } else {
            System.out.println("🙂 Estado normal (S:" + saciedad + " E:" + energia + " D:" + diversion + ")");
        }
    }

    // Opción 1: Estado
    private static void opcionEstado() {
        mostrarEstado();
    }

    // Opción 2: Comer
    private static void opcionComer() {
        if (saciedad < 10) {
            saciedad = Math.min(saciedad + 5, 10); // aumenta hasta 5 puntos, máximo 10
            diversion = Math.max(diversion - 1, 0); // disminuye diversión en 1
            mostrarEstado();
        } else {
            System.out.println("No tengo hambre");
        }
    }

    // Opción 3: Jugar
    private static void opcionJugar() {
        if (energia > 1) { // solo puede jugar si tiene energía suficiente
            diversion = Math.min(diversion + 2, 10);
            energia = Math.max(energia - 2, 0);
            saciedad = Math.max(saciedad - 1, 0);
            mostrarEstado();
        } else {
            System.out.println("Estoy demasiado cansado para jugar");
        }
    }

    // Opción 4: Dormir
    private static void opcionDormir() {
        energia = Math.min(energia + 3, 10);
        saciedad = Math.max(saciedad - 2, 0);
        mostrarEstado();
    }

    public static void main(String[] args) {
        int opcion;

        System.out.println("🐾 ¡Bienvenido a tu Tamagotchi!");
        mostrarEstado(); // Estado inicial

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
                case 0:
                    System.out.println("¡Adiós!");
                    break;
            }

            // Fin del juego
            if (saciedad == 0 || energia == 0 || diversion == 0) {
                System.out.println("💀 Tu Tamagotchi ha terminado el juego.");
                break;
            }

        } while (opcion != 0);
    }
}

