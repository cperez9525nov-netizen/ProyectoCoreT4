package com.emergencias.model;

import java.time.LocalDateTime;

public class EmergencyEvent {
    private String tipoEmergencia;
    private String ubicacion;
    private PerfilUsuario datosUsuario;
    private LocalDateTime fechaHora;

    //Constructores parametizados

    public EmergencyEvent(String tipoEmergencia, String ubicacion, PerfilUsuario datosUsuario) {
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

    public PerfilUsuario getDatosUsuario() {
        return datosUsuario;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }
}