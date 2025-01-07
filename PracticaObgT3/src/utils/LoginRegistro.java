package utils;

import models.Cliente;
import models.Persona;
import models.Trabajador;

import java.util.Scanner;

public class LoginRegistro {
    static Scanner s = new Scanner(System.in);

    private Cliente cliente1 = null;
    private Cliente cliente2 = null;
    private Trabajador trabajador1 = null;
    private Trabajador trabajador2 = null;
    private Trabajador trabajador3 = null;

    public LoginRegistro(Cliente cliente1, Cliente cliente2, Trabajador trabajador1, Trabajador trabajador2, Trabajador trabajador3) {
        this.cliente1 = cliente1;
        this.cliente2 = cliente2;
        this.trabajador1 = trabajador1;
        this.trabajador2 = trabajador2;
        this.trabajador3 = trabajador3;
    }

    public boolean existeEmail(String email) {
        if (cliente1 != null && cliente1.getPersona().getEmail().equals(email)) {
            return true;
        }
        if (cliente2 != null && cliente2.getPersona().getEmail().equals(email)) {
            return true;
        }
        if (trabajador1 != null && trabajador1.getPersona().getEmail().equals(email)) {
            return true;
        }
        if (trabajador2 != null && trabajador2.getPersona().getEmail().equals(email)) {
            return true;
        }
        if (trabajador3 != null && trabajador3.getPersona().getEmail().equals(email)) {
            return true;
        }
        return false;
    }

    public Persona login() {
        System.out.print("Introduzca email: ");
        String emailIntro = s.nextLine();
        emailIntro = emailIntro.toLowerCase();
        System.out.print("Introduzca contraseña: ");
        String contrasenaIntro = s.nextLine();


        if (cliente1 != null && emailIntro.equals(cliente1.getPersona().getEmail()) && contrasenaIntro.equals(cliente1.getContrasena()))
            return cliente1.getPersona();
        if (cliente2 != null && emailIntro.equals(cliente2.getPersona().getEmail()) && contrasenaIntro.equals(cliente2.getContrasena()))
            return cliente2.getPersona();
        if (trabajador1 != null && emailIntro.equals(trabajador1.getPersona().getEmail()) && contrasenaIntro.equals(trabajador1.getContrasena()))
            return trabajador1.getPersona();
        if (trabajador2 != null && emailIntro.equals(trabajador2.getPersona().getEmail()) && contrasenaIntro.equals(trabajador2.getContrasena()))
            return trabajador2.getPersona();
        if (trabajador3 != null && emailIntro.equals(trabajador3.getPersona().getEmail()) && contrasenaIntro.equals(trabajador3.getContrasena()))
            return trabajador3.getPersona();

        return null;

    }

    public Cliente registroCliente() {

        Cliente nuevoCliente = new Cliente();
        Persona nuevaPersona = new Persona();

        System.out.print("Introduzca nombre completo: ");
        nuevaPersona.setNombre(s.nextLine());
        System.out.print("Introduzca telefono: ");
        nuevaPersona.setTelefono(Integer.parseInt(s.nextLine()));
        System.out.print("Introduzca localidad: ");
        nuevaPersona.setLocalidad(s.nextLine());
        System.out.print("Introduzca direccion: ");
        nuevaPersona.setDireccion(s.nextLine());
        do {
            System.out.print("Introduzca email: ");
            nuevaPersona.setEmail(s.nextLine());
            if (existeEmail(nuevaPersona.getEmail()))
                System.out.println("Email ya registrado prueba con otro...");
        } while (existeEmail(nuevaPersona.getEmail()));
        System.out.print("Introduzca contrasena: ");
        nuevoCliente.setContrasena(s.nextLine());

        nuevoCliente.setPersona(nuevaPersona);
        nuevoCliente.getPersona().setTipo("Cliente");
        if (cliente1 == null) {
            cliente1 = new Cliente();
            cliente1.setPersona(nuevoCliente.getPersona());
            cliente1.setContrasena(nuevoCliente.getContrasena());
            cliente1.setPedido1(null);
            cliente1.setPedido2(null);
            return nuevoCliente;
        }
        if (cliente2 == null) {
            cliente2 = new Cliente();
            cliente2.setPersona(nuevoCliente.getPersona());
            cliente2.setContrasena(nuevoCliente.getContrasena());
            cliente2.setPedido1(null);
            cliente2.setPedido2(null);
            return nuevoCliente;
        }
        return null;
    }
}
