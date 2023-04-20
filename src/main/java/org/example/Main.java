package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        rellenarMatriz(generarMatriz(),datoDesayuno(),datoHabitacion(),datoDias());
    }
    public static int[][] generarMatriz() {
        int[][] matriz = new int[10][3];
        return matriz;
    }
    public static int datoDesayuno() {
        int desayuno = ingresarDesayuno();
        return desayuno;
    }
    public static int datoHabitacion() {
        int habitacion = ingresarHabitacion();
        return habitacion;
    }
    public static int datoDias() {
        int dias = ingresarDias();
        return dias;
    }
    public static int[][] rellenarMatriz(int[][] matriz, int desayuno,int habitacion ,int dias) {

        matriz[habitacion-1][0] = 2;
        matriz[habitacion-1][1] = desayuno;
        matriz[habitacion-1][2] = dias;
        return matriz;
    }

    private static int ingresarDias() {
        System.out.println("Ingrese la cantidad de días a reservar: ");
        int dias=ingresarSoloNumero();
        return dias;
    }

    public static void leerMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                    System.out.print(matriz[i][j]);
                    System.out.print(" ");
            }
            System.out.println(" ");
        }
    }
    public static int ingresarHabitacion() {
        System.out.println("Ingrese el número de la habitación a reservar: ");
        int habitacion=ingresarSoloNumero();
        while (!validarRangoNumero(habitacion,0,10)) {
            System.out.println("valor ingresado no valido, ingrese nuevamente");
            habitacion = ingresarSoloNumero();
        }
        return habitacion;
    }
    public static int ingresarDesayuno() {
        System.out.println("Desea desayuno?");
        int desayuno=ingresarSoloNumero();
        while (!validarRangoNumero(desayuno,0,1)) {
            System.out.println("valor ingresado no valido, ingrese nuevamente");
            desayuno = ingresarSoloNumero();
        }
        return desayuno;
    }
    public static void resetHotel(int[][] matriz) {
        System.out.println("Desea resetear?");
        int clave=ingresarSoloNumero();
        while (clave != 1234) {
            System.out.println("Clave incorrecta");
            clave = ingresarSoloNumero();
        }
        if (clave == 1234) {
            for (int i = 0; i < matriz.length; i++) {
                for (int j = 0; j < matriz[i].length; j++) {
                    matriz[i][j] = 0;
                }
            }
        }
    }
    public static boolean validarRangoNumero(int numero, int min, int max) {
        if (numero < min || numero > max) {
            return false;
        }
        return true;
    }

    public static int ingresarSoloNumero() {
        Scanner in = new Scanner(System.in);
        while (!in.hasNextInt()) {
            System.out.println("Entrada no válida. Ingrese un número entero:");
            in.next();
        }
        int numero = in.nextInt();
        return numero;
    }
}