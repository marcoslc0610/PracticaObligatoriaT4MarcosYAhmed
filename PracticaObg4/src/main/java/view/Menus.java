package view;

import models.Cliente;
import models.Persona;
import models.Producto;
import models.Trabajador;

import java.util.Scanner;

public class Menus {

    private static final Scanner S = new Scanner(System.in);

    //Menus
    public static String pintaMenuPrincipal() {
        pintaFernanShop();
        System.out.print("""
                \n┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓
                      BIENVENIDO A FERNANSHOP:
                 ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
                        1. - Iniciar sesión
                        2. - Registrarse
                        3. - Salir
                ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛
                Opción:\s""");
        return S.nextLine();
    }

    public static String pintaMenuAdmin(Persona persona) {
        pintaTituloAdmin();
        Scanner S = new Scanner(System.in);
        System.out.print("""
                \n┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓
                    Bienvenido Admin. Tiene un pedido por asignar.
                        1.- Asignar un pedido a un trabajador
                        2.- Modificar el estado de un pedido
                        3.- Dar de alta un trabajador
                        4.- Ver todos los pedidos
                        5.- Ver todos los clientes
                        6.- Ver todos los trabajadores
                        7.- Cerrar sesión
                ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛
                Opción:\s""");
        return S.nextLine();
    }

    public static String pintaMenuCliente(Persona persona, Cliente cliente1, Cliente cliente2) {

        /*//Cliente clienteLogeado = null;
        if (cliente1 != null && persona.getEmail().equals(cliente1.getPersona().getEmail())) {
            //clienteLogeado = cliente1;
        }
        if (cliente2 != null && persona.getEmail().equals(cliente2.getPersona().getEmail())) {
            //clienteLogeado = cliente2;
        }*/

        String nombre = persona.getNombreCompleto();
        pintaTituloCliente();
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
        return S.nextLine();
    }

    public static String pintaMenuTrabajador(Persona persona, Trabajador trabajador1, Trabajador trabajador2, Trabajador trabajador3) {

        Trabajador trabajadorLogeado = null;
        int pedidos = 0;
        if (trabajador1 != null && persona.getEmail().equals(trabajador1.getPersona().getEmail())) {
            trabajadorLogeado = trabajador1;
            pedidos = (trabajador1.getPedido1() != null ? 1 : 0) + (trabajador1.getPedido2() != null ? 1 : 0);
        }
        if (trabajador2 != null && persona.getEmail().equals(trabajador2.getPersona().getEmail())) {
            trabajadorLogeado = trabajador2;
            pedidos = (trabajador2.getPedido1() != null ? 1 : 0) + (trabajador2.getPedido2() != null ? 1 : 0);
        }
        if (trabajador3 != null && persona.getEmail().equals(trabajador3.getPersona().getEmail())) {
            trabajadorLogeado = trabajador3;
            pedidos = (trabajador3.getPedido1() != null ? 1 : 0) + (trabajador3.getPedido2() != null ? 1 : 0);
        }
        String nombre = trabajadorLogeado.getPersona().getNombreCompleto(); //TODO excepción
        System.out.println("""
                ┏┳┓    ┓   •   ┓   \s
                 ┃ ┏┓┏┓┣┓┏┓┓┏┓┏┫┏┓┏┓
                 ┻ ┛ ┗┻┗┛┗┻┃┗┻┗┻┗┛┛""");
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
        return S.nextLine();
    }

