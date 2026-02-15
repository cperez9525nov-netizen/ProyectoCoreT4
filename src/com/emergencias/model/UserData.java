package com.emergencias.model;

public class UserData {
    protected String nombre;
    protected String dni;
    protected int edad;
    protected String apellido;
    protected String patologia;
    protected boolean afectado;

    //constructor por defecto

    public UserData() {
    }

    //constructor parametizable

    public UserData(String nombre, String dni, String apellido, String patologia, boolean afectado, int edad) {
        this.nombre = nombre;
        this.dni = dni;
        this.edad = edad;
        this.apellido = apellido;
        this.patologia = patologia;
        this.afectado = afectado;
    }

    //método setters

    public void setEdad(int edad) {
        if (edad < 0 || edad > 150) {
            System.out.print("Edad introducida incorrecta");
        } else {
            this.edad = edad;
        }
    }

    //Normalización de datos (DNI y Nombre siempre en mayúsculas)

    public void setNombre(String nombre) {
        this.nombre = (nombre != null) ? nombre.trim().toUpperCase() : "DESCONOCIDO";
    }

    public void setDni(String dni) {
        this.dni = (dni != null) ? dni.toUpperCase() : "SIN IDENTIFICAR";
    }

    // Método de utilidad: Prioridad de atención
    public String getPrioridad() {
        if (afectado && (patologia.equalsIgnoreCase("CORAZON") || edad > 70)) {
            return "ALTA - ATENCIÓN INMEDIATA";
        }
        return afectado ? "MEDIA" : "BAJA";
    }

    // El método toString() es esencial para ver los datos rápido
    @Override
    public String toString() {
        return String.format("PACIENTE [%s] - %s, %s | Edad: %d | Patología: %s",
                dni, apellido, nombre, edad, patologia);
    }
}