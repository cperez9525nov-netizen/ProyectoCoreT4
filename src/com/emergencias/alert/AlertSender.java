package com.emergencias.alert;

import com.emergencias.model.EmergencyEvent;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class AlertSender {

    /*
     * Envía la notificación formal a los servicios de emergencia (112).
     * Muestra el mensaje en consola y lo guarda en un archivo de log.
     */
    public void sendAlert(EmergencyEvent event) {
        String mensajeCentral = "--- ALERTA OFICIAL AL 112 ---\n" +
                "TIPO: " + event.getTipoEmergencia() + "\n" +
                "UBICACIÓN: " + event.getUbicacion() + "\n" +
                "INFO MÉDICA: " + event.getDatosUsuario() + "\n" +
                "-----------------------------";

        // Imprimir en consola para el usuario
        System.out.println(mensajeCentral);

        // Guardar en log.txt (Simulando el registro en la base de datos de la policía)

        try (FileWriter fw = new FileWriter("log_policia.txt", true);
             PrintWriter out = new PrintWriter(fw)) {
            out.println(mensajeCentral);
            System.out.println("✅ Notificación registrada en el log de la policía.");
        } catch (IOException e) {
            System.out.println("❌ Error al guardar el log: " + e.getMessage());
        }
    }

    /*
     * Simula el aviso a los contactos de confianza del usuario.
     */
    public void notifyContacts(String nombreContacto, String telefono) {
        System.out.println("\n[SIMULANDO SMS/LLAMADA]");
        System.out.println("Enviando mensaje a: " + nombreContacto + " (" + telefono + ")");
        System.out.println("Mensaje: '¡Emergencia detectada! Mi dispositivo ha enviado mi ubicación al 112.'");
    }
}