package models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Pedido {

    //Atributos
    private int id; //Excepcion
    private String direccion;
    private String ciudad;
    private String provincia;
    private String estado;
    private String comentario;
    private String nombreCliente;
    private String emailCliente;
    private LocalDate fechaPedido;
    private LocalDate fechaEntregaEstimada;
    private float precioFinal; //Excepcion
    private Producto producto1;
    private Producto producto2;
    private Producto producto3;
    private int telefonoCliente;
    private int cantidadProducto1;
    private int cantidadProducto2;
    private int cantidadProducto3;
    private boolean asignadoAUnTrabajador;

    //Atributo estatico
    private static String idGenerados = "";

    //Constructores
    public Pedido() {
        this.id = generaIdUnico();
        this.producto1 = null;
        this.producto2 = null;
        this.producto3 = null;
    }

    //Constructor con 3 productos
    public Pedido(String direccion, String ciudad, String provincia, String estado, String comentario, LocalDate fechaPedido, LocalDate fechaEntregaEstimada, float precioFinal, Producto producto1, Producto producto2, Producto producto3) {
        this.id = generaIdUnico();
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.provincia = provincia;
        this.estado = estado;
        this.comentario = comentario;
        this.fechaPedido = LocalDate.now();
        this.fechaEntregaEstimada = fechaPedido.plusDays(5);
        this.precioFinal = precioFinal;
        this.producto1 = null;
        this.producto2 = null;
        this.producto3 = null;
    }

    //Constructor por defecto
    public Pedido(int id, String direccion, String ciudad, String provincia, String estado, String comentario, String nombreCliente, String emailCliente, LocalDate fechaPedido, LocalDate fechaEntregaEstimada, float precioFinal, Producto producto1, Producto producto2, Producto producto3, int telefonoCliente, int cantidadProducto1, int cantidadProducto2, int cantidadProducto3) {
        this.id = id;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.provincia = provincia;
        this.estado = estado;
        this.comentario = comentario;
        this.nombreCliente = nombreCliente;
        this.emailCliente = emailCliente;
        this.fechaPedido = fechaPedido;
        this.fechaEntregaEstimada = fechaEntregaEstimada;
        this.precioFinal = precioFinal;
        this.producto1 = producto1;
        this.producto2 = producto2;
        this.producto3 = producto3;
        this.telefonoCliente = telefonoCliente;
        this.cantidadProducto1 = cantidadProducto1;
        this.cantidadProducto2 = cantidadProducto2;
        this.cantidadProducto3 = cantidadProducto3;
    }

    //Constructor con 1 productos
    public Pedido(String direccion, String ciudad, String provincia, String estado, String comentario, LocalDate fechaPedido, LocalDate fechaEntregaEstimada, float precioFinal, Producto producto1) {
        this.id = generaIdUnico();
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.provincia = provincia;
        this.estado = estado;
        this.comentario = comentario;
        this.fechaPedido = LocalDate.now();
        this.fechaEntregaEstimada = fechaPedido.plusDays(5);
        this.precioFinal = precioFinal;
        this.producto1 = null;
    }

    //Constructor con 2 productos
    public Pedido(String direccion, String ciudad, String provincia, String estado, String comentario, LocalDate fechaPedido, LocalDate fechaEntregaEstimada, float precioFinal, Producto producto1, Producto producto2) {
        this.id = generaIdUnico();
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.provincia = provincia;
        this.estado = estado;
        this.comentario = comentario;
        this.fechaPedido = LocalDate.now();
        this.fechaEntregaEstimada = fechaPedido.plusDays(5);
        this.precioFinal = precioFinal;
        this.producto1 = null;
        this.producto2 = null;
    }


    //Getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public LocalDate getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(LocalDate fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public LocalDate getFechaEntregaEstimada() {
        return fechaEntregaEstimada;
    }

    public void setFechaEntregaEstimada(LocalDate fechaEntregaEstimada) {
        this.fechaEntregaEstimada = fechaEntregaEstimada;
    }

    public float getPrecioFinal() {
        return precioFinal;
    }

    public void setPrecioFinal(float precioFinal) {
        this.precioFinal = precioFinal;
    }

    public Producto getProducto1() {
        return producto1;
    }

    public void setProducto1(Producto producto1) {
        this.producto1 = producto1;
    }

    public Producto getProducto2() {
        return producto2;
    }

    public void setProducto2(Producto producto2) {
        this.producto2 = producto2;
    }

    public Producto getProducto3() {
        return producto3;
    }

    public void setProducto3(Producto producto3) {
        this.producto3 = producto3;
    }

    public int getCantidadProducto1() {
        return cantidadProducto1;
    }

    public void setCantidadProducto1(int cantidadProducto1) {
        this.cantidadProducto1 = cantidadProducto1;
    }

    public int getCantidadProducto2() {
        return cantidadProducto2;
    }

    public void setCantidadProducto2(int cantidadProducto2) {
        this.cantidadProducto2 = cantidadProducto2;
    }

    public int getCantidadProducto3() {
        return cantidadProducto3;
    }

    public void setCantidadProducto3(int cantidadProducto3) {
        this.cantidadProducto3 = cantidadProducto3;
    }

    public static String getIdGenerados() {
        return idGenerados;
    }

    public static void setIdGenerados(String idGenerados) {
        Pedido.idGenerados = idGenerados;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }

    public int getTelefonoCliente() {
        return telefonoCliente;
    }

    public void setTelefonoCliente(int telefonoCliente) {
        this.telefonoCliente = telefonoCliente;
    }

    public boolean isAsignadoAUnTrabajador() {
        return asignadoAUnTrabajador;
    }

    public void setAsignadoAUnTrabajador(boolean asignadoAUnTrabajador) {
        this.asignadoAUnTrabajador = asignadoAUnTrabajador;
    }

    //Metodos

    //Metodo para generar un id unico
    public String formateaPrecio(float precio) {
        return String.format("%.2f", precio);
    }


    public int generaIdUnico() {
        int nuevoId;
        do {
            nuevoId = (int) (Math.random() * 100000) + 1; //Generamos el numero aleatorio entre 1 y 100000
        } while (idRepetido(nuevoId));
        idGenerados += nuevoId + "-"; //Lo agregamos a un String separado con un guion, que mas tarde nos servira para comprobar si se repite
        return nuevoId;
    }

    public String formateaFecha(LocalDate fecha) {
        //define el formato deseado
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        //devuelve la fecha en el formato especificado
        return fecha.format(formato);
    }

    //Metodo para comprobar si el id generado se repite
    public boolean idRepetido(int id) {
        String idString = String.valueOf(id);
        String comparador = "";

        for (int i = 0; i < idGenerados.length(); i++) {
            char numerosId = idGenerados.charAt(i);

            if (numerosId == '-') {
                if (comparador.equals(idString)) return true; //Si se repite, se devuelve true
                comparador = "";
            } else {
                comparador += numerosId;
            }
        }
        return false; //Si no se repite, se devuelve false
    }


    //toString
    /*public String pintaPedido(boolean esTrabajador) {
        return "Estado: " + estado + "\n" +
                "id: " + id + "\n" +
                "Precio final: " + precioFinal + "€\n" +
                "Fecha de entrega estimada: " + fechaEntregaEstimada + "\n" +
                "Comentario: " + (comentario != null ? comentario : "Sin comentarios") + "\n" +
                "Producto 1: " + (producto1 != null ? producto1.toString(esTrabajador) : "No asignado") + "\n" +
                "Producto 2: " + (producto2 != null ? producto2.toString(esTrabajador) : "No asignado") + "\n" +
                "Producto 3: " + (producto3 != null ? producto3.toString(esTrabajador) : "No asignado");
    }*/

    /*public String pintaPedido(boolean esTrabajador) {
        return "\n ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓\n" + "                   PEDIDO " + id + "\n" + " ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n" + "   · Estado:  \t\t\t" + estado + "\n" + "   · Cliente:  \t\t\t" + nombreCliente + "\n" + "   · Dirección:  \t\t" + direccion + "\n" + "   · Localidad:  \t\t" + ciudad + "\n" + "   · Provincia:  \t\t" + provincia + "\n" + "   · Teléfono:  \t\t" + telefonoCliente + "\n" + "   · Correo:  \t\t\t" + emailCliente + "\n" + "   · Fecha Pedido:  \t\t" + formateaFecha(fechaPedido) + "\n" + "   · Entrega Estimada:  \t" + formateaFecha(fechaEntregaEstimada) + "\n" + "   · Comentarios:  \t\t" + comentario + "\n" + "   · Detalles: \n" + "\t\t -" + producto1.getNombre() + " (" + formateaPrecio(producto1.getPrecio()) + "€ x" + cantidadProducto1 + ")" + "\n" + ((producto2 == null) ? "" : "\t\t -" + producto2.getNombre() + " (" + formateaPrecio(producto2.getPrecio()) + "E x" + cantidadProducto2 + ")" + "\n") + ((producto3 == null) ? "" : "\t\t -" + producto3.getNombre() + " (" + formateaPrecio(producto3.getPrecio()) + "E x" + cantidadProducto3 + ")" + "\n") + " ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n" + "   · TOTAL DEL PEDIDO:  \t\t\t" + precioFinal + "€ \n" + " ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n";
    }*/

    public String pintaPedido(boolean esTrabajador) {
        return "\n ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓\n" +
                "                   PEDIDO " + id + "\n" +
                " ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n" +
                "   · Estado:  \t\t\t" + estado + "\n" +
                "   · Cliente:  \t\t\t" + nombreCliente + "\n" +
                "   · Dirección:  \t\t" + direccion + "\n" +
                "   · Localidad:  \t\t" + ciudad + "\n" +
                "   · Provincia:  \t\t" + provincia + "\n" +
                "   · Teléfono:  \t\t" + telefonoCliente + "\n" +
                "   · Correo:  \t\t\t" + emailCliente + "\n" +
                "   · Fecha Pedido:  \t\t" + formateaFecha(fechaPedido) + "\n" +
                "   · Entrega Estimada:  \t" + formateaFecha(fechaEntregaEstimada) + "\n" +
                "   · Comentarios:  \t\t" + comentario + "\n" +
                "   · Detalles: \n" +
                "\t\t -" + (producto1 != null ? producto1.getNombre() + " (" + formateaPrecio(producto1.getPrecio()) + "€ x" + cantidadProducto1 + ")" : "Producto 1 no asignado") + "\n" +
                (producto2 != null ? "\t\t -" + producto2.getNombre() + " (" + formateaPrecio(producto2.getPrecio()) + "€ x" + cantidadProducto2 + ")" : "") + "\n" +
                (producto3 != null ? "\t\t -" + producto3.getNombre() + " (" + formateaPrecio(producto3.getPrecio()) + "€ x" + cantidadProducto3 + ")" : "") + "\n" +
                " ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n" +
                "   · TOTAL DEL PEDIDO:  \t\t\t" + formateaPrecio(precioFinal) + "€ \n" +
                " ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n";
    }


}
