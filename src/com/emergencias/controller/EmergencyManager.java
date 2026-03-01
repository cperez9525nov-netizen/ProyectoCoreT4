package com.emergencias.controller;

import com.emergencias.alert.AlertSender;
import com.emergencias.detector.EmergencyDetector;
import com.emergencias.model.EmergencyEvent;
import com.emergencias.model.UserData;

public class EmergencyManager {
    private EmergencyDetector detector;
    private AlertSender alertSender;
    private UserData usuario;

    public EmergencyManager() {
        this.detector = new EmergencyDetector();
        this.alertSender = new AlertSender();

        // Datos de usuario simulados

        this.usuario = new UserData("Ana", "12345678Z", "García", "Asma", true, 28);
    }

    /*
     * Inicia el sistema de detección y, si es positivo, envía la alerta.
     */
    public void startSystem() {
        System.out.println(">>> Sistema de Emergencias: Iniciando monitoreo...");

        try {
            // 1. Inicia la detección (Core 1)
            EmergencyDetector.TipoEmergencia tipo = detector.detectEvent();

            // 2. Validación de datos mínimos
            if (tipo == null) {
                throw new IllegalArgumentException("El tipo de emergencia no puede ser nulo.");
            }

            // 3. Orquestación: Si se detecta una catástrofe válida, se envía la alerta
            if (esCatastrofePrioritaria(tipo)) {

                // Creamos el evento con la información necesaria
                EmergencyEvent evento = new EmergencyEvent(
                        tipo.toString(),
                        "Ubicación GPS: 40.4168, -3.7038",
                        usuario
                );

                // Enviamos la notificación (Core 2)
                alertSender.sendAlert(evento);

            } else {
                System.out.println(">>> No se requiere intervención inmediata para este evento.");
            }

        } catch (IllegalArgumentException e) {
            System.err.println("Error de validación de datos: " + e.getMessage());
        } catch (Exception e) {
            // Manejo de errores general para asegurar que la app no se rompa
            System.err.println("Error inesperado en el sistema: " + e.getMessage());
        } finally {
            System.out.println(">>> Monitoreo finalizado.");
        }
    }

    /*
     * Filtra si el evento es una de las 4 catástrofes principales.
     */
    private boolean esCatastrofePrioritaria(EmergencyDetector.TipoEmergencia tipo) {
        return tipo == EmergencyDetector.TipoEmergencia.INCENDIO ||
                tipo == EmergencyDetector.TipoEmergencia.EXPLOSION ||
                tipo == EmergencyDetector.TipoEmergencia.ACCIDENTE ||
                tipo == EmergencyDetector.TipoEmergencia.INUNDACION;
    }
}