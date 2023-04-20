package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        leerMatriz(rellenarMatriz(generarMatriz()));
    }
    public static int[][] generarMatriz() {
        int[][] matriz = new int[2][10];
        return matriz;
    }
    public static int[][] rellenarMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++){
                matriz[0][j] = (int)(Math.random() * 2);
            }
        }
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

}