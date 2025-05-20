/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestorActividades;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Raúl Buenaga
 */
public class Utilidad {
    
    public static String nextString(String texto) {
        System.out.println(texto);
        return new Scanner(System.in).nextLine();
    }

    public static int nextInt(String texto) {
        boolean salir = false;
        int temp = 0;
        do {
            try {
                System.out.println(texto);
                temp = new Scanner(System.in).nextInt();
                salir = true;
            } catch (InputMismatchException a) {
                System.out.println("Error: no se ha introducido un entero");
            }

        } while (!salir);
        return temp;
    }

    public static double nextDouble(String texto) {
        boolean salir = false;
        double temp = 0;
        do {
            try {
                System.out.println(texto);
                temp = new Scanner(System.in).nextDouble();
                salir = true;
            } catch (InputMismatchException a) {
                System.out.println("Error: no se ha introducido un numero");
            }
        } while (!salir);

        return temp;
    }
    
    public static boolean nextBoolean(String cadena) {
        boolean temp = false;
        boolean salir = false;
        Scanner teclado = new Scanner(System.in);
        String x;
        do {
            try {
                System.out.println(cadena + " (Si/No)");
                System.out.println();
                x = teclado.nextLine();
                if (x.equalsIgnoreCase("Si") || x.equalsIgnoreCase("S")) {
                    temp = true;
                    salir = true;
                } else if (x.equalsIgnoreCase("No") || x.equalsIgnoreCase("N")) {
                    temp = false;
                    salir = true;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Error: respuesta no valida");
            }
        } while (!salir);
        return temp;
    }
    

    public static LocalDate fecha(String texto) {
        System.out.print(texto);
        int dia = nextInt("Introduce el dia: ");
        int mes = nextInt("Introduce el mes: ");
        int anio = nextInt("Introduce el año: ");
        LocalDate temp = LocalDate.now();
        try {
            temp = LocalDate.of(dia, mes, anio);
        } catch (DateTimeException a) {
            System.out.println("Error: Los datos no son validos para el formato de fecha");
        }
        return temp;
    }
    
    public static String email() {
        String temp = "";
        boolean salir = false;
        do {
            temp = Utilidad.nextString("Email: ");
            if (temp.contains("@")) {
                salir = true;
            } else {
                System.out.println("Email no valido, vuelva a intentarlo.");
            }
        } while (!salir);

        return temp;
    }
}
