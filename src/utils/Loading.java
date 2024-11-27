package utils;

public class Loading {
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
}
