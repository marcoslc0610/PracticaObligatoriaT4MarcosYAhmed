package utils;

import models.*;

import java.util.Scanner;

public class PintaMenus {

    public static String pintaMenuPrincipal() {
        Scanner s = new Scanner(System.in);
        System.out.print("""
                \n┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓
                      BIENVENIDO A FERNANSHOP:
                        1. - LOGIN
                        2. - REGISTRARSE
                        3. - SALIR
                ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛
                Opción:\s""");
        String op = s.nextLine();
        return op;
    }

    public static String pintaMenuAdministrador(Persona persona) {
        Scanner s = new Scanner(System.in);
        System.out.println("""
                \n┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓
                    Bienvenido Admin. Tiene un pedido por asignar.
                        1.- Asignar un pedido a un trabajador
                        2.- Modificar el estado de un pedido
                        3. Dar de alta un trabajador
                        4.- Ver todos los pedidos
                        5.- Ver todos los clientes
                        6.- Ver todos los trabajadores
                        7.- Cerrar sesión
                ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛
                Opción:\s""");
        String op = s.nextLine();
        return op;
    }


    public static String pintaMenuCliente(Persona persona) {
        Scanner s = new Scanner(System.in);
        String nombre = persona.getNombre();
        System.out.printf("""
                \n┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓
                    Bienvenido %s
                        1.- Consultar el catálogo de productos
                        2.- Realizar un pedido
                        3.- Ver mis pedidos realizados
                        4.- Ver mis datos personales
                        5.- Modificar mis datos personales
                        6.- Cerrar sesión
                ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛
                Opción:\s""", nombre);
        String op = s.nextLine();
        return op;
    }

    public static String pintaMenuTrabajador(Persona persona, Trabajador trabajador1, Trabajador trabajador2, Trabajador trabajador3) {
        Scanner s = new Scanner(System.in);
        Trabajador trabajadorLogeado = null;
        int pedidos = 0;
        if (trabajador1 != null && persona.getEmail().equals(trabajador1.getPersona().getEmail())) {
            trabajadorLogeado = trabajador1;
            pedidos = trabajador1.getPedidosAGestionar();
        }
        if (trabajador2 != null && persona.getEmail().equals(trabajador2.getPersona().getEmail())) {
            trabajadorLogeado = trabajador2;
            pedidos = trabajador2.getPedidosAGestionar();
        }
        if (trabajador3 != null && persona.getEmail().equals(trabajador3.getPersona().getEmail())) {
            trabajadorLogeado = trabajador3;
            pedidos = trabajador3.getPedidosAGestionar();
        }
        String nombre = trabajadorLogeado.getPersona().getNombre();

        System.out.printf("""
                \n┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓
                    Bienvenido %s . Tienes %d pedidos
                        1.- Consultar los pedidos que tengo asignados
                        2.- Modificar el estado de un pedido
                        3.- Consultar el catálogo de productos
                        4.- Modificar un producto del catálogo
                        5.- Ver mi perfil
                        6.- Modificar mis datos personales
                        7. Cerrar sesión
                ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛
                Opción:\s""", nombre, pedidos);
        String op = s.nextLine();
        return op;
    }

    public static void pintaDatosTrabajador(Trabajador trabajador1, Trabajador trabajador2, Trabajador trabajador3, Persona personaLogeada) {
        if (trabajador1 != null && personaLogeada.getEmail().equals(trabajador1.getPersona().getEmail())) {
            System.out.println(trabajador1);
        }
        if (trabajador2 != null && personaLogeada.getEmail().equals(trabajador2.getPersona().getEmail())) {
            System.out.println(trabajador2);
        }
        if (trabajador3 != null && personaLogeada.getEmail().equals(trabajador3.getPersona().getEmail())) {
            System.out.println(trabajador3);
        }
    }

    public static void pintaDatosCliente(Cliente cliente1, Cliente cliente2, Persona personaLogeada) {
        if (cliente1 != null && personaLogeada.getEmail().equals(cliente1.getPersona().getEmail())) {
            System.out.println(cliente1);
        }
        if (cliente2 != null && personaLogeada.getEmail().equals(cliente2.getPersona().getEmail())) {
            System.out.println(cliente2);
        }
    }

    public static void pintaCatalogo(Producto libro1, Producto libro2, Producto libro3, Producto libro4, Producto articulo1, Producto articulo2, Producto articulo3, Producto articulo4, boolean esTrabajador) {
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
    }

