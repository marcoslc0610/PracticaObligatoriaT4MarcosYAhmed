package models;

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
    public Pedido(Producto producto1, Producto producto2, Producto producto3, LocalDate fechaCreacion, String estado, String comentario) {
        this.producto1 = producto1;
        this.producto2 = producto2;
        this.producto3 = producto3;
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

    public LocalDate getFechaCreación() {
        return fechaCreacion;
    }

    public void setFechaCreación(LocalDate fechaCreación) {
        this.fechaCreacion = fechaCreación;
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
    public boolean agregarProducto(Producto producto) {
        if (producto1 == null) {
            producto1 = producto;
            return true;
        }
        if (producto2 == null) {
            producto2 = producto;
            return true;
        }
        if (producto3 == null) {
            producto3 = producto;
            return true;
        }
        return false;
    }

    public LocalDate fechaEntregaEstimada() {
        return fechaCreacion.plusDays(5);
    }

    //toString
    @Override
    public String toString() {
        return "Estado: " + estado + "\n" +
                "Fecha de entrega estimada: " + fechaEntregaEstimada() + "\n" +
                "Comentario: " + (comentario != null ? comentario : "Sin comentarios") + "\n" +
                "Producto 1: " + (producto1 != null ? producto1.toString() : "No asignado") + "\n" +
                "Producto 2: " + (producto2 != null ? producto2.toString() : "No asignado") + "\n" +
                "Producto 3: " + (producto3 != null ? producto3.toString() : "No asignado");
    }


}
