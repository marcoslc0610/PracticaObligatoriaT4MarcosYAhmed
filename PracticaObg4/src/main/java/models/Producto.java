package models;

public class Producto {

    // Atributos comunes
    private String nombre;
    private String descripcion;
    private float precio; //TODO Excepción
    private int stock; //TODO Excepcion
    private String tipoProducto; //Puede ser "Libro" o "Papelería"

    // Atributos para los libros
    private String autor;
    private String editorial;
    private String genero;
    private String idioma;

    // Atributos para los productos de papelería
    private String marca;
    private int unidades; //TODO Excepcion
    private String color;

    // Constructor general
    public Producto(String nombre, String descripcion, float precio, int stock, String tipoProducto) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
        this.tipoProducto = tipoProducto;
    }

    // Constructor para los libros
    public Producto(String nombre, String descripcion, float precio, int stock, String autor, String editorial, String genero, String idioma, String tipoProducto) {
        this(nombre, descripcion, precio, stock, "Libro");
        this.autor = autor;
        this.editorial = editorial;
        this.genero = genero;
        this.idioma = idioma;
        this.tipoProducto = tipoProducto;
    }

    // Constructor para los productos de papelería
    public Producto(String nombre, String descripcion, float precio, int stock, String marca, int unidades, String color, String tipoProducto) {
        this(nombre, descripcion, precio, stock, "Papelería");
        this.marca = marca;
        this.unidades = unidades;
        this.color = color;
        this.tipoProducto = tipoProducto;
    }

    public Producto() {
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(String tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }


    //toString libros
    public String toString(boolean esTrabajador) {
        if (tipoProducto.equalsIgnoreCase("libro")) {
            return pintaLibros(esTrabajador);
        } else if (tipoProducto.equalsIgnoreCase("articulo")) {
            return pintaArticulos(esTrabajador);
        }
        return "";  // En caso de que tipoProducto no sea "libro" ni "articulo", devolvemos una cadena vacía.
    }


    public String pintaLibros(boolean esTrabajador) {
        return "Libro: " + nombre + "\n" + "Descripción: " + descripcion + "\n" + "Precio: " + precio + "€\n" + (esTrabajador ? "Stock: " + stock + " unidades\n" : "") + "Autor: " + autor + "\n" + "Editorial: " + editorial + "\n" + "Género: " + genero + "\n" + "Idioma: " + idioma + "\n";
    }


    public String pintaArticulos(boolean esTrabajador) {
        return "Artículo: " + nombre + "\n" + "Descripción: " + descripcion + "\n" + "Precio: " + precio + "€\n" + (esTrabajador ? "Stock: " + stock + " unidades\n" : "") + "Marca: " + marca + "\n" + "Unidades en el paquete: " + unidades + "\n" + "Color: " + color + "\n";
    }
}
