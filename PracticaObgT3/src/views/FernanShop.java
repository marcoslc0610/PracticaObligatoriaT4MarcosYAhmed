package views;

import models.*;
import utils.*;

import java.util.Scanner;

public class FernanShop {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        //Mock

        //Personas que son trabajadores
        Persona persona1 = new Persona("Ahmed Lhaouchi Briki", "ahmed@gmail.com", 678956782, "Jaen", "Calle Federico Garcia Lorca", "trabajador");
        Persona persona2 = new Persona("Marcos Lara Cano", "marcos@gmail.com", 612946726, "Martos", "Calle Via Lactea", "trabajador");
        Persona persona3 = new Persona("Juan Lopez Garcia", "juan@gmail.com", 768392671, "Torredonjimeno", "Calle Ramon y Cajal", "trabajador");
        //Trabajadores
        Trabajador trabajador1 = new Trabajador(persona1, "1234", null, null, 0);
        Trabajador trabajador2 = new Trabajador(persona2, "4321", null, null, 0);
        Trabajador trabajador3 = new Trabajador(persona3, "9876", null, null, 0);

        //Administrador
        Administrador administrador = new Administrador();

        //Clientes
        Persona persona4 = new Persona("Maria Fernandez Zafra", "maria@gmail.com", 692538462, "Andújar", "Calle Paseo de la Castellana", "cliente");
        //Persona persona5 = new Persona();
        Cliente cliente1 = new Cliente(persona4, "6789");
        Cliente cliente2 = null;

        //Metodo para el login y el registro
        LoginRegistro loginRegistro = new LoginRegistro(cliente1, cliente2, trabajador1, trabajador2, trabajador3);

        //Productos
        //Libros
        Producto libro1 = new Producto("El niño con el pijama de rayas", "Novela", 12.50, 10, "John Boyne", "Salamandra", "Ficción", "Español");
        Producto libro2 = new Producto("Cien años de soledad", "Novela", 20, 30, "Gabriel García Márquez", "Sudamericana", "Ficción", "Español");
        Producto libro3 = new Producto("La chica del tren", "Misterio / Suspense", 15, 5, "Paula Hawkins", "Planeta", "Misterio", "Español");
        Producto libro4 = new Producto("Las aventuras de Tom Sawyer", "Aventura", 10, 30, "Mark Twain", "Vicens Vives", "Aventura", "Español");

        //Papelería
        Producto articulo1 = new Producto("Pilot Frixion", "Bolígrafo", 2.50, 150, "Pilot", 1, "Azul");
        Producto articulo2 = new Producto("Juego de reglas", "Herramientas de medición", 8, 200, "Maped", 3, "Transparente");
        Producto articulo3 = new Producto("Lápiz HB", "Lápiz", 0.80, 300, "BIC", 1, "Negro");
        Producto articulo4 = new Producto("Folios", "Folios A4 80 gramos", 4.50, 50, "Navigator", 100, "Blanco");

        //Pedidos
        Pedido pedidoNuevo = new Pedido();
        Pedido pedidoCliente1 = new Pedido();
        Pedido pedidoCliente1S = new Pedido();
        Pedido pedidoCliente2 = new Pedido();
        Pedido pedidoCliente2S = new Pedido();

        //Fin mock

        //Variables
        String op, opMenuCliente, opMenuTrabajador, opMenuAdministrador, opModifica, opModificaProductos, opModificaTrabajador, opMenuProductos;
        boolean esTrabajador = false;

        PintaAscii.pintaFernanShop();

