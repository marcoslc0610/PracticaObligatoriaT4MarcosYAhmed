package models;

public class Administrador {

    //Atributos
    private Persona persona;
    private String contrasena;
    private Pedido pedido1;
    private Pedido pedido2;
    private Pedido pedido3;
    private Pedido pedido4;
    private Trabajador trabajador1;
    private Trabajador trabajador2;
    private Trabajador trabajador3;


    //Constructores
    //Constructor a null
    public Administrador() {
        this.persona = null;
        this.contrasena = null;
        this.pedido1 = null;
        this.pedido2 = null;
        this.pedido3 = null;
        this.pedido4 = null;
        this.trabajador1 = null;
        this.trabajador2 = null;
        this.trabajador3 = null;
    }

    //Constructor con los pedidos y los trabajadores a null
    public Administrador(Persona persona, String contrasena) {
        this.persona = persona;
        this.contrasena = contrasena;
        this.pedido1 = null;
        this.pedido2 = null;
        this.pedido3 = null;
        this.pedido4 = null;
        this.trabajador1 = null;
        this.trabajador2 = null;
        this.trabajador3 = null;
    }

    //Contructor que declara todo
    public Administrador(Persona persona, String contrasena, Pedido pedido1, Pedido pedido2, Pedido pedido3, Pedido pedido4, Trabajador trabajador1, Trabajador trabajador2, Trabajador trabajador3) {
        this.persona = persona;
        this.contrasena = contrasena;
        this.pedido1 = pedido1;
        this.pedido2 = pedido2;
        this.pedido3 = pedido3;
        this.pedido4 = pedido4;
        this.trabajador1 = trabajador1;
        this.trabajador2 = trabajador2;
        this.trabajador3 = trabajador3;
    }

    //Getters y Setters
    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
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

    public Pedido getPedido3() {
        return pedido3;
    }

    public void setPedido3(Pedido pedido3) {
        this.pedido3 = pedido3;
    }

    public Pedido getPedido4() {
        return pedido4;
    }

    public void setPedido4(Pedido pedido4) {
        this.pedido4 = pedido4;
    }

    public Trabajador getTrabajador1() {
        return trabajador1;
    }

    public void setTrabajador1(Trabajador trabajador1) {
        this.trabajador1 = trabajador1;
    }

    public Trabajador getTrabajador2() {
        return trabajador2;
    }

    public void setTrabajador2(Trabajador trabajador2) {
        this.trabajador2 = trabajador2;
    }

    public Trabajador getTrabajador3() {
        return trabajador3;
    }

    public void setTrabajador3(Trabajador trabajador3) {
        this.trabajador3 = trabajador3;
    }

    //toString
    @Override
    public String toString() {
        return "┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓" + "\n" +
                "  ➤ Administrador: " + (persona != null ? persona.getNombreCompleto() : "Sin asignar") + "\n" +
                "  ➤ Contraseña: " + (contrasena != null ? "******" : "Sin asignar") + "\n" +
                "  ➤ Pedidos: " + "\n" +
                "     • Pedido 1: " + (pedido1 != null ? pedido1.toString() : "Sin asignar") + "\n" +
                "     • Pedido 2: " + (pedido2 != null ? pedido2.toString() : "Sin asignar") + "\n" +
                "     • Pedido 3: " + (pedido3 != null ? pedido3.toString() : "Sin asignar") + "\n" +
                "     • Pedido 4: " + (pedido4 != null ? pedido4.toString() : "Sin asignar") + "\n" +
                "  ➤ Trabajadores: " + "\n" +
                "     • Trabajador 1: " + (trabajador1 != null ? trabajador1.toString() : "Sin asignar") + "\n" +
                "     • Trabajador 2: " + (trabajador2 != null ? trabajador2.toString() : "Sin asignar") + "\n" +
                "     • Trabajador 3: " + (trabajador3 != null ? trabajador3.toString() : "Sin asignar") + "\n" +
                "┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛";
    }
}
