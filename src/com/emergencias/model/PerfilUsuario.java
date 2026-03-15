package com.emergencias.model;

import java.util.List;

//Clase POJO para el archivo JSON perfil-usuario

public class PerfilUsuario {

    private String nombre;
    private String apellidos;
    private int edad;
    private String localidad;
    private String grupoSanguineo;
    private List<String> patologias;
    private String contactoEmergencia;

    //constructor vacío
    public PerfilUsuario() {}

    //getters
    public String getNombre() {
        return nombre;
    }
    public String getApellidos() {
        return apellidos;
    }
    public int getEdad() {
        return edad;
    }
    public String getLocalidad() {
        return localidad;
    }
    public String getGrupoSanguineo() {
        return grupoSanguineo;
    }
    public List<String> getPatologias() {
        return patologias;
    }
    public String getContactoEmergencia() {
        return contactoEmergencia;
    }

    //setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    public void setEdad(int edad) {
        if (edad < 0 || edad > 150) {
            System.out.print("Edad introducida incorrecta");
        } else {
            this.edad = edad;
        }
    }
    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }
    public void setGrupoSanguineo(String grupoSanguineo) {
        this.grupoSanguineo = grupoSanguineo;
    }
    public void setPatologias(List<String> patologias) {
        this.patologias = patologias;
    }
    public void setContactoEmergencia(String contactoEmergencia) {
        this.contactoEmergencia = contactoEmergencia;
    }

    //Método para imprimir la información médica

    @Override
    public String toString() {
        return "Paciente: " + nombre + " " + apellidos + " (" + edad + " años)\n" +
                "Grupo Sanguíneo: " + grupoSanguineo + "\n" +
                "Patologías: " + (patologias != null ? String.join(", ", patologias) : "Ninguna");
    }
}
