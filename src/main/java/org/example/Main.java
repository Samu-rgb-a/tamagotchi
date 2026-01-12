package org.example;

import java.util.Scanner;
public class Main {

    private static int saciedad = 6;
    private static int energia = 6;
    private static int diversion = 6;

    private static Scanner sc = new Scanner(System.in);

    private static int menuPrincipal() {
        int opcion;
        do {
            System.out.println("\n1. Estado");
            System.out.println("2. Comer");
            System.out.println("3. Jugar");
            System.out.println("4. Dormir");
            System.out.println("----------------");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción del menú: ");

            opcion = sc.nextInt();

            if (opcion < 0 || opcion > 4) {
                System.out.println("Opción no válida. Inténtelo de nuevo.");
            }
        } while (opcion < 0 || opcion > 4);

        return opcion;
    }

    private static void mostrarEstado() {
        if (saciedad == 0 || energia == 0 || diversion == 0) {
            System.out.println("Fin del juego");
        } else if (saciedad <= 4) {
            System.out.println("Hambriento (Saciedad: " + saciedad + ")");
        } else if (energia <= 4) {
            System.out.println("Cansado (Energía: " + energia + ")");
        } else if (diversion <= 4) {
            System.out.println("Triste (Diversión: " + diversion + ")");
        } else if (saciedad > 5 && energia > 5 && diversion > 5) {
            System.out.println("Contento (S:" + saciedad + " E:" + energia + " D:" + diversion + ")");
        } else {
            System.out.println("Estado normal (S:" + saciedad + " E:" + energia + " D:" + diversion + ")");
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
                    mostrarEstado();
                    break;

                case 2:
                    saciedad = Math.min(saciedad + 2, 10);
                    energia = Math.max(energia - 1, 0);
                    diversion = Math.max(diversion - 1, 0);
                    mostrarEstado();
                    break;

                case 3:
                    diversion = Math.min(diversion + 2, 10);
                    energia = Math.max(energia - 2, 0);
                    saciedad = Math.max(saciedad - 1, 0);
                    mostrarEstado();
                    break;

                case 4:
                    energia = Math.min(energia + 3, 10);
                    saciedad = Math.max(saciedad - 2, 0);
                    mostrarEstado();
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
