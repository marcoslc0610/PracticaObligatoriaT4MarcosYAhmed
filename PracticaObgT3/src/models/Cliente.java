package models;

public class Cliente {

    //Atributos
    private Persona persona;
    private String contrasena;
    private Pedido pedido1 = null;
    private Pedido pedido2 = null;

    //Constructor
    public Cliente(Persona persona, String contrasena) {
        this.persona = persona;
        this.contrasena = contrasena;
    }

    // Constructor
    public Cliente() {
        this.pedido1 = new Pedido();
        this.pedido2 = new Pedido();
    }

    public Cliente(Persona persona, String contrasena, Pedido pedido1, Pedido pedido2) {
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

    //toString
    @Override
    public String toString() {
        return "┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓" + "\n" +
                "  ➤ Cliente: " + persona.getNombre() + "\n" +
                "  ➤ Email: " + persona.getEmail() + "\n" +
                "  ➤ Localidad: " + persona.getLocalidad() + "\n" +
                "  ➤ Dirección: " + persona.getDireccion() + "\n" +
                "  ➤ Teléfono: " + persona.getTelefono() + "\n" +
                "  ➤ Pedido 1: " + (getPedido1() != null ? pedido1.pintaPedido() : "Pedido no realizado") + "\n" +
                "  ➤ Pedido 2: " + (getPedido2() != null ? pedido2.pintaPedido() : "Pedido no realizado") + "\n" +
                "┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛";
    }
}
