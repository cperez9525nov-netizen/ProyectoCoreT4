package com.emergencias.model;

import java.time.LocalDateTime;

public class EmergencyEvent {
    private String tipoEmergencia;
    private String ubicacion;
    private UserData datosUsuario;
    private LocalDateTime fechaHora;

    //Constructores parametizados

    public EmergencyEvent(String tipoEmergencia, String ubicacion, UserData datosUsuario) {
        this.tipoEmergencia = tipoEmergencia;
        this.ubicacion = ubicacion;
        this.datosUsuario = datosUsuario;
        this.fechaHora = LocalDateTime.now();
    }

    // Getters para obtener los datos
    public String getTipoEmergencia() {
        return tipoEmergencia;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public UserData getDatosUsuario() {
        return datosUsuario;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }
}