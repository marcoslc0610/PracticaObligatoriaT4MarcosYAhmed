package models;

public class Trabajador {

    //Atributos
    private Persona persona;
    private String contrasena;
    private Pedido pedido1;
    private Pedido pedido2;


    //Constructor vacío
    public Trabajador() {
        this.persona = null;
        this.pedido1 = null;
        this.pedido2 = null;
    }

    //Constructor que declara el trabajador pero sin pedidos a gestionar
    public Trabajador(Persona persona, String contrasena) {
        this.persona = persona;
        this.contrasena = contrasena;
        this.pedido1 = null;
        this.pedido2 = null;
    }

    //Constructor con 2 pedidos a gestionar
    public Trabajador(Persona persona, String contrasena, Pedido pedido1, Pedido pedido2) {
        this.persona = persona;
        this.contrasena = contrasena;
        this.pedido1 = pedido1;
        this.pedido2 = pedido2;
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

    //Otros metodos

    //toString
    // @Override
    public String toString() {
        return "\n" +
                "┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓" + "\n" +
                "   ⟶ Trabajador: " + persona.getNombreCompleto() + "\n" +
                "   ⟶ Email: " + persona.getEmail() + "\n" +
                "   ⟶ Localidad: " + persona.getCiudad() + "\n" +
                "   ⟶ Provincia: " + persona.getProvincia() + "\n" +
                "   ⟶ Dirección: " + persona.getDireccion() + "\n" +
                "   ⟶ Teléfono: " + persona.getTelefono() + "\n" +
                "   ⟶ Pedido 1: " + (pedido1 != null ? pedido1.toString() : "No asignado") + "\n" +
                "   ⟶ Pedido 2: " + (pedido2 != null ? pedido2.toString() : "No asignado") + "\n" +
                "┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛";
    }
}
