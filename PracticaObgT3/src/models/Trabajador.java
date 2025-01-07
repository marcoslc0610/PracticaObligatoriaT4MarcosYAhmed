package models;

import utils.PantallasDeCarga;

import java.util.Scanner;

public class Trabajador {
    private Persona persona;
    private String contrasena;
    private Pedido pedido1;
    private Pedido pedido2;
    private int pedidosAsignados;

    //Constructor
    public Trabajador(Persona persona, String contrasena, Pedido pedido1, Pedido pedido2, int pedidosAsignados) {
        this.persona = persona;
        this.contrasena = contrasena;
        this.pedido1 = pedido1;
        this.pedido2 = pedido2;
        this.pedidosAsignados = pedidosAsignados;
    }

    public Trabajador() {
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

    public int getPedidosAsignados() {
        return pedidosAsignados;
    }

    public void setPedidosAsignados(int pedidosAsignados) {
        this.pedidosAsignados = pedidosAsignados;
    }

    //Otros metodos
    public void modificaTrabajador(String op) {
        Scanner s = new Scanner(System.in);
        if (op.equals("1") || op.equals("2")) {
            System.out.print("Introduzca el nombre: ");
            persona.setNombre(s.nextLine());
        }
        if (op.equals("1") || op.equals("3")) {
            System.out.print("Introduzca el email: ");
            persona.setEmail(s.nextLine());
        }
        if (op.equals("1") || op.equals("4")) {
            System.out.print("Introduzca el teléfono: ");
            persona.setTelefono(Integer.parseInt(s.nextLine()));
        }
        if (op.equals("1") || op.equals("5")) {
            System.out.print("Introduzca la localidad: ");
            persona.setLocalidad(s.nextLine());
        }
        if (op.equals("1") || op.equals("6")) {
            System.out.print("Introduzca la dirección: ");
            persona.setDireccion(s.nextLine());
        }
        if (op.equals("1") || op.equals("7")) {
            System.out.print("Introduzca la contraseña: ");
            setContrasena(s.nextLine());
        }
        if (op.equals("1") || op.equals("8")) {
            PantallasDeCarga.saliendo();
        }
    }

    //toString
    @Override
    public String toString() {
        return "\n" +
                "Trabajador: " + persona.getNombre() + "\n" +
                "Email: " + persona.getEmail() + "\n" +
                "Localidad: " + persona.getLocalidad() + "\n" +
                "Dirección: " + persona.getDireccion() + "\n" +
                "Teléfono: " + persona.getTelefono() + "\n" +
                "Pedido 1: " + (pedido1 != null ? pedido1.toString() : "No asignado") + "\n" +
                "Pedido 2: " + (pedido2 != null ? pedido2.toString() : "No asignado") + "\n" +
                "Pedidos asignados: " + pedidosAsignados + "\n";
    }

    public int getPedidosAGestionar() {

        return pedidosAsignados;
    }
}
