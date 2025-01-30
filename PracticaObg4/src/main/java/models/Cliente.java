package models;

public class Cliente {

    //Atributos
    private Persona persona;
    private String contrasena;
    private Pedido pedido1;
    private Pedido pedido2;

    //Contador estatico numero de clientes creados
    private static int contadorClientes = 0;

    //Constructor vacio
    public Cliente() {
        this.persona = null;
        this.contrasena = null;
        this.pedido1 = null;
        this.pedido2 = null;
    }

    //Constructor que declara una persona con los pedidos a null
    public Cliente(Persona persona, String contrasena) {
        this.persona = persona;
        this.contrasena = contrasena;
        this.pedido1 = null;
        this.pedido2 = null;
        contadorClientes++;
    }

    //Constructor que crea al cliente con 2 pedidos ya hechos
    public Cliente(Persona persona, String contrasena, Pedido pedido1, Pedido pedido2) {
        this.persona = persona;
        this.contrasena = contrasena;
        this.pedido1 = pedido1;
        this.pedido2 = pedido2;
        contadorClientes++;
    }

    // Constructor de copia
    public Cliente(Cliente cliente) {
        this.persona = new Persona(cliente.getPersona());
        this.contrasena = cliente.getContrasena();
        contadorClientes++; // Incrementar el contador de clientes
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

    public static int getContadorClientes() {
        return contadorClientes;
    }

    public static void setContadorClientes(int contadorClientes) {
        Cliente.contadorClientes = contadorClientes;
    }

    //Otros metodos


    //toString
    @Override
    public String toString() {
       /* return "┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓" + "\n" +
                "  ➤ Cliente: " + persona.getNombreCompleto() + "\n" +
                "  ➤ Email: " + persona.getEmail() + "\n" +
                "  ➤ Ciudad: " + persona.getCiudad() + "\n" +
                "  ➤ Provincia: " + persona.getProvincia() + "\n" +
                "  ➤ Dirección: " + persona.getDireccion() + "\n" +
                "  ➤ Teléfono: " + persona.getTelefono() + "\n" +
                "  ➤ Pedido 1: " + (pedido1 != null ? pedido1 : "Pedido no realizado") + "\n" +
                "  ➤ Pedido 2: " + (pedido2 != null ? pedido2 : "Pedido no realizado") + "\n" +
                "┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛";*/

        return "\n ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓\n" + "\t\t CLIENTE: " + persona.getNombreCompleto().toUpperCase() + "   \n" + " ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓\n" + "   ➤ Email:  \t\t" + persona.getEmail() + "\n" + "   ➤ Dirección:  \t" + persona.getDireccion() + "\n" + "   ➤ Ciudad:  \t\t" + persona.getCiudad() + "\n" + "   ➤ Provincia:  \t" + persona.getProvincia() + "\n" + "   ➤ Teléfono:  \t" + persona.getTelefono() + "\n" + "   ➤ Pedido 1:  \t" + (pedido1 != null ? "Pedido realizado" : "Pedido no realizado") + "\n" + "   ➤ Pedido 2:  \t" + (pedido2 != null ? "Pedido realizado" : "Pedido no realizado") + "\n" + " ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n";
    }
}
