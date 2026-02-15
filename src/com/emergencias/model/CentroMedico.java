package com.emergencias.model;

public class CentroMedico {
    private int codigo;
    private String nombre;
    private String direccion;
    private int CP;
    private String municipio;
    private int telefono;
    private int FAX;
    private String email;
    private String URL;
    private String latitud;
    private String longitud;

    //constructor vacío para jackson

    public CentroMedico(){}

    //métodos getters y setters para jackson

    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public int getCP() {
        return CP;
    }
    public void setCP(int CP) {
        this.CP = CP;
    }
    public String getMunicipio() {
        return municipio;
    }
    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }
    public int getTelefono() {
        return telefono;
    }
    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
    public int getFAX() {
        return FAX;
    }
    public void setFAX(int FAX) {
        this.FAX = FAX;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getURL() {
        return URL;
    }
    public void setURL(String URL) {
        this.URL = URL;
    }
    public String getLatitud() {
        return latitud;
    }
    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }
    public String getLongitud() {
        return longitud;
    }
    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    @Override
    public String toString() {
        String sb = "****** Detalles del Centro Médico más cercano ******\n" +
                "Código: " + getCodigo() + "\n" +
                "Nombre: " + getNombre() + "\n" +
                "Dirección: " + getDireccion() + "\n" +
                "Código Postal: " + getCP() + "\n" +
                "Municipio: " + getMunicipio() + "\n" +
                "Teléfono/fax: " + getTelefono() + "/" + getFAX() + "\n" +
                "Correo electrónico: " + getEmail() + "\n" +
                "Web del centro: " + getURL() + "\n" +
                "Latitud: " + getLatitud() + "\n" +
                "Longitud: " + getLongitud() + "\n" +
                "******************************************************";
        return sb;
    }
}
