package utils;

import java.util.Scanner;

public class PantallasDeCarga {
    public static void cargando() {
        System.out.print("\nCargando");
        for (int i = 0; i < 3; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.print(".");
        }
    }

    public static void saliendo() {
        System.out.print("\nSaliendo");
        for (int i = 0; i < 3; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.print(".");
        }
    }

    public static void pulsaParaContinuar() {
        Scanner s = new Scanner(System.in);
        System.out.print("\nPulsa enter para continuar: ");
        s.nextLine();
    }
}
