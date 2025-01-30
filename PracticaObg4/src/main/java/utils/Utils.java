package utils;

import models.*;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

import static comunications.EnvioMail.enviarMensaje;
import static comunications.EnvioTelegram.enviaMensajeTelegram;
import static view.Menus.*;

public class Utils {

    private static final Scanner S = new Scanner(System.in);


    //Metodos
    //Metodo que sirve para loguearse
    public static Persona Login(Administrador admin, Cliente cliente1, Cliente cliente2, Trabajador trabajador1, Trabajador trabajador2, Trabajador trabajador3) {
        System.out.println("\n┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.print("  ➤   Introduzca su email: ");
        String emailIntro = S.nextLine();
        System.out.print("  ➤   Introduzca su contraseña: ");
        String contrasenaIntro = S.nextLine();
        System.out.print("""
                ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n""");
        if (admin != null && admin.getPersona().getEmail().equalsIgnoreCase(emailIntro) && admin.getContrasena().equals(contrasenaIntro)) {
            return admin.getPersona();
        }
        if (cliente1 != null && cliente1.getPersona().getEmail().equalsIgnoreCase(emailIntro) && cliente1.getContrasena().equals(contrasenaIntro)) {
            if (!cliente1.getPersona().isToken()) {
                System.out.println("No has validado tu cuenta, por favor valida tu cuenta.");
                return null;
            }
            return cliente1.getPersona();
        }
        if (cliente2 != null && cliente2.getPersona().getEmail().equalsIgnoreCase(emailIntro) && cliente2.getContrasena().equals(contrasenaIntro)) {
            if (!cliente2.getPersona().isToken()) {
                System.out.println("No has validado tu cuenta, por favor valida tu cuenta.");
                return null;
            }

            return cliente2.getPersona();
        }
        if (trabajador1 != null && trabajador1.getPersona().getEmail().equalsIgnoreCase(emailIntro) && trabajador1.getContrasena().equals(contrasenaIntro)) {
            return trabajador1.getPersona();
        }
        if (trabajador2 != null && trabajador2.getPersona().getEmail().equalsIgnoreCase(emailIntro) && trabajador2.getContrasena().equals(contrasenaIntro)) {
            return trabajador2.getPersona();
        }
        if (trabajador3 != null && trabajador3.getPersona().getEmail().equalsIgnoreCase(emailIntro) && trabajador3.getContrasena().equals(contrasenaIntro)) {
            return trabajador3.getPersona();
        }
        return null;
    }

    //Metodo que sirve para registrarse
    public static Cliente registroCliente(Cliente cliente1, Cliente cliente2, Trabajador trabajador1, Trabajador trabajador2, Trabajador trabajador3, Administrador admin) {
        Cliente nuevoCliente = new Cliente();
        Persona nuevaPersona = new Persona();
        int intentosToken = 3;

        System.out.print("Introduzca nombre completo: ");
        nuevaPersona.setNombreCompleto(Utils.S.nextLine());
        do {
            try {
                System.out.print("Introduzca telefono: ");
                nuevaPersona.setTelefono(Integer.parseInt(S.nextLine()));
                break;
            } catch (NumberFormatException e) {
            }
        } while (true);
        System.out.print("Introduzca ciudad: ");
        nuevaPersona.setCiudad(S.nextLine());
        System.out.print("Introduzca provincia: ");
        nuevaPersona.setProvincia(S.nextLine());
        System.out.print("Introduzca direccion: ");
        nuevaPersona.setDireccion(S.nextLine());
        nuevaPersona.setEsCliente(true);
        nuevaPersona.setEsTrabajador(false);
        nuevaPersona.setEsAdministrador(false);

        do {
            System.out.print("Introduzca email: ");
            nuevaPersona.setEmail(S.nextLine());
            if (existeEmail(cliente1, cliente2, trabajador1, trabajador2, trabajador3, admin, nuevaPersona.getEmail())) {
            }
        } while (existeEmail(cliente1, cliente2, trabajador1, trabajador2, trabajador3, admin, nuevaPersona.getEmail()));

        int token = enviaTokenRegistro(nuevaPersona.getEmail());
        int tokenIntro = -1;
        do {
            try {
                System.out.println("Introduzca el token que acaba de recibir al correo: ");
                tokenIntro = Integer.parseInt(S.nextLine());
            } catch (NumberFormatException e) {
            }

            if (tokenIntro == token) {
                nuevaPersona.setToken(true);
                break;
            }

            intentosToken--;
            if (intentosToken > 0) {
            } else {
                return null;
            }
        } while (tokenIntro != token);

        System.out.print("Introduzca contrasena: ");
        nuevoCliente.setContrasena(S.nextLine());
        nuevoCliente.setPersona(nuevaPersona);

        return nuevoCliente;
    }


    public static int enviaTokenRegistro(String email) {
        String asunto = "", contenido = "";
        int token = generaToken();

        asunto = "Le enviamos una breve verificacion, por favor introduzca el siguiente token: ";
        contenido = "Su token de verificacion es: " + token;


        if (enviarMensaje(email, asunto, contenido)) {
            System.out.println("Token enviado con exito");
        } else {
            System.out.println("Error al enviar el token");
        }

        return token;
    }

    public static int generaToken() {
        int token = 0;
        String registroTokens = "-";

        do {
            token = (int) (Math.random() * 1000000);
        } while (registroTokens.contains(String.valueOf("-" + token + "-")));
        registroTokens += token + "-";
        return token;
    }

    //Metodo para dar de alta a un trabajador
    public static Trabajador altaTrabajador(Cliente cliente1, Cliente cliente2, Trabajador trabajador1, Trabajador trabajador2, Trabajador trabajador3, Administrador admin) {
        Trabajador nuevoTrabajador = new Trabajador();
        Persona nuevaPersona = new Persona();
        String emailIntro = "";
        int intentosToken = 3;

        System.out.print("Introduzca nombre completo: ");
        nuevaPersona.setNombreCompleto(S.nextLine());
        do {
            try {
                System.out.print("Introduzca telefono: ");
                nuevaPersona.setTelefono(Integer.parseInt(S.nextLine()));
                break;
            } catch (NumberFormatException e) {
                System.out.println("Error: Introduzca un número válido para el teléfono.");
            }
        } while (true);
        System.out.print("Introduzca ciudad: ");
        nuevaPersona.setCiudad(S.nextLine());
        System.out.print("Introduzca provincia: ");
        nuevaPersona.setProvincia(S.nextLine());
        System.out.print("Introduzca direccion: ");
        nuevaPersona.setDireccion(S.nextLine());
        nuevaPersona.setEsCliente(false);
        nuevaPersona.setEsTrabajador(true);
        nuevaPersona.setEsAdministrador(false);

        do {
            System.out.print("Introduzca email: ");
            emailIntro = S.nextLine();
            if (existeEmail(cliente1, cliente2, trabajador1, trabajador2, trabajador3, admin, emailIntro)) {
                System.out.println("Email ya registrado, prueba con otro...");
            }
        } while (existeEmail(cliente1, cliente2, trabajador1, trabajador2, trabajador3, admin, emailIntro));
        int token = enviaTokenRegistro(emailIntro);
        int tokenIntro = -1;
        do {
            try {
                System.out.print("Introduzca el token que acaba de recibir al correo: ");
                tokenIntro = Integer.parseInt(S.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Error: Introduzca un número valido.");
            }
            if (tokenIntro == token) {
                nuevaPersona.setToken(true);
                nuevaPersona.setEmail(emailIntro);
                break;
            }
            intentosToken--;
            if (intentosToken > 0) {
                System.out.println("Token incorrecto. Le quedan " + intentosToken + " intentos.");
            } else {
                System.out.println("Se han agotado los intentos. El proceso ha fallado.");
            }
        } while (tokenIntro != token && intentosToken != 0);

        System.out.print("Introduzca contrasena: ");
        nuevoTrabajador.setContrasena(S.nextLine());
        nuevoTrabajador.setPersona(nuevaPersona);

        return nuevoTrabajador;
    }

    //Metodo que sirve para ver si hay ya clientes registrados
    public static boolean verificaClientesCreados(Cliente cliente1, Cliente cliente2) {
        if (cliente1 != null && cliente2 != null) {
            System.out.println("""
                    ┏┓                 ┓        ┓      ┓•                •       ┓  \s
                    ┣ ┏┓┏┓┏┓┏┓   ┓┏┏┓  ┣┓┏┓┓┏  ┏┫┏┓┏  ┏┃┓┏┓┏┓╋┏┓┏  ┏┓┏┓┏┓┓┏╋┏┓┏┓┏┫┏┓┏
                    ┗┛┛ ┛ ┗┛┛ ╻  ┗┫┗┻  ┛┗┗┻┗┫  ┗┻┗┛┛  ┗┗┗┗ ┛┗┗┗ ┛  ┛ ┗ ┗┫┗┛┗┛ ┗┻┗┻┗┛┛""");
            return false;
        }
        return true;
    }

    //Metodo que comprueba los trabajadores que hay creados
    public static boolean verificaTrabajadoresCreados(Trabajador trabajador1, Trabajador trabajador2, Trabajador trabajador3) {
        if (trabajador1 != null && trabajador2 != null && trabajador3 != null) {
            System.out.println("""
                    ┏┓                 ┓                    ┓   •   ┓               •       ┓  \s
                    ┣ ┏┓┏┓┏┓┏┓   ┓┏┏┓  ┣┓┏┓┓┏  ╋┏┓┏┓┏  ╋┏┓┏┓┣┓┏┓┓┏┓┏┫┏┓┏┓┏┓┏  ┏┓┏┓┏┓┓┏╋┏┓┏┓┏┫┏┓┏
                    ┗┛┛ ┛ ┗┛┛ ╻  ┗┫┗┻  ┛┗┗┻┗┫  ┗┛ ┗ ┛  ┗┛ ┗┻┗┛┗┻┃┗┻┗┻┗┛┛ ┗ ┛  ┛ ┗ ┗┫┗┛┗┛ ┗┻┗┻┗┛┛""");

            return false;
        }
        return true;
    }

    //Metodo que dice si un email existe
    public static boolean existeEmail(Cliente cliente1, Cliente cliente2, Trabajador trabajador1, Trabajador trabajador2, Trabajador trabajador3, Administrador admin, String email) {
        if (admin != null && admin.getPersona().getEmail().equals(email)) return true;
        if (trabajador1 != null && trabajador1.getPersona().getEmail().equals(email)) return true;
        if (trabajador2 != null && trabajador2.getPersona().getEmail().equals(email)) return true;
        if (trabajador3 != null && trabajador3.getPersona().getEmail().equals(email)) return true;
        if (cliente1 != null && cliente1.getPersona().getEmail().equals(email)) return true;
        if (cliente2 != null && cliente2.getPersona().getEmail().equals(email)) return true;
        return false;
    }

    //Metodo que te dice que tipo de persona está usando el software
    public static String rolPersona(Persona persona) {
        String rol = "";
        if (persona.isEsAdministrador()) rol = "admin";
        if (persona.isEsCliente()) rol = "cliente";
        if (persona.isEsTrabajador()) rol = "trabajador";
        return rol.toLowerCase();
    }

    //Metodo para cambiar alguna información de los trabajadores
    public static void modificaTrabajador(String op, Trabajador trabajador, Cliente c1, Cliente c2, Trabajador t1, Trabajador t2, Trabajador t3, Administrador admin) {
        if (op.equals("1") || op.equals("2")) {
            System.out.print("Introduzca el nombre: ");
            trabajador.getPersona().setNombreCompleto(S.nextLine());
        }
        if (op.equals("1") || op.equals("3")) {
            String emailIntro = "";
            int intentosToken = 3;
            do {
                System.out.print("Introduzca email: ");
                emailIntro = S.nextLine();
                if (existeEmail(c1, c2, t1, t2, t3, admin, emailIntro)) {
                    System.out.println("Email ya registrado, prueba con otro...");
                }
            } while (existeEmail(c1, c2, t1, t2, t3, admin, emailIntro));
            int token = enviaTokenRegistro(emailIntro);
            int tokenIntro = -1;
            do {
                try {
                    System.out.print("Introduzca el token que acaba de recibir al correo: ");
                    tokenIntro = Integer.parseInt(S.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Error: Introduzca un número valido.");
                }
                if (tokenIntro == token) {
                    trabajador.getPersona().setToken(true);
                    trabajador.getPersona().setEmail(emailIntro);
                    break;
                }
                intentosToken--;
                if (intentosToken > 0) {
                    System.out.println("Token incorrecto. Le quedan " + intentosToken + " intentos.");
                } else {
                    System.out.println("Se han agotado los intentos. El proceso ha fallado.");
                }
            } while (tokenIntro != token && intentosToken != 0);
        }
        if (op.equals("1") || op.equals("4")) {
            do {
                try {
                    System.out.print("Introduzca telefono: ");
                    trabajador.getPersona().setTelefono(Integer.parseInt(S.nextLine()));
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Error: Introduzca un número válido para el teléfono.");
                }
            } while (true);
        }
        if (op.equals("1") || op.equals("5")) {
            System.out.print("Introduzca la ciudad: ");
            trabajador.getPersona().setCiudad(S.nextLine());
        }
        if (op.equals("1") || op.equals("6")) {
            System.out.print("Introduzca la provincia: ");
            trabajador.getPersona().setDireccion(S.nextLine());
        }
        if (op.equals("1") || op.equals("7")) {
            System.out.print("Introduzca la dirección: ");
            trabajador.getPersona().setDireccion(S.nextLine());
        }
        if (op.equals("1") || op.equals("8")) {
            System.out.print("Introduzca la contraseña: ");
            trabajador.setContrasena(S.nextLine());
        }
        if (op.equals("9")) {
            pintaSaliendo();
        }
    }

    //Metodo para saber qué persona hay que modificar
    public static void modificadorTrabajadores(Trabajador trabajador1, Trabajador trabajador2, Trabajador trabajador3, Persona personaLogeada, Administrador admin, Cliente c1, Cliente c2) {
        String opModificaTrabajador = menuModificaTrabajador();
        if (trabajador1 != null && trabajador1.getPersona().getEmail().equals(personaLogeada.getEmail()))
            modificaTrabajador(opModificaTrabajador, trabajador1, c1, c2, trabajador1, trabajador2, trabajador3, admin);
        if (trabajador2 != null && trabajador2.getPersona().getEmail().equals(personaLogeada.getEmail()))
            modificaTrabajador(opModificaTrabajador, trabajador2, c1, c2, trabajador1, trabajador2, trabajador3, admin);
        if (trabajador3 != null && trabajador3.getPersona().getEmail().equals(personaLogeada.getEmail()))
            modificaTrabajador(opModificaTrabajador, trabajador3, c1, c2, trabajador1, trabajador2, trabajador3, admin);
    }

    //Metodo para modificar información de los clientes
    public static void modificaCliente(String op, Cliente cliente, Cliente cliente2, Trabajador t1, Trabajador t2, Trabajador t3, Administrador admin) {
        /*Cliente nuevoCliente;*/
        int intentosToken = 3;

        if (op.equals("1") || op.equals("2")) {
            System.out.print("Introduzca el nombre: ");
            cliente.getPersona().setNombreCompleto(S.nextLine());
        }
        if (op.equals("1") || op.equals("3")) {
            String emailIntro = "";
            do {
                System.out.print("Introduzca email: ");
                emailIntro = S.nextLine();
                if (existeEmail(cliente, cliente2, t1, t2, t3, admin, emailIntro)) {
                    System.out.println("Email ya registrado, prueba con otro...");
                }
            } while (existeEmail(cliente, cliente2, t1, t2, t3, admin, emailIntro));
            int token = enviaTokenRegistro(emailIntro);
            int tokenIntro = -1;
            do {
                try {
                    System.out.print("Introduzca el token que acaba de recibir al correo: ");
                    tokenIntro = Integer.parseInt(S.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Error: Introduzca un número valido.");
                }
                if (tokenIntro == token) {
                    cliente.getPersona().setToken(true);
                    cliente.getPersona().setEmail(emailIntro);
                    break;
                }
                intentosToken--;
                if (intentosToken > 0) {
                    System.out.println("Token incorrecto. Le quedan " + intentosToken + " intentos.");
                } else {
                    System.out.println("Se han agotado los intentos. El proceso ha fallado.");
                }
            } while (tokenIntro != token && intentosToken != 0);

        }
        if (op.equals("1") || op.equals("4")) {
            do {
                try {
                    System.out.print("Introduzca telefono: ");
                    cliente.getPersona().setTelefono(Integer.parseInt(S.nextLine()));
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Error: Introduzca un número válido para el teléfono.");
                }
            } while (true);
        }
        if (op.equals("1") || op.equals("5")) {
            System.out.print("Introduzca la ciudad: ");
            cliente.getPersona().setCiudad(S.nextLine());
        }
        if (op.equals("1") || op.equals("6")) {
            System.out.print("Introduzca la provincia: ");
            cliente.getPersona().setDireccion(S.nextLine());
        }
        if (op.equals("1") || op.equals("7")) {
            System.out.print("Introduzca la dirección: ");
            cliente.getPersona().setDireccion(S.nextLine());
        }
        if (op.equals("1") || op.equals("8")) {
            System.out.print("Introduzca la contraseña: ");
            cliente.setContrasena(S.nextLine());
        }
        if (op.equals("9")) {
            pintaSaliendo();
        }
    }

    //Metodo para saber qué cliente hay que cambiar
    public static void modificadorClientes(Cliente cliente1, Cliente cliente2, Persona personaLogeada, Trabajador trabajador1, Trabajador trabajador2, Trabajador trabajador3, Administrador admin) {
        String opModificaCliente = menuModificaCliente();
        if (cliente1 != null && cliente1.getPersona().getEmail().equals(personaLogeada.getEmail()))
            modificaCliente(opModificaCliente, cliente1, cliente2, trabajador1, trabajador2, trabajador3, admin);
        if (cliente2 != null && cliente2.getPersona().getEmail().equals(personaLogeada.getEmail()))
            modificaCliente(opModificaCliente, cliente2, cliente1, trabajador1, trabajador2, trabajador3, admin);
    }

    //Metodo para cambiar información de los libros
    public static void modificaLibros(String op, Producto libro) {
        if (op.equals("1") || op.equals("2")) {
            System.out.print("Introduzca el nombre del libro: ");
            libro.setNombre(S.nextLine());
        }
        if (op.equals("1") || op.equals("3")) {
            System.out.print("Introduzca la descripción del libro: ");
            libro.setDescripcion(S.nextLine());
        }
        if (op.equals("1") || op.equals("4")) {
            do {
                try {
                    System.out.print("Introduzca el precio del libro: ");
                    libro.setPrecio(Float.parseFloat(S.nextLine()));
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Error: Introduzca un número valido para el precio");
                }
            } while (true);
        }
        if (op.equals("1") || op.equals("5")) {
            do {
                try {
                    System.out.print("Introduzca el stock del libro: ");
                    libro.setStock(Integer.parseInt(S.nextLine()));
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Error: Introduzca un número valido para el stock");
                }
            } while (true);

        }
        if (op.equals("1") || op.equals("6")) {
            System.out.print("Introduzca el autor del libro: ");
            libro.setAutor(S.nextLine());
        }
        if (op.equals("1") || op.equals("7")) {
            System.out.print("Introduzca la editorial del libro: ");
            libro.setEditorial(S.nextLine());
        }
        if (op.equals("1") || op.equals("8")) {
            System.out.print("Introduzca el género del libro: ");
            libro.setGenero(S.nextLine());
        }
        if (op.equals("1") || op.equals("9")) {
            System.out.print("Introduzca el idioma del libro: ");
            libro.setIdioma(S.nextLine());
        }
        if (op.equals("10")) {
            pintaSaliendo();
        }
    }

    /*//Metodo para dar formato a la fecha
    public static String formateaFecha(LocalDate fecha) {
        //define el formato deseado
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        //devuelve la fecha en el formato especificado
        return fecha.format(formato);
    }*/

    public static void modificaEstadoPedido(Cliente c1, Cliente c2) {
        int idPedidoIntro = 0;
        String estadoNuevo = "", incluyeComentario, comentario = "", cambiarFecha = "";
        LocalDate fechaIntro;
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        // Obtener ID del pedido
        do {
            try {
                System.out.println("Introduzca el id del pedido que desea cambiar el estado: ");
                idPedidoIntro = Integer.parseInt(S.nextLine());
                if (!pedidoExiste(c1, c2, idPedidoIntro)) {
                    System.out.println("\nEste pedido no existe");
                    pulsaParaContinuar();
                    return;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Error: Introduzca un número valido");
            }
        } while (true);

        // Cambiar estado del pedido
        estadoNuevo = menuCambiaEstadoPedidos();
        actualizarEstadoPedidos(c1, c2, idPedidoIntro, estadoNuevo);

        // Añadir comentario al pedido
        do {
            System.out.print("¿Deseas añadir un comentario a este pedido? (S/N): ");
            incluyeComentario = S.nextLine();
        } while (!incluyeComentario.equalsIgnoreCase("s") && !incluyeComentario.equalsIgnoreCase("n"));

        if (incluyeComentario.equalsIgnoreCase("s")) {
            System.out.print("Introduzca el comentario: ");
            comentario = S.nextLine();
            actualizarComentarioPedidos(c1, c2, idPedidoIntro, comentario);
        }

        // Cambiar fecha estimada del pedido
        do {
            System.out.print("¿Quiere cambiar la fecha estimada de este pedido? (S/N): ");
            cambiarFecha = S.nextLine();
        } while (!cambiarFecha.equalsIgnoreCase("s") && !cambiarFecha.equalsIgnoreCase("n"));

        if (cambiarFecha.equalsIgnoreCase("s")) {
            do {
                try {
                    System.out.print("Introduzca la fecha que desea (DD-MM-YYYY): ");
                    fechaIntro = LocalDate.parse(S.nextLine(), formato);
                    break;
                } catch (DateTimeParseException e) {
                    System.out.println("Error: Introduzca una fecha valida");
                }
            } while (true);
            actualizarFechaPedido(c1, c2, idPedidoIntro, fechaIntro);
        }
    }

    private static boolean pedidoExiste(Cliente c1, Cliente c2, int idPedidoIntro) {
        boolean existeEnC1 = false;
        boolean existeEnC2 = false;

        if (c1 != null) {
            if (c1.getPedido1() != null && c1.getPedido1().getId() == idPedidoIntro) {
                existeEnC1 = true;
            } else if (c1.getPedido2() != null && c1.getPedido2().getId() == idPedidoIntro) {
                existeEnC1 = true;
            }
        }

        if (c2 != null) {
            if (c2.getPedido1() != null && c2.getPedido1().getId() == idPedidoIntro) {
                existeEnC2 = true;
            } else if (c2.getPedido2() != null && c2.getPedido2().getId() == idPedidoIntro) {
                existeEnC2 = true;
            }
        }

        if (existeEnC1) {
            return true;
        } else if (existeEnC2) {
            return true;
        } else {
            return false;
        }
    }


    private static void actualizarEstadoPedidos(Cliente c1, Cliente c2, int idPedidoIntro, String estadoNuevo) {
        if (c1 != null) {
            if (c1.getPedido1() != null && c1.getPedido1().getId() == idPedidoIntro)
                c1.getPedido1().setEstado(estadoNuevo);
            if (c1.getPedido2() != null && c1.getPedido2().getId() == idPedidoIntro)
                c1.getPedido2().setEstado(estadoNuevo);
        }

        if (c2 != null) {
            if (c2.getPedido1() != null && c2.getPedido1().getId() == idPedidoIntro)
                c2.getPedido1().setEstado(estadoNuevo);
            if (c2.getPedido2() != null && c2.getPedido2().getId() == idPedidoIntro)
                c2.getPedido2().setEstado(estadoNuevo);
        }
    }

    private static void actualizarComentarioPedidos(Cliente c1, Cliente c2, int idPedidoIntro, String comentario) {
        if (c1 != null) {
            if (c1.getPedido1() != null && c1.getPedido1().getId() == idPedidoIntro)
                c1.getPedido1().setComentario(comentario);
            if (c1.getPedido2() != null && c1.getPedido2().getId() == idPedidoIntro)
                c1.getPedido2().setComentario(comentario);
        }

        if (c2 != null) {
            if (c2.getPedido1() != null && c2.getPedido1().getId() == idPedidoIntro)
                c2.getPedido1().setComentario(comentario);
            if (c2.getPedido2() != null && c2.getPedido2().getId() == idPedidoIntro)
                c2.getPedido2().setComentario(comentario);
        }
    }

    private static void actualizarFechaPedido(Cliente c1, Cliente c2, int idPedidoIntro, LocalDate fecha) {
        if (c1 != null) {
            if (c1.getPedido1() != null && c1.getPedido1().getId() == idPedidoIntro)
                c1.getPedido1().setFechaEntregaEstimada(fecha);
            if (c1.getPedido2() != null && c1.getPedido2().getId() == idPedidoIntro)
                c1.getPedido2().setFechaEntregaEstimada(fecha);
        }

        if (c2 != null) {
            if (c2.getPedido1() != null && c2.getPedido1().getId() == idPedidoIntro)
                c2.getPedido1().setFechaEntregaEstimada(fecha);
            if (c2.getPedido2() != null && c2.getPedido2().getId() == idPedidoIntro)
                c2.getPedido2().setFechaEntregaEstimada(fecha);
        }
    }


    //Metodo para realizar un pedido
    public static void realizaPedido(Cliente c1, Cliente c2, Trabajador t1, Trabajador t2, Trabajador t3, Persona personaLogeada, Producto libro1, Producto libro2, Producto libro3, Producto libro4, Producto articulo1, Producto articulo2, Producto articulo3, Producto articulo4) {

        if (c1 != null && c1.getPersona().getEmail().equals(personaLogeada.getEmail()))
            asignaPedidoCliente(c1, libro1, libro2, libro3, libro4, articulo1, articulo2, articulo3, articulo4, t1, t2, t3);
        if (c2 != null && c2.getPersona().getEmail().equals(personaLogeada.getEmail()))
            asignaPedidoCliente(c2, libro1, libro2, libro3, libro4, articulo1, articulo2, articulo3, articulo4, t1, t2, t3);
    }

    public static void asignaPedidoCliente(Cliente cliente, Producto libro1, Producto libro2, Producto libro3, Producto libro4, Producto articulo1, Producto articulo2, Producto articulo3, Producto articulo4, Trabajador t1, Trabajador t2, Trabajador t3) {
        Pedido pedidoNuevo = new Pedido();
        String productoSeleccionado = "";
        int unidadesProductos = 0;
        float sumaPrecioFinalPedido = 0;

        if (cliente.getPedido1() != null && cliente.getPedido2() != null) {
            System.out.println("No puedes realizar más de 2 pedidos");
            return;
        }
        if (cliente.getPedido1() == null || cliente.getPedido2() == null) {
            do {
                productoSeleccionado = menuSeleccionaProductos(libro1, libro2, libro3, libro4, articulo1, articulo2, articulo3, articulo4);
                switch (productoSeleccionado) {
                    case "1":
                        logicaPedidos(libro1, pedidoNuevo);
                        break;
                    case "2":
                        logicaPedidos(libro2, pedidoNuevo);
                        break;
                    case "3":
                        logicaPedidos(libro3, pedidoNuevo);
                        break;
                    case "4":
                        logicaPedidos(libro4, pedidoNuevo);
                        break;
                    case "5":
                        logicaPedidos(articulo1, pedidoNuevo);
                        break;
                    case "6":
                        logicaPedidos(articulo2, pedidoNuevo);
                        break;
                    case "7":
                        logicaPedidos(articulo3, pedidoNuevo);
                        break;
                    case "8":
                        logicaPedidos(articulo4, pedidoNuevo);
                        break;
                }
            } while (!productoSeleccionado.equalsIgnoreCase("9") && pedidoNuevo.getProducto3() == null);
        }
        pedidoNuevo.setNombreCliente(cliente.getPersona().getNombreCompleto());
        pedidoNuevo.setTelefonoCliente(cliente.getPersona().getTelefono());
        pedidoNuevo.setEmailCliente(cliente.getPersona().getEmail());
        pedidoNuevo.setPrecioFinal(calculaPrecioFinal(pedidoNuevo));
        pedidoNuevo.setDireccion(cliente.getPersona().getDireccion());
        pedidoNuevo.setCiudad(cliente.getPersona().getCiudad());
        pedidoNuevo.setProvincia(cliente.getPersona().getProvincia());
        pedidoNuevo.setEstado("Recién creado");
        pedidoNuevo.setComentario("Pedido nuevo");
        pedidoNuevo.setFechaPedido(LocalDate.now());
        pedidoNuevo.setFechaEntregaEstimada(LocalDate.now().plusDays(5));
        pedidoNuevo.setPrecioFinal(calculaPrecioFinal(pedidoNuevo));
        if (cliente.getPedido1() == null) cliente.setPedido1(pedidoNuevo);
        else if (cliente.getPedido2() == null) cliente.setPedido2(pedidoNuevo);
        pintaCargando();
        enviaTelegram(pedidoNuevo, cliente);
        contactaCliente(cliente, pedidoNuevo);
        asignaPedidoTrabajador(t1, t2, t3, pedidoNuevo, cliente);
    }

    private static void asignaPedidoTrabajador(Trabajador t1, Trabajador t2, Trabajador t3, Pedido pedidoNuevo, Cliente cliente) {

        int pedidosTrabajador1 = 0, pedidosTrabajador2 = 0, pedidosTrabajador3 = 0;

        if (t1 != null) {
            pedidosTrabajador1 = (t1.getPedido1() != null ? 1 : 0) + (t1.getPedido2() != null ? 1 : 0);
        }
        if (t2 != null) {
            pedidosTrabajador2 = (t2.getPedido1() != null ? 1 : 0) + (t2.getPedido2() != null ? 1 : 0);
        }
        if (t3 != null) {
            pedidosTrabajador3 = (t3.getPedido1() != null ? 1 : 0) + (t3.getPedido2() != null ? 1 : 0);
        }

        if (pedidosTrabajador1 <= pedidosTrabajador2 && pedidosTrabajador1 <= pedidosTrabajador3) {
            contactaTrabajador(t1, pedidoNuevo, cliente);
            if (t1.getPedido1() == null) {
                t1.setPedido1(pedidoNuevo);
                pedidoNuevo.setAsignadoAUnTrabajador(true);
            } else if (t1.getPedido2() == null) {
                t1.setPedido2(pedidoNuevo);
                pedidoNuevo.setAsignadoAUnTrabajador(true);
            }
        } else if (pedidosTrabajador2 <= pedidosTrabajador1 && pedidosTrabajador2 <= pedidosTrabajador3) {
            contactaTrabajador(t2, pedidoNuevo, cliente);
            if (t2.getPedido1() == null) {
                t2.setPedido1(pedidoNuevo);
                pedidoNuevo.setAsignadoAUnTrabajador(true);
            } else if (t2.getPedido2() == null) {
                t2.setPedido2(pedidoNuevo);
                pedidoNuevo.setAsignadoAUnTrabajador(true);
            }
        } else if (t3 != null && pedidosTrabajador3 <= pedidosTrabajador1 && pedidosTrabajador3 <= pedidosTrabajador2) {
            contactaTrabajador(t3, pedidoNuevo, cliente);
            if (t3.getPedido1() == null) {
                t3.setPedido1(pedidoNuevo);
                pedidoNuevo.setAsignadoAUnTrabajador(true);
            } else if (t3.getPedido2() == null) {
                t3.setPedido2(pedidoNuevo);
                pedidoNuevo.setAsignadoAUnTrabajador(true);
            }
        } else {
            System.out.println("No hay trabajadores disponibles para asignar el pedido.");
            pedidoNuevo.setAsignadoAUnTrabajador(false);
        }
    }


    public static void asignaPedidosAdmin(Cliente c1, Cliente c2, Trabajador t1, Trabajador t2, Trabajador t3) {
        String emailTrabajadorIntro = "";

        if (c1 != null) {
            if (c1.getPedido1() != null && !c1.getPedido1().isAsignadoAUnTrabajador()) {
                System.out.println(c1.getPedido1().pintaPedido(true));
                do {
                    System.out.print("A quien quiere asignar este pedido (introduzca email del trabajador): ");
                    emailTrabajadorIntro = S.nextLine();
                } while ((t1 != null && !emailTrabajadorIntro.equalsIgnoreCase(t1.getPersona().getEmail())) && (t2 != null && !emailTrabajadorIntro.equalsIgnoreCase(t2.getPersona().getEmail())) && (t3 != null && !emailTrabajadorIntro.equalsIgnoreCase(t3.getPersona().getEmail())));

                if (t1 != null && emailTrabajadorIntro.equalsIgnoreCase(t1.getPersona().getEmail())) {
                    if (t1.getPedido1() == null) t1.setPedido1(c1.getPedido1());
                    else if (t1.getPedido2() == null) t1.setPedido2(c1.getPedido1());
                } else if (t2 != null && emailTrabajadorIntro.equalsIgnoreCase(t2.getPersona().getEmail())) {
                    if (t2.getPedido1() == null) t2.setPedido1(c1.getPedido1());
                    else if (t2.getPedido2() == null) t2.setPedido2(c1.getPedido1());
                } else if (t3 != null && emailTrabajadorIntro.equalsIgnoreCase(t3.getPersona().getEmail())) {
                    if (t3.getPedido1() == null) t3.setPedido1(c1.getPedido1());
                    else if (t3.getPedido2() == null) t3.setPedido2(c1.getPedido1());
                }
            }

            if (c1.getPedido2() != null && !c1.getPedido2().isAsignadoAUnTrabajador()) {
                System.out.println(c1.getPedido2().pintaPedido(true));
                do {
                    System.out.print("A quien quiere asignar este pedido (introduzca email del trabajador): ");
                    emailTrabajadorIntro = S.nextLine();
                } while ((t1 != null && !emailTrabajadorIntro.equalsIgnoreCase(t1.getPersona().getEmail())) && (t2 != null && !emailTrabajadorIntro.equalsIgnoreCase(t2.getPersona().getEmail())) && (t3 != null && !emailTrabajadorIntro.equalsIgnoreCase(t3.getPersona().getEmail())));

                if (t1 != null && emailTrabajadorIntro.equalsIgnoreCase(t1.getPersona().getEmail())) {
                    if (t1.getPedido1() == null) t1.setPedido1(c1.getPedido2());
                    else if (t1.getPedido2() == null) t1.setPedido2(c1.getPedido2());
                } else if (t2 != null && emailTrabajadorIntro.equalsIgnoreCase(t2.getPersona().getEmail())) {
                    if (t2.getPedido1() == null) t2.setPedido1(c1.getPedido2());
                    else if (t2.getPedido2() == null) t2.setPedido2(c1.getPedido2());
                } else if (t3 != null && emailTrabajadorIntro.equalsIgnoreCase(t3.getPersona().getEmail())) {
                    if (t3.getPedido1() == null) t3.setPedido1(c1.getPedido2());
                    else if (t3.getPedido2() == null) t3.setPedido2(c1.getPedido2());
                }
            }
        }

        if (c2 != null) {
            if (c2.getPedido1() != null && !c2.getPedido1().isAsignadoAUnTrabajador()) {
                System.out.println(c2.getPedido1().pintaPedido(true));
                do {
                    System.out.print("A quien quiere asignar este pedido (introduzca email del trabajador): ");
                    emailTrabajadorIntro = S.nextLine();
                } while ((t1 != null && !emailTrabajadorIntro.equalsIgnoreCase(t1.getPersona().getEmail())) && (t2 != null && !emailTrabajadorIntro.equalsIgnoreCase(t2.getPersona().getEmail())) && (t3 != null && !emailTrabajadorIntro.equalsIgnoreCase(t3.getPersona().getEmail())));

                if (t1 != null && emailTrabajadorIntro.equalsIgnoreCase(t1.getPersona().getEmail())) {
                    if (t1.getPedido1() == null) t1.setPedido1(c2.getPedido1());
                    else if (t1.getPedido2() == null) t1.setPedido2(c2.getPedido1());
                } else if (t2 != null && emailTrabajadorIntro.equalsIgnoreCase(t2.getPersona().getEmail())) {
                    if (t2.getPedido1() == null) t2.setPedido1(c2.getPedido1());
                    else if (t2.getPedido2() == null) t2.setPedido2(c2.getPedido1());
                } else if (t3 != null && emailTrabajadorIntro.equalsIgnoreCase(t3.getPersona().getEmail())) {
                    if (t3.getPedido1() == null) t3.setPedido1(c2.getPedido1());
                    else if (t3.getPedido2() == null) t3.setPedido2(c2.getPedido1());
                }
            }

            if (c2.getPedido2() != null && !c2.getPedido2().isAsignadoAUnTrabajador()) {
                System.out.println(c2.getPedido2().pintaPedido(true));
                do {
                    System.out.print("A quien quiere asignar este pedido (introduzca email del trabajador): ");
                    emailTrabajadorIntro = S.nextLine();
                } while ((t1 != null && !emailTrabajadorIntro.equalsIgnoreCase(t1.getPersona().getEmail())) && (t2 != null && !emailTrabajadorIntro.equalsIgnoreCase(t2.getPersona().getEmail())) && (t3 != null && !emailTrabajadorIntro.equalsIgnoreCase(t3.getPersona().getEmail())));

                if (t1 != null && emailTrabajadorIntro.equalsIgnoreCase(t1.getPersona().getEmail())) {
                    if (t1.getPedido1() == null) t1.setPedido1(c2.getPedido2());
                    else if (t1.getPedido2() == null) t1.setPedido2(c2.getPedido2());
                } else if (t2 != null && emailTrabajadorIntro.equalsIgnoreCase(t2.getPersona().getEmail())) {
                    if (t2.getPedido1() == null) t2.setPedido1(c2.getPedido2());
                    else if (t2.getPedido2() == null) t2.setPedido2(c2.getPedido2());
                } else if (t3 != null && emailTrabajadorIntro.equalsIgnoreCase(t3.getPersona().getEmail())) {
                    if (t3.getPedido1() == null) t3.setPedido1(c2.getPedido2());
                    else if (t3.getPedido2() == null) t3.setPedido2(c2.getPedido2());
                }
            }
        }
    }


    public static void contactaTrabajador(Trabajador trabajador, Pedido pedidoNuevo, Cliente cliente) {
        if (trabajador != null && pedidoNuevo != null) {
            String asunto = "Pedido nuevo asignado";
            String contenido = pedidoNuevo.pintaPedido(true);

            if (trabajador.getPersona() != null && enviarMensaje(trabajador.getPersona().getEmail(), asunto, contenido)) {
                System.out.println("Su pedido ya ha sido enviado a un trabajador");
            } else {
                System.out.println("Error al enviar el pedido a un trabajador");
            }
        } else {
            System.out.println("No se pudo contactar al trabajador: trabajador o pedido son null.");
        }
    }


    public static void contactaCliente(Cliente cliente, Pedido pedidoNuevo) {
        if (pedidoNuevo != null) {
            String asunto = "", contenido = "";

            asunto = "Su pedido ha sido creado...";
            contenido = pedidoNuevo.pintaPedido(false);

            if (enviarMensaje(cliente.getPersona().getEmail(), asunto, contenido)) {
                System.out.println("\nSe le ha mandado un correo al email con toda la información del pedido");
            } else {
                System.out.println("Error al enviar la informacion del pedido al cliente");
            }
        }
    }

    /*public static void enviaTelegram(Pedido pedidoNuevo, Cliente cliente) {
        if (pedidoNuevo != null) {
            enviaMensajeTelegram("Nuevo pedido:");
            enviaMensajeTelegram(pedidoNuevo.pintaPedido(true));
        }
    }*/

    public static void enviaTelegram(Pedido pedidoNuevo, Cliente cliente) {
        if (pedidoNuevo != null) {
            enviaMensajeTelegram(encodeMessage("Nuevo pedido:"));
            enviaMensajeTelegram(encodeMessage(pedidoNuevo.pintaPedido(true)));
        }
    }

    // Método para codificar el mensaje en formato URL
    public static String encodeMessage(String mensaje) {
        try {
            return URLEncoder.encode(mensaje, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return ""; // En caso de error, devuelve una cadena vacía
        }
    }


    public static float calculaPrecioFinal(Pedido pedidoNuevo) {
        float sumaPrecioFinalPedido = 0;

        if (pedidoNuevo.getProducto1() != null) {
            sumaPrecioFinalPedido += (float) (pedidoNuevo.getProducto1().getPrecio() * pedidoNuevo.getCantidadProducto1());
        }
        if (pedidoNuevo.getProducto2() != null) {
            sumaPrecioFinalPedido += (float) (pedidoNuevo.getProducto2().getPrecio() * pedidoNuevo.getCantidadProducto2());
        }
        if (pedidoNuevo.getProducto3() != null) {
            sumaPrecioFinalPedido += (float) (pedidoNuevo.getProducto3().getPrecio() * pedidoNuevo.getCantidadProducto3());
        }

        return sumaPrecioFinalPedido;
    }


    public static void logicaPedidos(Producto producto, Pedido pedido) {
        int unidadesProductos = 0;
        if (producto.getStock() > 0) {
            do {
                try {
                    System.out.println("Cuantas unidades desea comprar? (Maximo: " + producto.getStock() + ")");
                    unidadesProductos = Integer.parseInt(S.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Error: Introduzca un número valido");
                }
                if (unidadesProductos > producto.getStock() || unidadesProductos < 0)
                    System.out.println("Error: Introduzca una cantidad dentro de los valores");
            } while (unidadesProductos > producto.getStock() || unidadesProductos < 0);
            producto.setStock(producto.getStock() - unidadesProductos);

            if (pedido.getProducto1() == null) {
                pedido.setProducto1(producto);
                pedido.setCantidadProducto1(unidadesProductos);
            } else if (pedido.getProducto2() == null) {
                pedido.setProducto2(producto);
                pedido.setCantidadProducto2(unidadesProductos);
            } else if (pedido.getProducto3() == null) {
                pedido.setProducto3(producto);
                pedido.setCantidadProducto3(unidadesProductos);
            }
        } else {
            System.out.println("De este producto ya no queda stock, disculpe las molestias");
        }

    }


    //Metodo que cambia la información de los articulos
    public static void modificaArticulos(String op, Producto articulo) {
        if (op.equals("1") || op.equals("2")) {
            System.out.print("Introduzca nombre del articulo: ");
            articulo.setNombre(S.nextLine());
        }
        if (op.equals("1") || op.equals("3")) {
            System.out.print("Introduzca la descripción del articulo: ");
            articulo.setDescripcion(S.nextLine());
        }
        if (op.equals("1") || op.equals("4")) {
            do {
                try {
                    System.out.print("Introduzca el precio del libro: ");
                    articulo.setPrecio(Float.parseFloat(S.nextLine()));
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Error: Introduzca un número valido para el precio");
                }
            } while (true);
        }
        if (op.equals("1") || op.equals("5")) {
            do {
                try {
                    System.out.print("Introduzca el stock del libro: ");
                    articulo.setStock(Integer.parseInt(S.nextLine()));
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Error: Introduzca un número valido para el stock");
                }
            } while (true);
        }
        if (op.equals("1") || op.equals("6")) {
            System.out.print("Introduzca la marca del articulo: ");
            articulo.setMarca(S.nextLine());
        }
        if (op.equals("1") || op.equals("7")) {
            do {
                try {
                    System.out.print("Introduzca unidades que contiene el articulo: ");
                    articulo.setUnidades(Integer.parseInt(S.nextLine()));
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Error: Introduzca un número valido para las unidades");
                }
            } while (true);
        }
        if (op.equals("1") || op.equals("8")) {
            System.out.print("Introduzca el color del articulo: ");
            articulo.setColor(S.nextLine());
        }
        if (op.equals("9")) {
            pintaSaliendo();
        }
    }

    //Metodo para saber que libro has seleccionado
    public static void modificadorProductos(Producto libro1, Producto libro2, Producto libro3, Producto libro4, Producto articulo1, Producto articulo2, Producto articulo3, Producto articulo4, boolean esTrabajador) {
        String opModificaProductos, opModifica;
        do {
            opModificaProductos = menuSeleccionaProductos(libro1, libro2, libro3, libro4, articulo1, articulo2, articulo3, articulo4);
            switch (opModificaProductos) {
                case "1":
                    System.out.println("Ha seleccionado este libro: ");
                    System.out.println(libro1.pintaLibros(esTrabajador));
                    pulsaParaContinuar();
                    do {
                        opModifica = menuModificaLibros();
                        modificaLibros(opModifica, libro1);
                    } while (!opModifica.equals("10"));
                    break;
                case "2":
                    System.out.println("Ha seleccionado este libro: ");
                    System.out.println(libro2.pintaLibros(esTrabajador));
                    pulsaParaContinuar();
                    do {
                        opModifica = menuModificaLibros();
                        modificaLibros(opModifica, libro2);
                    } while (!opModifica.equals("10"));
                    break;
                case "3":
                    System.out.println("Ha seleccionado este libro: ");
                    System.out.println(libro3.pintaLibros(esTrabajador));
                    pulsaParaContinuar();
                    do {
                        opModifica = menuModificaLibros();
                        modificaLibros(opModifica, libro3);
                    } while (!opModifica.equals("10"));
                    break;
                case "4":
                    System.out.println("Ha seleccionado este libro: ");
                    System.out.println(libro4.pintaLibros(esTrabajador));
                    pulsaParaContinuar();
                    do {
                        opModifica = menuModificaLibros();
                        modificaLibros(opModifica, libro4);
                    } while (!opModifica.equals("10"));
                    break;
                case "5":
                    System.out.println("Ha seleccionado este articulo: ");
                    System.out.println(articulo1.pintaArticulos(esTrabajador));
                    pulsaParaContinuar();
                    do {
                        opModifica = menuModificaArticulos();
                        modificaArticulos(opModifica, articulo1);
                    } while (!opModifica.equals("9"));

                    break;
                case "6":
                    System.out.println("Ha seleccionado este articulo: ");
                    System.out.println(articulo2.pintaArticulos(esTrabajador));
                    pulsaParaContinuar();
                    do {
                        opModifica = menuModificaArticulos();
                        modificaArticulos(opModifica, articulo2);
                    } while (!opModifica.equals("9"));
                    break;
                case "7":
                    System.out.println("Ha seleccionado este articulo: ");
                    System.out.println(articulo3.pintaArticulos(esTrabajador));
                    pulsaParaContinuar();
                    do {
                        opModifica = menuModificaArticulos();
                        modificaArticulos(opModifica, articulo3);
                    } while (!opModifica.equals("9"));
                    break;
                case "8":
                    System.out.println("Ha seleccionado este articulo: ");
                    System.out.println(articulo4.pintaArticulos(esTrabajador));
                    pulsaParaContinuar();
                    do {
                        opModifica = menuModificaArticulos();
                        modificaArticulos(opModifica, articulo4);
                    } while (!opModifica.equals("9"));
                    break;
                case "9":
                    pintaSaliendo();
                    break;
            }
        } while (!opModificaProductos.equals("9"));
    }
}
