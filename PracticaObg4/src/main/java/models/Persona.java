package models;

public class Persona {

    //Atributos
    private String nombreCompleto;
    private int telefono; // TODO Cambiar por int y agregar excepciones
    private String email;
    private String ciudad;
    private String provincia;
    private String direccion;
    private boolean esCliente;
    private boolean esTrabajador;
    private boolean esAdministrador;
    private boolean token;

    //Constructores

    public Persona() {
    }

    public Persona(String nombreCompleto, int telefono, String email, String ciudad, String provincia, String direccion, boolean esCliente, boolean esTrabajador, boolean esAdministrador) {
        this.nombreCompleto = nombreCompleto;
        this.telefono = telefono;
        this.email = email;
        this.ciudad = ciudad;
        this.provincia = provincia;
        this.direccion = direccion;
        this.esCliente = esCliente;
        this.esTrabajador = esTrabajador;
        this.esAdministrador = esAdministrador;
    }

    public Persona(String nombreCompleto, int telefono, String email, String ciudad, String provincia, String direccion) {
        this.nombreCompleto = nombreCompleto;
        this.telefono = telefono;
        this.email = email;
        this.ciudad = ciudad;
        this.provincia = provincia;
        this.direccion = direccion;
        this.esCliente = false;
        this.esTrabajador = false;
        this.esAdministrador = false;
    }

    public Persona(String nombreCompleto, int telefono, String email, String ciudad, String provincia, String direccion, boolean esCliente, boolean esTrabajador, boolean esAdministrador, boolean token) {
        this.nombreCompleto = nombreCompleto;
        this.telefono = telefono;
        this.email = email;
        this.ciudad = ciudad;
        this.provincia = provincia;
        this.direccion = direccion;
        this.esCliente = esCliente;
        this.esTrabajador = esTrabajador;
        this.esAdministrador = esAdministrador;
        this.token = token;
    }

    public Persona(Persona persona) {
        this.nombreCompleto = persona.nombreCompleto;
        this.telefono = persona.telefono;
        this.email = persona.email;
        this.ciudad = persona.ciudad;
        this.provincia = persona.provincia;
        this.direccion = persona.direccion;
        this.esCliente = persona.esCliente;
        this.esTrabajador = persona.esTrabajador;
        this.esAdministrador = persona.esAdministrador;
    }

    //Getters y Setters
    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public boolean isEsCliente() {
        return esCliente;
    }

    public void setEsCliente(boolean esCliente) {
        this.esCliente = esCliente;
    }

    public boolean isEsTrabajador() {
        return esTrabajador;
    }

    public void setEsTrabajador(boolean esTrabajador) {
        this.esTrabajador = esTrabajador;
    }

    public boolean isEsAdministrador() {
        return esAdministrador;
    }

    public void setEsAdministrador(boolean esAdministrador) {
        this.esAdministrador = esAdministrador;
    }

    public boolean isToken() {
        return token;
    }

    public void setToken(boolean token) {
        this.token = token;
    }
}
