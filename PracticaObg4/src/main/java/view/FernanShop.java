package view;

import models.*;

import java.util.
        Scanner;

import static utils.Utils.*;
import static view.Menus.*;

public class FernanShop {
    public final static Scanner S = new Scanner(System.in);

    public static void main(String[] args) {

        //Mock
        //Personas (trabajadores) (maximo 3 trabajadores)
        Persona persona1 = new Persona("Ahmed Lhaouchi Briki", 631789530, "ahmed.lhaouchi.2602@fernando3martos.com", "Torredelcampo", "Jaén", "Calle Ramón y Cajal 24A", false, true, false, true);
        Trabajador trabajador1 = new Trabajador(persona1, "1234"); //Persona 1 email: "ahmed.lhaouchi.2602@fernando3martos.com" y contraseña: "1234"

        Persona persona2 = new Persona("Marcos Lara Cano", 693683952, "marcos.lara.0610@fernando3martos.com", "Martos", "Jaén", "Calle Via Lactea 15 1º B", false, true, false, true);
        Trabajador trabajador2 = new Trabajador(persona2, "5678"); //Persona 2 email: "marcos.lara0610@fernando3martos.com" y contraseña: "5678"

        Persona persona3 = null;
        Trabajador trabajador3 = null;

        //Persona (admin) (max 1 admin)
        Persona persona4 = new Persona("Carlos Barroso", 629364920, "carlos@gmail.com", "Jaén", "Jaén", "Calle Federico Garcia 19 8º Drcha", false, false, true, true);
        Administrador admin = new Administrador(persona4, "admin"); //Persona 4 email: "carlos@gmail.com" y contraseña: "admin"

        //Personas (clientes) (max 2 clientes)
        Persona persona5 = new Persona("Maria Fernandez Zafra", 691735283, "ahmedlhabri26@gmail.com", "Andujar", "Jaén", "Calle Paseo de la Castellana 72 2ºB", true, false, false, true);
        Cliente cliente1 = new Cliente(persona5, "0123"); //Persona 5 email: "maria@gmail.com" y contraseña: "0123"

        Persona persona6 = null;
        Cliente cliente2 = null; //Persona 6

        //Productos
        //Libros
        Producto libro1 = new Producto("El niño con el pijama de rayas", "Novela", 12.50F, 10, "John Boyne", "Salamandra", "Ficción", "Español", "libro");
        Producto libro2 = new Producto("Cien años de soledad", "Novela", 20, 30, "Gabriel García Márquez", "Sudamericana", "Ficción", "Español", "libro");
        Producto libro3 = new Producto("La chica del tren", "Misterio / Suspense", 15, 5, "Paula Hawkins", "Planeta", "Misterio", "Español", "libro");
        Producto libro4 = new Producto("Las aventuras de Tom Sawyer", "Aventura", 10, 30, "Mark Twain", "Vicens Vives", "Aventura", "Español", "libro");

        //Papelería
        Producto articulo1 = new Producto("Pilot Frixion", "Bolígrafo", 2.50F, 150, "Pilot", 1, "Azul", "articulo");
        Producto articulo2 = new Producto("Juego de reglas", "Herramientas de medición", 8, 200, "Maped", 3, "Transparente", "articulo");
        Producto articulo3 = new Producto("Lápiz HB", "Lápiz", 0.80F, 300, "BIC", 1, "Negro", "articulo");
        Producto articulo4 = new Producto("Folios", "Folios A4 80 gramos", 4.50F, 50, "Navigator", 100, "Blanco", "articulo");

        //Pedidos
        Pedido pedido1 = null;
        Pedido pedido2 = null;
        Pedido pedido3 = null;
        Pedido pedido4 = null;
        //Fin mock

        //Variables
        String op, opAdmin, opTrabajador, opCliente, opModifica;

        do {
            op = pintaMenuPrincipal();
            switch (op) {
                case "1": //Login
                    Persona personaLogeada;
                    do {
                        personaLogeada = Login(admin, cliente1, cliente2, trabajador1, trabajador2, trabajador3);
                        if (personaLogeada == null)
                            System.out.println("\nInicio de sesión fallido, vuelva a intentarlo");
                    } while (personaLogeada == null);
                    //Saca el menu según el rol de la persona que se ha logueado
                    switch (rolPersona(personaLogeada)) {
                        case "admin": //Menu admin
                            do {
                                opAdmin = pintaMenuAdmin(personaLogeada);
                                switch (opAdmin) {
                                    case "1": //Asignar un pedido a un trabajador
                                        asignaPedidosAdmin(cliente1, cliente2, trabajador1, trabajador2, trabajador3);
                                        break;
                                    case "2": //Modificar el estado de un pedido
                                        modificaEstadoPedido(cliente1, cliente2);
                                        break;
                                    case "3": //Dar de alta un trabajador
                                        if (!verificaTrabajadoresCreados(trabajador1, trabajador2, trabajador3)) break;
                                        if (trabajador1 == null)
                                            trabajador1 = altaTrabajador(cliente1, cliente2, trabajador1, trabajador2, trabajador3, admin);
                                        else if (trabajador2 == null)
                                            trabajador2 = altaTrabajador(cliente1, cliente2, trabajador1, trabajador2, trabajador3, admin);
                                        else if (trabajador3 == null) {
                                            trabajador3 = altaTrabajador(cliente1, cliente2, trabajador1, trabajador2, trabajador3, admin);
                                        }
                                        break;
                                    case "4": //Ver todos los pedidos
                                        pintaPedidos(cliente1, cliente2);
                                        pulsaParaContinuar();
                                        break;
                                    case "5": //Ver todos los clientes
                                        pintaClientes(cliente1, cliente2);
                                        pulsaParaContinuar();
                                        break;
                                    case "6": //Ver todos los trabajadores
                                        pintaTrabajadores(trabajador1, trabajador2, trabajador3);
                                        pulsaParaContinuar();
                                        break;
                                    case "7": //Cerrar sesión
                                        pintaCerrandoSesion();
                                        break;
                                    default:
                                        pintaOpIncorrecta();
                                }
                            } while (!opAdmin.equals("7"));
                            break;
                        case "trabajador": //Menu trabajador
                            do {
                                opTrabajador = pintaMenuTrabajador(personaLogeada, trabajador1, trabajador2, trabajador3);
                                switch (opTrabajador) {
                                    case "1": //Consultar los pedidos que tengo asignados
                                        pintaPedidosAsignados(trabajador1, trabajador2, trabajador3, personaLogeada);
                                        break;
                                    case "2": //Modificar el estado de un pedido
                                        modificaEstadoPedido(cliente1, cliente2);
                                        break;
                                    case "3": //Consultar el catálogo de productos
                                        pintaCatalogo(libro1, libro2, libro3, libro4, articulo1, articulo2, articulo3, articulo4, personaLogeada.isEsTrabajador());
                                        pulsaParaContinuar();
                                        break;
                                    case "4": //Modificar un producto del catalogo
                                        modificadorProductos(libro1, libro2, libro3, libro4, articulo1, articulo2, articulo3, articulo4, personaLogeada.isEsTrabajador());
                                        break;
                                    case "5": //Ver mi perfil
                                        pintaDatosTrabajador(trabajador1, trabajador2, trabajador3, personaLogeada);
                                        pulsaParaContinuar();
                                        break;
                                    case "6": //Modificar mis datos personales
                                        modificadorTrabajadores(trabajador1, trabajador2, trabajador3, personaLogeada, admin, cliente1, cliente2);
                                        break;
                                    case "7": //Cerrar sesión
                                        pintaCerrandoSesion();
                                        break;
                                    default:
                                        pintaOpIncorrecta();
                                }
                            } while (!opTrabajador.equals("7"));
                            break;

                        case "cliente"://Menu cliente
                            do {
                                opCliente = pintaMenuCliente(personaLogeada, cliente1, cliente2);
                                switch (opCliente) {
                                    case "1"://Consultar el catálogo de productos
                                        pintaCatalogo(libro1, libro2, libro3, libro4, articulo1, articulo2, articulo3, articulo4, personaLogeada.isEsTrabajador());
                                        pulsaParaContinuar();
                                        break;
                                    case "2"://Realizar un pedido
                                        realizaPedido(cliente1, cliente2, trabajador1, trabajador2, trabajador3, personaLogeada, libro1, libro2, libro3, libro4, articulo1, articulo2, articulo3, articulo4);
                                        break;
                                    case "3": //Ver mis pedidos realizados
                                        pintaPedidosRealizados(cliente1, cliente2, personaLogeada);
                                        break;
                                    case "4": //Ver mis datos personales
                                        pintaDatosCliente(cliente1, cliente2, personaLogeada);
                                        pulsaParaContinuar();
                                        break;
                                    case "5": //Modificar mis datos personales
                                        modificadorClientes(cliente1, cliente2, personaLogeada, trabajador1, trabajador2, trabajador3, admin);
                                        break;
                                    case "6": //Cerrar sesión
                                        pintaCerrandoSesion();
                                        break;
                                    default:
                                        pintaOpIncorrecta();
                                }
                            } while (!opCliente.equals("6"));
                            break;
                    }
                    break;
                case "2"://Registrarse
                    if (!verificaClientesCreados(cliente1, cliente2)) break;
                    if (cliente1 == null)
                        cliente1 = registroCliente(cliente1, cliente2, trabajador1, trabajador2, trabajador3, admin);
                    else if (cliente2 == null)
                        cliente2 = registroCliente(cliente1, cliente2, trabajador1, trabajador2, trabajador3, admin);
                    break;
                case "3": //Salir
                    pintaSaliendo();
                    LimpiaPantalla();
                    pintaLogo();
                    break;
                default:
                    pintaOpIncorrecta();
            }
        } while (!op.equals("3"));
    }


}
