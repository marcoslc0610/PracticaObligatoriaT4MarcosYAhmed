package views;

import utils.LimpiaPantalla;
import utils.Loading;
import utils.Logotipo;

public class Main {
    public static void main(String[] args) {
        Logotipo.pintaLogotipo();
        LimpiaPantalla.limpiar();
        Loading.cargando();
    }
}
