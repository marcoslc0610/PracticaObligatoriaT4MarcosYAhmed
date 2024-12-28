package models;

public class Producto {
    //Atributos
    private String nombre;
    private double precio;
    private int stock;

    //Constructor
    public Producto(String nombre, double precio, int stock) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    //Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    //toString
    @Override
    public String toString() {
        return "Producto: " + nombre + "\n" +
                "Precio: " + precio + "€\n" +
                "Stock: " + (stock > 0 ? stock : "No disponible");
    }

}
