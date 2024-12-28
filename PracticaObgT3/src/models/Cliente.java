package models;

public class Cliente {

    //Atributos
    private String email;
    private String contrasena;
    private String nombre;
    private String direccion;
    private Pedido pedido1; //Primer pedido
    private Pedido pedido2; //Segundo pedido

    //Constructor
    public Cliente(String email, String contrasena, String nombre, String direccion, Pedido pedido1, Pedido pedido2) {
        this.email = email;
        this.contrasena = contrasena;
        this.nombre = nombre;
        this.direccion = direccion;
        this.pedido1 = pedido1;
        this.pedido2 = pedido2;
    }

    //Getters y Setters
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
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
    public boolean agregarPedido(Pedido pedido) {
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
        return "Cliente: " + nombre + "\n" +
                "Email: " + email + "\n" +
                "Dirección: " + direccion + "\n" +
                "Pedido 1: " + (pedido1 != null ? pedido1.toString() : "No asignado") + "\n" +
                "Pedido 2: " + (pedido2 != null ? pedido2.toString() : "No asignado");
    }
}
