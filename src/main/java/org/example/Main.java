package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        leerMatriz(rellenarMatriz(generarMatriz()));
    }
    public static int[][] generarMatriz() {
        int[][] matriz = new int[10][2];
        return matriz;
    }
    public static int[][] rellenarMatriz(int[][] matriz) {
        matriz[ingresarHabitacion()-1][ingresarDesayuno()] = 2;
        return matriz;
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