package models;

import utils.PantallasDeCarga;

import java.util.Scanner;

public class Producto {

    //Atributos
    private String nombre;
    private String descripcion;
    private double precio;
    private int stock;

    //Atributos para los libros
    private String autor;
    private String editorial;
    private String genero;
    private String idioma;

    //Atributos para los productos de papeleria
    private String marca;
    private int unidades;
    private String color;

    //Constructor para los libros
    public Producto(String nombre, String descripcion, double precio, int stock, String autor, String editorial, String genero, String idioma) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
        this.autor = autor;
        this.editorial = editorial;
        this.genero = genero;
        this.idioma = idioma;
    }

    //Constructor para los productos de papeleria
    public Producto(String nombre, String descripcion, double precio, int stock, String marca, int unidades, String color) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
        this.marca = marca;
        this.unidades = unidades;
        this.color = color;
    }

    //Getters y Setters
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

    public void modificaLibros(String op) {
        Scanner s = new Scanner(System.in);
        if (op.equals("1") || op.equals("2")) {
            System.out.print("Introduzca el nombre del libro: ");
            setNombre(s.nextLine());
        }
        if (op.equals("1") || op.equals("3")) {
            System.out.print("Introduzca la descripción del libro: ");
            setDescripcion(s.nextLine());
        }
        if (op.equals("1") || op.equals("4")) {
            System.out.print("Introduzca el precio del libro: ");
            setPrecio(Double.parseDouble(s.nextLine()));
        }
        if (op.equals("1") || op.equals("5")) {
            System.out.print("Introduzca el stock del libro: ");
            setStock(Integer.parseInt(s.nextLine()));
        }
        if (op.equals("1") || op.equals("6")) {
            System.out.print("Introduzca el autor del libro: ");
            setAutor(s.nextLine());
        }
        if (op.equals("1") || op.equals("7")) {
            System.out.print("Introduzca la editorial del libro: ");
            setEditorial(s.nextLine());
        }
        if (op.equals("1") || op.equals("8")) {
            System.out.print("Introduzca el género del libro: ");
            setGenero(s.nextLine());
        }
        if (op.equals("1") || op.equals("9")) {
            System.out.print("Introduzca el idioma del libro: ");
            setIdioma(s.nextLine());
        }
        if (op.equals("10")) {
            PantallasDeCarga.saliendo();
        }
    }

    public void modificaArticulos(String op) {
        Scanner s = new Scanner(System.in);
        if (op.equals("1") || op.equals("2")) {
            System.out.print("Introduzca nombre del articulo: ");
            setNombre(s.nextLine());
        }
        if (op.equals("1") || op.equals("3")) {
            System.out.print("Introduzca la descripción del articulo: ");
            setDescripcion(s.nextLine());
        }
        if (op.equals("1") || op.equals("4")) {
            System.out.print("Introduzca el precio del articulo: ");
            setPrecio(Double.parseDouble(s.nextLine()));
        }
        if (op.equals("1") || op.equals("5")) {
            System.out.print("Introduzca el stock del articulo: ");
            setStock(Integer.parseInt(s.nextLine()));
        }
        if (op.equals("1") || op.equals("6")) {
            System.out.print("Introduzca la marca del articulo: ");
            setAutor(s.nextLine());
        }
        if (op.equals("1") || op.equals("7")) {
            System.out.print("Introduzca unidades que contiene el articulo: ");
            setEditorial(s.nextLine());
        }
        if (op.equals("1") || op.equals("8")) {
            System.out.print("Introduzca el color del articulo: ");
            setGenero(s.nextLine());
        }
        if (op.equals("9")) {
            PantallasDeCarga.saliendo();
        }
    }

    //toString libros
    public String pintaLibros(boolean esTrabajador) {
        return "Libro: " + nombre + "\n" +
                "Descripción: " + descripcion + "\n" +
                "Precio: " + precio + "€\n" +
                (esTrabajador == true ? "Stock: " + stock + " unidades\n" : "") +
                "Autor: " + autor + "\n" +
                "Editorial: " + editorial + "\n" +
                "Género: " + genero + "\n" +
                "Idioma: " + idioma + "\n";
    }


    public String pintaArticulos(boolean esTrabajador) {
        return "Artículo: " + nombre + "\n" +
                "Descripción: " + descripcion + "\n" +
                "Precio: " + precio + "€\n" +
                (esTrabajador == true ? "Stock: " + stock + " unidades\n" : "") +
                "Marca: " + marca + "\n" +
                "Unidades en el paquete: " + unidades + "\n" +
                "Color: " + color + "\n";
    }
}
