package models;

import utils.PantallasDeCarga;
import utils.PintaMenus;

import java.time.LocalDate;

public class Pedido {

    //Atributos
    private Producto producto1;
    private Producto producto2;
    private Producto producto3;
    private LocalDate fechaCreacion;
    private String estado;
    private String comentario;

    //Constructor
    public Pedido() {
    }

    public Pedido(Producto producto1, Producto producto2, Producto producto3, LocalDate fechaCreacion, String estado, String comentario) {
        this.producto1 = producto1;
        this.producto2 = producto2;
        this.producto3 = producto3;
        this.fechaCreacion = fechaCreacion;
        this.estado = estado;
        this.comentario = comentario;
    }

    public Pedido(Producto producto1, Producto producto2, Producto producto3, LocalDate fechaCreacion) {
        this.producto1 = producto1;
        this.producto2 = producto2;
        this.producto3 = producto3;
        this.fechaCreacion = fechaCreacion;
    }

    public Pedido(Producto producto1, LocalDate fechaCreacion) {
        this.producto1 = producto1;
        this.fechaCreacion = fechaCreacion;
    }

    public Pedido(Producto producto1, Producto producto2, LocalDate fechaCreacion) {
        this.producto1 = producto1;
        this.producto2 = producto2;
        this.fechaCreacion = fechaCreacion;
    }


    public Pedido(Producto producto1, LocalDate fechaCreacion, String estado, String comentario) {
        this.producto1 = producto1;
        this.fechaCreacion = fechaCreacion;
        this.estado = estado;
        this.comentario = comentario;
    }

    public Pedido(Producto producto1, Producto producto2, LocalDate fechaCreacion, String estado, String comentario) {
        this.producto1 = producto1;
        this.producto2 = producto2;
        this.fechaCreacion = fechaCreacion;
        this.estado = estado;
        this.comentario = comentario;
    }

    //Getters y Setters
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

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
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

    //Otros metodos
    public LocalDate fechaEntregaEstimada() {
        if (fechaCreacion == null) return null;
        else return fechaCreacion.plusDays(5);
    }

    public boolean estaVacio() {
        if (producto1 == null && producto2 == null && producto3 == null) return true;
        return false;
    }

    private void agregaProductos(Pedido pedido, Producto producto) {
        if (pedido.getProducto1() == null) pedido.setProducto1(producto);
        else if (pedido.getProducto2() == null) pedido.setProducto2(producto);
        else if (pedido.getProducto3() == null) pedido.setProducto3(producto);
    }

    public void realizaPedido(Pedido nuevoPedido,Producto libro1, Producto libro2, Producto libro3, Producto libro4, Producto articulo1, Producto articulo2, Producto articulo3, Producto articulo4) {
        String opMenuProductos;
        do {
            opMenuProductos = PintaMenus.menuProductos(libro1, libro2, libro3, libro4, articulo1, articulo2, articulo3, articulo4);

            System.out.println(nuevoPedido);
            switch (opMenuProductos) {
                case "1":
                    agregaProductos(nuevoPedido, libro1);
                    break;
                case "2":
                    agregaProductos(nuevoPedido, libro2);
                    break;
                case "3":
                    agregaProductos(nuevoPedido, libro3);
                    break;
                case "4":
                    agregaProductos(nuevoPedido, libro4);
                    break;
                case "5":
                    agregaProductos(nuevoPedido, articulo1);
                    break;
                case "6":
                    agregaProductos(nuevoPedido, articulo2);
                    break;
                case "7":
                    agregaProductos(nuevoPedido, articulo3);
                    break;
                case "8":
                    agregaProductos(nuevoPedido, articulo4);
                    break;
                case "9":
                    PantallasDeCarga.pulsaParaContinuar();
                    break;
            }
        } while (!(nuevoPedido.producto1 != null && nuevoPedido.producto2 != null && nuevoPedido.producto3 != null) && !opMenuProductos.equals("9"));

        LocalDate fechaPedido = LocalDate.now();
        nuevoPedido.setFechaCreacion(fechaPedido);
        nuevoPedido.setEstado("PEDIDO NUEVO");
        nuevoPedido.setComentario("Sin comentarios");
    }


    //toString
    public String pintaPedido() {
        return "Estado: " + estado + "\n" + "Fecha de entrega estimada: " + fechaEntregaEstimada() + "\n" + "Comentario: " + (comentario != null ? comentario : "Sin comentarios") + "\n" + "Producto 1: " + (producto1 != null ? producto1.toString() : "No asignado") + "\n" + "Producto 2: " + (producto2 != null ? producto2.toString() : "No asignado") + "\n" + "Producto 3: " + (producto3 != null ? producto3.toString() : "No asignado");
    }
}
