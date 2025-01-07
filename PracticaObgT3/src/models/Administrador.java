package models;

public class Administrador {

    //Atributos
    private Persona persona;
    private String contrasena;

    //Constructor
    public Administrador(Persona persona, String contrasena) {
        this.persona = persona;
        this.contrasena = contrasena;
    }

    public Administrador() {
    }

    //Getters y Setters
    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    //toString
    @Override
    public String toString() {
        return "";
    }
}
