package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int open = 1;
        int[][] hotel = new int[10][3];
        while (open == 1) {
            switch (Choose(new String[]{"Consultar habitaciones.","Reservar Habitacion.","Entregar boleta.","Reiniciar Hotel(Administrador)","Salir."})) {
                case 0:
                    consultarHabitaciones(hotel);
                    break;
                case 1:
                    hotel = reservarHabitacion(generarMatriz(),datoDesayuno(),datoHabitacion(),datoDias());
                    break;
                case 2:
                    boleta();
                    break;
                case 3:
                    resetHotel(hotel);
                    break;
                case 4:
                    open = new int[]{0,1}[Choose(new String[]{"No","Si"})];
                    break;
                default;
                    break;
            }
        }
    }
    public static int[][] generarMatriz() {
        int[][] matriz = new int[10][3];
        return matriz;
    }

    public static void consultarHabitaciones(int[][] matriz) {
        for (int[] habitacion:matriz) {
            System.out.print(new String[]{"\nVacante ","\nReservado ","\nOcupado "}[habitacion[1]]);
            if (habitacion[1] != 0) {
                System.out.print(new String[]{"$30.000 ", "$40.000 "}[habitacion[0]]);
                System.out.print(habitacion[2] + " Dias.");
            } else {System.out.print("$0");}
        }
        System.out.println("");
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
        return ingresarDias();
    }
    public static int[][] reservarHabitacion(int[][] matriz, int desayuno,int habitacion ,int dias) {
        matriz[habitacion-1][0] = 1;
        matriz[habitacion-1][1] = desayuno;
        matriz[habitacion-1][2] = dias;
        return matriz;
    }
    private static int ingresarDias() {
        System.out.println("Ingrese la cantidad de días a reservar: ");
        int dias=ingresarSoloNumero();
        while (dias < 1){
            System.out.println("Valor incorrecto. Volver a ingresar cantidad de dias.");
            dias = ingresarSoloNumero();
        }
        return dias;
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

    public static int Choose(String [] choices) {
        Scanner SCAN = new Scanner(System.in);
        if (choices.length==0){throw new RuntimeException("No empty Strings.");}
        int point = 1;
        for (String i:choices) {
            System.out.println(point+". "+i);
            point++;
        }
        int choice;
        do {
            choice = SCAN.nextInt() - 1;
        } while (choice < 0 | choice >= choices.length);
        return choice;
    }
}