        do {
            op = PintaMenus.pintaMenuPrincipal();

            switch (op) {
                case "1":
                    Persona personaLogeada = loginRegistro.login();
                    if (personaLogeada != null) {
                        switch (personaLogeada.getTipo().toLowerCase()) {
                            case "trabajador": //Cuando el que se logea es trabajador
                                esTrabajador = true;
                                do {
                                    opMenuTrabajador = PintaMenus.pintaMenuTrabajador(personaLogeada, trabajador1, trabajador2, trabajador3);
                                    switch (opMenuTrabajador) {
                                        case "1":
                                            break;
                                        case "2":
                                            break;
                                        case "3":
                                            PintaMenus.pintaCatalogo(libro1, libro2, libro3, libro4, articulo1, articulo2, articulo3, articulo4, esTrabajador);
                                            PantallasDeCarga.pulsaParaContinuar();
                                            break;
                                        case "4":
                                            do {
                                                opModificaProductos = PintaMenus.modificaProductos();
                                                switch (opModificaProductos) {
                                                    case "1":
                                                        System.out.println("Ha seleccionado este libro: ");
                                                        System.out.println(libro1.pintaLibros(esTrabajador));
                                                        PantallasDeCarga.pulsaParaContinuar();
                                                        do {
                                                            opModifica = PintaMenus.modificaLibros();
                                                            libro1.modificaLibros(opModifica);
                                                        } while (!opModifica.equals("10"));
                                                        break;
                                                    case "2":
                                                        System.out.println("Ha seleccionado este libro: ");
                                                        System.out.println(libro2.pintaLibros(esTrabajador));
                                                        PantallasDeCarga.pulsaParaContinuar();
                                                        do {
                                                            opModifica = PintaMenus.modificaLibros();
                                                            libro2.modificaLibros(opModifica);
                                                        } while (!opModifica.equals("10"));
                                                        break;
                                                    case "3":
                                                        System.out.println("Ha seleccionado este libro: ");
                                                        System.out.println(libro3.pintaLibros(esTrabajador));
                                                        PantallasDeCarga.pulsaParaContinuar();
                                                        do {
                                                            opModifica = PintaMenus.modificaLibros();
                                                            libro3.modificaLibros(opModifica);
                                                        } while (!opModifica.equals("10"));
                                                        break;
                                                    case "4":
                                                        System.out.println("Ha seleccionado este libro: ");
                                                        System.out.println(libro4.pintaLibros(esTrabajador));
                                                        PantallasDeCarga.pulsaParaContinuar();
                                                        do {
                                                            opModifica = PintaMenus.modificaLibros();
                                                            libro4.modificaLibros(opModifica);
                                                        } while (!opModifica.equals("10"));
                                                        break;
                                                    case "5":
                                                        System.out.println("Ha seleccionado este articulo: ");
                                                        System.out.println(articulo1.pintaArticulos(esTrabajador));
                                                        PantallasDeCarga.pulsaParaContinuar();
                                                        do {
                                                            opModifica = PintaMenus.modificaArticulos();
                                                            articulo1.modificaArticulos(opModifica);
                                                        } while (!opModifica.equals("9"));

                                                        break;
                                                    case "6":
                                                        System.out.println("Ha seleccionado este articulo: ");
                                                        System.out.println(articulo2.pintaArticulos(esTrabajador));
                                                        PantallasDeCarga.pulsaParaContinuar();
                                                        do {
                                                            opModifica = PintaMenus.modificaArticulos();
                                                            articulo2.modificaArticulos(opModifica);
                                                        } while (!opModifica.equals("9"));
                                                        break;
                                                    case "7":
                                                        System.out.println("Ha seleccionado este articulo: ");
                                                        System.out.println(articulo3.pintaArticulos(esTrabajador));
                                                        PantallasDeCarga.pulsaParaContinuar();
                                                        do {
                                                            opModifica = PintaMenus.modificaArticulos();
                                                            articulo3.modificaArticulos(opModifica);
                                                        } while (!opModifica.equals("9"));
                                                        break;
                                                    case "8":
                                                        System.out.println("Ha seleccionado este articulo: ");
                                                        System.out.println(articulo4.pintaArticulos(esTrabajador));
                                                        PantallasDeCarga.pulsaParaContinuar();
                                                        do {
                                                            opModifica = PintaMenus.modificaArticulos();
                                                            articulo4.modificaArticulos(opModifica);
                                                        } while (!opModifica.equals("9"));
                                                        break;
                                                    case "9":
                                                        PantallasDeCarga.saliendo();
                                                        break;
                                                }
                                            } while (!opModificaProductos.equals("9"));
                                            break;
                                        case "5":
                                            PintaMenus.pintaDatosTrabajador(trabajador1, trabajador2, trabajador3, personaLogeada);
                                            PantallasDeCarga.pulsaParaContinuar();
                                            break;
                                        case "6":
                                            opModificaTrabajador = PintaMenus.modificaTrabajador();
                                            if (trabajador1.getPersona().getEmail().equals(personaLogeada.getEmail()))
                                                trabajador1.modificaTrabajador(opModificaTrabajador);
                                            if (trabajador2.getPersona().getEmail().equals(personaLogeada.getEmail()))
                                                trabajador2.modificaTrabajador(opModificaTrabajador);
                                            if (trabajador3.getPersona().getEmail().equals(personaLogeada.getEmail()))
                                                trabajador3.modificaTrabajador(opModificaTrabajador);
                                            break;
                                        case "7":
                                            PantallasDeCarga.saliendo();
                                            break;
                                    }
                                } while (!opMenuTrabajador.equals("7"));
                                break;
                            case "cliente": //Cuando el que se logea es cliente
                                esTrabajador = false;
                                do {
                                    opMenuCliente = PintaMenus.pintaMenuCliente(personaLogeada);
                                    switch (opMenuCliente) {
                                        case "1":
                                            PintaAscii.pintaTituloLibros();
                                            System.out.println(libro1.pintaLibros(esTrabajador));
                                            System.out.println(libro2.pintaLibros(esTrabajador));
                                            System.out.println(libro3.pintaLibros(esTrabajador));
                                            System.out.println(libro4.pintaLibros(esTrabajador));
                                            PintaAscii.pintaTituloArticulos();
                                            System.out.println(articulo1.pintaArticulos(esTrabajador));
                                            System.out.println(articulo2.pintaArticulos(esTrabajador));
                                            System.out.println(articulo3.pintaArticulos(esTrabajador));
                                            System.out.println(articulo4.pintaArticulos(esTrabajador));
                                            break;
                                        case "2": //Realizar un pedido
                                            pedidoNuevo.realizaPedido(pedidoNuevo, libro1, libro2, libro3, libro4, articulo1, articulo2, articulo3, articulo4);
                                            if (personaLogeada.getEmail().equals(cliente1.getPersona().getEmail())) {
                                                if (cliente1 != null && cliente1.getPedido1() != null && cliente1.getPedido1().estaVacio()) {
                                                    cliente1.setPedido1(pedidoNuevo);
                                                } else if (cliente1 != null && cliente1.getPedido2() != null && cliente1.getPedido2().estaVacio()) {
                                                    cliente1.setPedido2(pedidoNuevo);
                                                }
                                                System.out.println(cliente1.getPedido1().pintaPedido());
                                                System.out.println(cliente1.getPedido2().pintaPedido());
                                            }
                                            if (personaLogeada.getEmail().equals(cliente2.getPersona().getEmail())) {
                                                if (cliente2 != null && cliente2.getPedido1().estaVacio()) {
                                                    cliente2.setPedido1(pedidoNuevo);
                                                } else if (cliente2 != null && cliente2.getPedido2().estaVacio()) {
                                                    cliente2.setPedido2(pedidoNuevo);
                                                }
                                                System.out.println(cliente2.getPedido1().pintaPedido());
                                                System.out.println(cliente2.getPedido2().pintaPedido());
                                            }
                                            break;
                                        case "3": //Ver mis pedidos realizados
                                            break;
                                        case "4":
                                            PintaMenus.pintaDatosCliente(cliente1, cliente2, personaLogeada);
                                            PantallasDeCarga.pulsaParaContinuar();
                                            break;
                                        case "5"://Modificar mis datos personales
                                            break;
                                        case "6": //Cerrar sesión
                                            PantallasDeCarga.saliendo();
                                            break;
                                    }
                                } while (!opMenuCliente.equals("6"));
                                break;
                            case "administrador": //Cuando el que se logea es administrador
                                esTrabajador = true;
                                break;
                        }
                    } else {
                        System.out.println("Email o contraseña incorrectos");
                    }
                    break;
                case "2": //Registrar nuevo cliente
                    if (cliente1 != null && cliente2 != null) {
                        System.out.println("No se pueden registrar más de 2 clientes.");
                    } else {
                        Cliente clienteRegistro = loginRegistro.registroCliente();
                        if (clienteRegistro != null) {
                            if (cliente1 == null) {
                                cliente1 = clienteRegistro;
                                cliente1.setPedido1(pedidoCliente1);
                                cliente1.setPedido1(pedidoCliente1S);
                            } else if (cliente2 == null) {
                                cliente2 = clienteRegistro;
                                cliente2.setPedido1(pedidoCliente2);
                                cliente2.setPedido1(pedidoCliente2S);
                            }
                            System.out.println("Cliente registrado con exito.");
                            System.out.println(clienteRegistro);
                        }
                    }
                    break;
                case "3":
                    PantallasDeCarga.saliendo();
                    LimpiaPantalla.limpiar();
                    PintaAscii.pintaLogotipo();
                    break;
                default:
                    System.out.println("Opcion incorrecta");
            }

        } while (!op.equals("3"));


    }
}
