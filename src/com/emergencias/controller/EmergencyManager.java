package com.emergencias.controller;

import com.emergencias.alert.AlertSender;
import com.emergencias.detector.EmergencyDetector;
import com.emergencias.detector.SeverityAnalizer;
import com.emergencias.model.CentroMedico;
import com.emergencias.model.EmergencyEvent;
import com.emergencias.model.UserData;
import java.util.List;

public class EmergencyManager {
    private EmergencyDetector detector;
    private AlertSender alertSender;
    private SeverityAnalizer analyzer;
    private UserData usuario;
    private List<CentroMedico> centrosDisponibles; //Lista de hospitales

    public EmergencyManager() {
        this.detector = new EmergencyDetector();
        this.alertSender = new AlertSender();
        this.analyzer = new SeverityAnalizer();

        // Datos de usuario simulados

        this.usuario = new UserData();
    }


    // Inicia el sistema de detección y, si es positivo, envía la alerta.

    public void startSystem() {
        System.out.println(">>> Sistema de Emergencias: Iniciando monitoreo...");

        try {
            // Inicia la detección
            EmergencyDetector.TipoEmergencia tipo = detector.detectEvent();

            // Validación de datos mínimos
            if (tipo == null) {
                throw new IllegalArgumentException("El tipo de emergencia no puede ser nulo.");
            }

            // Orquestación: Si se detecta una catástrofe válida, se envía la alerta
            if (esCatastrofePrioritaria(tipo)) {
                // Pedir la magnitud al usuario (podremos usar el scanner del detector o pedirla aquí)
                System.out.println("Introduzca la magnitud detectada para el análisis de severidad:");
                java.util.Scanner sc = new java.util.Scanner(System.in);
                double magnitud = sc.nextDouble();

                // Calculamos el Nivel de Severidad usando el analizador
                SeverityAnalizer.NivelSeveridad nivel = analyzer.evaluateSeverity(tipo, magnitud);

                // Buscamos el hospital más cercano a nuestra ubicación
                String hospitalAsignado = asignarCentroCercano();

                // Creamos el evento con la información necesaria
                EmergencyEvent evento = new EmergencyEvent(
                        tipo.toString(),
                        "Ubicación GPS: 40.4168, -3.7038 | HOSPITAL ASIGNADO: " + hospitalAsignado,
                        usuario
                );

                // Enviamos la notificación de la emergencia que se ha producido y el nivel de severidad

                alertSender.sendAlert(evento, nivel);

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

    //Método para almacenar la lista de Centros hospitalarios

    public void setCentrosDisponibles(List<CentroMedico> centros) {
        this.centrosDisponibles = centros;
    }

    // Método interno para elegir un centro
    private String asignarCentroCercano() {
        if (centrosDisponibles != null && !centrosDisponibles.isEmpty()) {
            // De momento asignamos el primero de la lista
            return centrosDisponibles.get(0).getNombre();
        }
        return "Ningún centro médico cercano disponible";
    }

    //Filtra si el evento es una de las 4 catástrofes principales.

    private boolean esCatastrofePrioritaria(EmergencyDetector.TipoEmergencia tipo) {
        return tipo == EmergencyDetector.TipoEmergencia.INCENDIO ||
                tipo == EmergencyDetector.TipoEmergencia.EXPLOSION ||
                tipo == EmergencyDetector.TipoEmergencia.ACCIDENTE ||
                tipo == EmergencyDetector.TipoEmergencia.INUNDACION;
    }
}