package models;

public class Trabajador {
    //Atributos
    private String nombre;
    private String id;
    private Pedido pedido1;
    private Pedido pedido2;

    //Constructor
    public Trabajador(String nombre, String id, Pedido pedido1, Pedido pedido2) {
        this.nombre = nombre;
        this.id = id;
        this.pedido1 = pedido1;
        this.pedido2 = pedido2;
    }

    //Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Pedido getPedido1() {
        return pedido1;
    }

    public void setPedido1(Pedido pedido1) {
        this.pedido1 = pedido1;
    }

    public Pedido getPedido2() {
        return pedido2;
    }

    public void setPedido2(Pedido pedido2) {
        this.pedido2 = pedido2;
    }

    //Otros metodos
    public boolean asignarPedido(Pedido pedido) {
        if (pedido1 == null) {
            pedido1 = pedido;
            return true;
        }
        if (pedido2 == null) {
            pedido2 = pedido;
            return true;
        }
        return false;
    }

    //toString
    @Override
    public String toString() {
        return "Trabajador: " + nombre + "\n" +
                "ID: " + id + "\n" +
                "Pedido 1: " + (pedido1 != null ? pedido1.toString() : "No asignado") + "\n" +
                "Pedido 2: " + (pedido2 != null ? pedido2.toString() : "No asignado");
    }
}
