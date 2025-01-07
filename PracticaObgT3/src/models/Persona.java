package models;

public class Persona {

    //Atributos
    private String nombre;
    private String email;
    private int telefono;
    private String localidad;
    private String direccion;
    private String tipo;

    //Constructor
    public Persona(String nombre, String email, int telefono, String localidad, String direccion) {
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.localidad = localidad;
        this.direccion = direccion;
    }

    public Persona(String nombre, String email, int telefono, String localidad, String direccion, String tipo) {
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.localidad = localidad;
        this.direccion = direccion;
        this.tipo = tipo;
    }

    public Persona() {
        this.nombre = "";
        this.email = "";
        this.telefono = 0;
        this.localidad = "";
        this.direccion = "";
        this.tipo = "";
    }

    //Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    //toString
    @Override
    public String toString() {
        return "Persona: " + nombre + "\n" +
                "Email: " + email + "\n" +
                "Localidad: " + localidad + "\n" +
                "Dirección: " + direccion + "\n" +
                "Teléfono: " + telefono + "\n";
    }
}