    //Datos
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
            pintaTituloCliente();
            System.out.println(cliente1);
        }
        if (cliente2 != null && personaLogeada.getEmail().equals(cliente2.getPersona().getEmail())) {
            pintaTituloCliente();
            System.out.println(cliente2);
        }
    }

    public static void pintaCatalogo(Producto libro1, Producto libro2, Producto libro3, Producto libro4, Producto articulo1, Producto articulo2, Producto articulo3, Producto articulo4, boolean esTrabajador) {
        pintaTituloLibros();
        System.out.println(libro1.pintaLibros(esTrabajador));
        System.out.println(libro2.pintaLibros(esTrabajador));
        System.out.println(libro3.pintaLibros(esTrabajador));
        System.out.println(libro4.pintaLibros(esTrabajador));
        pintaTituloArticulos();
        System.out.println(articulo1.pintaArticulos(esTrabajador));
        System.out.println(articulo2.pintaArticulos(esTrabajador));
        System.out.println(articulo3.pintaArticulos(esTrabajador));
        System.out.println(articulo4.pintaArticulos(esTrabajador));
    }

    public static void pintaTrabajadores(Trabajador trabajador1, Trabajador trabajador2, Trabajador trabajador3) {
        if (trabajador1 != null) System.out.println(trabajador1);
        if (trabajador2 != null) System.out.println(trabajador2);
        if (trabajador3 != null) System.out.println(trabajador3);
    }

    public static void pintaClientes(Cliente cliente1, Cliente cliente2) {
        if (cliente1 != null) System.out.println(cliente1);
        if (cliente2 != null) System.out.println(cliente2);
    }

    public static void pintaPedidos(Cliente c1, Cliente c2) {
        if (c1 == null && c2 == null) {
            System.out.println("No hay clientes registrados.");
            return;
        }

        boolean hayPedidos = false;

        if (c1 != null) {
            if (c1.getPedido1() != null) {
                System.out.println(c1.getPedido1().pintaPedido(true));
                hayPedidos = true;
            }
            if (c1.getPedido2() != null) {
                System.out.println(c1.getPedido2().pintaPedido(true));
                hayPedidos = true;
            }
        }

        if (c2 != null) {
            if (c2.getPedido1() != null) {
                System.out.println(c2.getPedido1().pintaPedido(true));
                hayPedidos = true;
            }
            if (c2.getPedido2() != null) {
                System.out.println(c2.getPedido2().pintaPedido(true));
                hayPedidos = true;
            }
        }

        if (!hayPedidos) {
            System.out.println("""
                    ┳┓    ┓            ┓• ┓
                    ┃┃┏┓  ┣┓┏┓┓┏  ┏┓┏┓┏┫┓┏┫┏┓┏  ┏┓┓┏┏┓  ┏┳┓┏┓┏╋┏┓┏┓┏┓
                    ┛┗┗┛  ┛┗┗┻┗┫  ┣┛┗ ┗┻┗┗┻┗┛┛  ┗┫┗┻┗   ┛┗┗┗┛┛┗┛ ┗┻┛
                               ┛  ┛              ┗                  
                    """);
        }
    }


    public static void pintaPedidosAsignados(Trabajador trabajador1, Trabajador trabajador2, Trabajador trabajador3, Persona personaLogeada) {
        if (trabajador1 != null && trabajador1.getPersona().getEmail().equals(personaLogeada.getEmail())) {
            if (trabajador1.getPedido1() == null && trabajador1.getPedido2() == null) System.out.println("""
                    ┳┓     •              ┓• ┓        •       ┓  \s
                    ┃┃┏┓  ╋┓┏┓┏┓┏┓┏  ┏┓┏┓┏┫┓┏┫┏┓┏  ┏┓┏┓┏┓┏┓┏┓┏┫┏┓┏
                    ┛┗┗┛  ┗┗┗ ┛┗┗ ┛  ┣┛┗ ┗┻┗┗┻┗┛┛  ┗┻┛┗┗┫┛┗┗┻┗┻┗┛┛
                                     ┛                  ┛        \s
                    """);
            if (trabajador1.getPedido1() != null) System.out.println(trabajador1.getPedido1().pintaPedido(true));
            if (trabajador1.getPedido2() != null) System.out.println(trabajador1.getPedido2().pintaPedido(true));
        }
        if (trabajador2 != null && trabajador2.getPersona().getEmail().equals(personaLogeada.getEmail())) {
            if (trabajador2.getPedido1() == null && trabajador2.getPedido2() == null) System.out.println("""
                    ┳┓     •              ┓• ┓        •       ┓  \s
                    ┃┃┏┓  ╋┓┏┓┏┓┏┓┏  ┏┓┏┓┏┫┓┏┫┏┓┏  ┏┓┏┓┏┓┏┓┏┓┏┫┏┓┏
                    ┛┗┗┛  ┗┗┗ ┛┗┗ ┛  ┣┛┗ ┗┻┗┗┻┗┛┛  ┗┻┛┗┗┫┛┗┗┻┗┻┗┛┛
                                     ┛                  ┛        \s
                    """);
            if (trabajador2.getPedido1() != null) System.out.println(trabajador2.getPedido1().pintaPedido(true));
            if (trabajador2.getPedido2() != null) System.out.println(trabajador2.getPedido2().pintaPedido(true));
        }
        if (trabajador3 != null && trabajador3.getPersona().getEmail().equals(personaLogeada.getEmail())) {
            if (trabajador3.getPedido1() == null && trabajador3.getPedido2() == null) System.out.println("""
                    ┳┓     •              ┓• ┓        •       ┓  \s
                    ┃┃┏┓  ╋┓┏┓┏┓┏┓┏  ┏┓┏┓┏┫┓┏┫┏┓┏  ┏┓┏┓┏┓┏┓┏┓┏┫┏┓┏
                    ┛┗┗┛  ┗┗┗ ┛┗┗ ┛  ┣┛┗ ┗┻┗┗┻┗┛┛  ┗┻┛┗┗┫┛┗┗┻┗┻┗┛┛
                                     ┛                  ┛        \s
                    """);
            if (trabajador3.getPedido1() != null) System.out.println(trabajador3.getPedido1().pintaPedido(true));
            if (trabajador3.getPedido2() != null) System.out.println(trabajador3.getPedido2().pintaPedido(true));
        }
    }

    public static void pintaPedidosRealizados(Cliente cliente1, Cliente cliente2, Persona personaLogeada) {
        if (cliente1 != null && cliente1.getPersona().getEmail().equals(personaLogeada.getEmail())) {
            System.out.println((cliente1.getPedido1() == null ? "- Pedido 1 no realizado por el cliente" : cliente1.getPedido1().pintaPedido(true)));
            System.out.println((cliente1.getPedido2() == null ? "- Pedido 2 no realizado por el cliente" : cliente1.getPedido2().pintaPedido(true)));
        }

        if (cliente2 != null && cliente2.getPersona().getEmail().equals(personaLogeada.getEmail())) {
            System.out.println((cliente2.getPedido1() == null ? "- Pedido 1 no realizado por el cliente" : cliente2.getPedido1().pintaPedido(true)));
            System.out.println((cliente2.getPedido2() == null ? "- Pedido 2 no realizado por el cliente" : cliente2.getPedido2().pintaPedido(true)));
        }
    }

    public static String menuModificaCliente() {

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
                            5.- Ciudad
                            6.- Provincia
                            7.- Dirección
                            8.- Contraseña
                            9.- Salir
                ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛
                Opción:\s""");
        return S.nextLine();
    }

    public static String menuModificaTrabajador() {

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
                            5.- Ciudad
                            6.- Provincia
                            7.- Dirección
                            8.- Contraseña
                            9.- Salir
                ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛
                Opción:\s""");
        return S.nextLine();
    }

    public static String menuSeleccionaProductos(Producto libro1, Producto libro2, Producto libro3, Producto libro4, Producto articulo1, Producto articulo2, Producto articulo3, Producto articulo4) {

        System.out.println("\n\n\n");
        System.out.printf("""
                                    ┏┓     ┓      \s
                                    ┃┃┏┓┏┓┏┫┓┏┏╋┏┓┏
                                    ┣┛┛ ┗┛┗┻┗┻┗┗┗┛┛
                \n┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓
                     ➤  Seleccione un producto:
                
                            ⟶ LIBROS:
                                1.- %s
                                2.- %s
                                3.- %s
                                4.- %s
                
                            ⟶ ARTÍCULOS DE PAPELERÍA:
                                5.- %s
                                6.- %s
                                7.- %s
                                8.- %s
                
                            ⟶  9.- Salir
                ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛
                Opción:\s""", libro1.getNombre(), libro2.getNombre(), libro3.getNombre(), libro4.getNombre(), articulo1.getNombre(), articulo2.getNombre(), articulo3.getNombre(), articulo4.getNombre());
        return S.nextLine();
    }

    public static String menuModificaLibros() {

        System.out.println("\n\n\n");
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
        return S.nextLine();
    }

    public static String menuModificaArticulos() {

        System.out.println("\n\n\n");
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
        return S.nextLine();
    }

    //Menu para cambiar el estado de los pedidos
    public static String menuCambiaEstadoPedidos() {
        int op = -1;
        do {
            try {
                System.out.print("""
                        
                            ┳┳┓   ┓•┏•              ┓ \s
                            ┃┃┃┏┓┏┫┓╋┓┏┏┓┏┓  ┏┓┏╋┏┓┏┫┏┓
                            ┛ ┗┗┛┗┻┗┛┗┗┗┻┛   ┗ ┛┗┗┻┗┻┗┛
                                                      \s\n
                        \n┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓
                               1. En Preparación
                               2. Enviado
                               3. Cancelado
                               4. Recibido
                               5. Retrasado
                        ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛
                        Elija una opción:\s""");
                op = Integer.parseInt(S.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Error: Introduzca un número valido");
            }
        } while (op < 1 || op > 5);
        return switch (op) {
            case 1 -> "En Preparación";
            case 2 -> "Enviado";
            case 3 -> "Cancelado";
            case 4 -> "Recibido";
            case 5 -> "Retrasado";
            default -> "";
        };
    }

    //Pantallas de carga
    public static void LimpiaPantalla() {
        for (int i = 0; i < 2000; i++) {
            System.out.println();
        }
    }

    //Ascii
    public static void pintaFernanShop() {
        System.out.println();
        System.out.println();
        System.out.println("""
                 __| |_______________________________________________________________________________________| |__
                (__   ________________________________________________________________________________________   __)
                   | |                                                                                        | |
                   | |                                                                                        | |
                   | |  ███████╗███████╗██████╗ ███╗   ██╗ █████╗ ███╗   ██╗███████╗██╗  ██╗ ██████╗ ██████╗\s | |
                   | |  ██╔════╝██╔════╝██╔══██╗████╗  ██║██╔══██╗████╗  ██║██╔════╝██║  ██║██╔═══██╗██╔══██╗ | |
                   | |  █████╗  █████╗  ██████╔╝██╔██╗ ██║███████║██╔██╗ ██║███████╗███████║██║   ██║██████╔╝ | |
                   | |  ██╔══╝  ██╔══╝  ██╔══██╗██║╚██╗██║██╔══██║██║╚██╗██║╚════██║██╔══██║██║   ██║██╔═══╝\s | |
                   | |  ██║     ███████╗██║  ██║██║ ╚████║██║  ██║██║ ╚████║███████║██║  ██║╚██████╔╝██║    \s | |
                   | |  ╚═╝     ╚══════╝╚═╝  ╚═╝╚═╝  ╚═══╝╚═╝  ╚═╝╚═╝  ╚═══╝╚══════╝╚═╝  ╚═╝ ╚═════╝ ╚═╝    \s | |
                   | |                                                                                        | |
                 __| |________________________________________________________________________________________| |__
                (__   _________________________________________________________________________________________  __)
                   | |                                                                                        | |
                """);
    }


    public static void pintaOpIncorrecta() {
        System.out.println("""
                ┏┓   •      •              \s
                ┃┃┏┓┏┓┏┓┏┓  ┓┏┓┏┏┓┏┓┏┓┏┓┏╋┏┓
                ┗┛┣┛┗┗┗┛┛┗  ┗┛┗┗┗┛┛ ┛ ┗ ┗┗┗┻
                  ┛                        \s
                """);
        System.out.println();
    }

    public static void pintaLogo() {
        System.out.println("""
                                                     ::-==+++++==-::                                                   \s
                                                 :=+#%%@@@@@%%@@@@%%#+=:                                              \s
                                              :+#%@@%#*==-::::--==*#%@@%#+-                                           \s
                                           :-=+++=::               :-+*##*=:                                          \s
                                         :=+++=:                      :-+###+:                                        \s
                                        -+++-       +:            #-     :+#%#=                                       \s
                                      :+++=:       -%*           +%#:      :*%%*:                                     \s
                                     -+*+:  *@@@@@%##%=         -%#%+        =%%#:                                    \s
                                    :+*+:        *%####:       :#%##%=        =%%#:                                   \s
                                   :+**:         *#####*       +%#%%%#:        =%%#                                   \s
                                   =**=         +######%+     =%###%%%*         *%%=                                   \s
                :*#######*****##= :***         -####%###%-   :####%%%%%+        -%%#  :*#######*****##=               \s
                                  -**+        :##### #%%%#:  *%%%%=*%%%%-        #%%-                                 \s
                *##############+  =##=        +%##%   #%%%*:+%%%%= :#%%%#:       *%%=  *##############+               \s
                                  =##=       =%#%%#   #%%%%%%%%%+   =%%%%*       *%%=                                 \s
                -###############= =##+      -#%%%%%%%%%%%%%%%%%*     *%%%%=      #%%- -###############=               \s
                                  :%%#      #%%%%       #%%%%%#:      #%%%#:    :%%%:                                 \s
                                   *%%=    +%%%%=       :+%%%+-       =%%%%*    +%%*                                  \s
                                   :%%#:  -%%%%*                       *%%%%-  -%%%:                                  \s
                                    =%%#: #%%%%:                       :#%%%# -%%%=                                   \s
                                     =%%#-*###-  -##*%*         +###%=  -####*%%%=                                     \s
                                      =%%%+:     #@=:#@-       -@%:-@%     :*%%%-                                      \s
                                       :*%%#=    :#%%%+         =%%%#-    =#%%*:                                       \s
                                         -#%%#+:                       :+#@%#=                                        \s
                                           -*%@%#+-                :-+#%@%#=                                           \s
                                             :+#%@@%#*==-::::--==*#%@@%#+-                                             \s
                                                :=+#%%@@@@@%%@@@@%%#+=:                                                \s
                                                    ::-==+++++==-::""");
    }

    public static void pintaTituloLibros() {
        System.out.println("""
                ██╗     ██╗██████╗ ██████╗  ██████╗ ███████╗
                ██║     ██║██╔══██╗██╔══██╗██╔═══██╗██╔════╝
                ██║     ██║██████╔╝██████╔╝██║   ██║███████╗
                ██║     ██║██╔══██╗██╔══██╗██║   ██║╚════██║
                ███████╗██║██████╔╝██║  ██║╚██████╔╝███████║
                ╚══════╝╚═╝╚═════╝ ╚═╝  ╚═╝ ╚═════╝ ╚══════╝
                                                           \s
                """);
    }

    public static void pintaTituloArticulos() {
        System.out.println("""
                 █████╗ ██████╗ ████████╗██╗ ██████╗██╗   ██╗██╗      ██████╗ ███████╗
                ██╔══██╗██╔══██╗╚══██╔══╝██║██╔════╝██║   ██║██║     ██╔═══██╗██╔════╝
                ███████║██████╔╝   ██║   ██║██║     ██║   ██║██║     ██║   ██║███████╗
                ██╔══██║██╔══██╗   ██║   ██║██║     ██║   ██║██║     ██║   ██║╚════██║
                ██║  ██║██║  ██║   ██║   ██║╚██████╗╚██████╔╝███████╗╚██████╔╝███████║
                ╚═╝  ╚═╝╚═╝  ╚═╝   ╚═╝   ╚═╝ ╚═════╝ ╚═════╝ ╚══════╝ ╚═════╝ ╚══════╝
                                                                                     \s
                """);
    }

    public static void pintaTituloAdmin() {
        System.out.println();
        System.out.println();
        System.out.println("""
                ┏┓ ┓   •  •       ┓   \s
                ┣┫┏┫┏┳┓┓┏┓┓┏╋┏┓┏┓┏┫┏┓┏┓
                ┛┗┗┻┛┗┗┗┛┗┗┛┗┛ ┗┻┗┻┗┛┛""");
    }

    public static void pintaTituloCliente() {
        System.out.println("""
                ┏┓┓•      \s
                ┃ ┃┓┏┓┏┓╋┏┓
                ┗┛┗┗┗ ┛┗┗┗""");
    }

    //Pantallas de carga
    public static void pintaCerrandoSesion() {
        System.out.print("""
                ┏┓           ┓        •   \s
                ┃ ┏┓┏┓┏┓┏┓┏┓┏┫┏┓  ┏┏┓┏┓┏┓┏┓
                ┗┛┗ ┛ ┛ ┗┻┛┗┗┻┗┛  ┛┗ ┛┗┗┛┛┗""");
        for (int i = 0; i < 3; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.print("•");
        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void pintaSaliendo() {
        System.out.print("""
                ┏┓  ┓•     ┓ \s
                ┗┓┏┓┃┓┏┓┏┓┏┫┏┓
                ┗┛┗┻┗┗┗ ┛┗┗┻┗┛""");
        for (int i = 0; i < 3; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.print("•");
        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void pintaCargando() {
        System.out.print("""
                ┏┓           ┓ \s
                ┃ ┏┓┏┓┏┓┏┓┏┓┏┫┏┓
                ┗┛┗┻┛ ┗┫┗┻┛┗┗┻┗┛""");
        for (int i = 0; i < 3; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.print("•");
        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void pulsaParaContinuar() {

        System.out.print("""
                ┏┓  ┓                     •          \s
                ┃┃┓┏┃┏┏┓  ┏┓┏┓┏┓┏┓  ┏┏┓┏┓╋┓┏┓┓┏┏┓┏┓  \s
                ┣┛┗┻┗┛┗┻  ┣┛┗┻┛ ┗┻  ┗┗┛┛┗┗┗┛┗┗┻┗┻┛ •••""");
        S.nextLine();
    }
}