    public static String modificaTrabajador(){
        Scanner s = new Scanner(System.in);
        System.out.print("""
                                ┏┳┓    ┓   •   ┓   \s
                                 ┃ ┏┓┏┓┣┓┏┓┓┏┓┏┫┏┓┏┓
                                 ┻ ┛ ┗┻┗┛┗┻┃┗┻┗┻┗┛┛\s
                                           ┛       \s
                \n┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓
                        ➤  Seleccione datos a modificar:
                            1.- Modificar todos los datos
                            2.- Nombre
                            3.- Email
                            4.- Telefono
                            5.- Localidad
                            6.- Dirección
                            7.- Contraseña
                            8.- Salir
                ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛
                Opción:\s""");
        String op = s.nextLine();
        return op;
    }

    public static String menuProductos(Producto libro1, Producto libro2, Producto libro3, Producto libro4, Producto articulo1, Producto articulo2, Producto articulo3, Producto articulo4) {
        Scanner s = new Scanner(System.in);
        Pedido pedidoNuevo;
        System.out.printf("""
                \n┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓
                        ➤  Seleccione un producto:
                            1.- %s
                            2.- %s
                            3.- %s
                            4.- %s
                            5.- %s
                            6.- %s
                            7.- %s
                            8.- %s
                            9.- Salir
                ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛
                Opción:\s""",libro1.getNombre(), libro2.getNombre(), libro3.getNombre(), libro4.getNombre(), articulo1.getNombre(), articulo2.getNombre(), articulo3.getNombre(), articulo4.getNombre());
        String op = s.nextLine();
        return op;
    }

    public static String modificaCliente(){
        Scanner s = new Scanner(System.in);
        System.out.print("""
                                        ┏┓┓•      \s
                                        ┃ ┃┓┏┓┏┓╋┏┓
                                        ┗┛┗┗┗ ┛┗┗┗\s
                                                  \s
                \n┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓
                        ➤  Seleccione datos a modificar:
                            1.- Modificar todos los datos
                            2.- Nombre
                            3.- Email
                            4.- Telefono
                            5.- Localidad
                            6.- Dirección
                            7.- Contraseña
                            8.- Salir
                ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛
                Opción:\s""");
        String op = s.nextLine();
        return op;
    }

    public static String modificaProductos() {
        Scanner s = new Scanner(System.in);
        System.out.print("""
                                ╔╦╗┌─┐┌┬┐┬┌─┐┬┌─┐┌─┐┬─┐
                                ║║║│ │ │││├┤ ││  ├─┤├┬┘
                                ╩ ╩└─┘─┴┘┴└  ┴└─┘┴ ┴┴└─
                \n┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓
                     ➤  Seleccione producto a modificar:
                
                            ⟶ LIBROS:
                                1.- El niño con el pijama de rayas
                                2.- Cien años de soledad
                                3.- La chica del tren
                                4.- Las aventuras de Tom Sawyer
                
                            ⟶ ARTÍCULOS DE PAPELERÍA:
                                5.- Pilot Frixion
                                6.- Juego de reglas
                                7.- Lápiz HB
                                8.- Folios
                
                            ⟶  9.- Salir
                ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛
                Opción:\s""");
        String op = s.nextLine();
        return op;
    }

    public static String modificaLibros() {
        Scanner s = new Scanner(System.in);
        System.out.print("""
                                ┳┳┓   ┓•┏•       ┓•┓     \s
                                ┃┃┃┏┓┏┫┓╋┓┏┏┓┏┓  ┃┓┣┓┏┓┏┓┏
                                ┛ ┗┗┛┗┻┗┛┗┗┗┻┛   ┗┗┗┛┛ ┗┛┛
                \n┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓
                     ➤  Seleccione datos a modificar:
                            1.- Modificar todos los datos
                            2.- Nombre
                            3.- Descripción
                            4.- Precio
                            5.- Stock
                            6.- Autor
                            7.- Editorial
                            8.- Genero
                            9.- Idioma
                            10.- Salir
                ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛
                Opción:\s""");
        String op = s.nextLine();
        return op;
    }

    public static String modificaArticulos() {
        Scanner s = new Scanner(System.in);
        System.out.print("""
                              ┳┳┓   ┓•┏•            •   ┓  \s
                              ┃┃┃┏┓┏┫┓╋┓┏┏┓┏┓  ┏┓┏┓╋┓┏┓┏┃┏┓┏
                              ┛ ┗┗┛┗┻┗┛┗┗┗┻┛   ┗┻┛ ┗┗┗┗┻┗┗┛┛
                \n┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓
                     ➤  Seleccione libro a modificar:
                            1.- Modificar todos los datos
                            2.- Nombre
                            3.- Descripción
                            4.- Precio
                            5.- Stock
                            6.- Marca
                            7.- Unidades
                            8.- Color
                            9.- Salir
                ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛
                Opción:\s""");
        String op = s.nextLine();
        return op;
    }
}
