package com.emergencias.detector;

import java.util.Scanner;

public class EmergencyDetector {
    private final Scanner scanner = new Scanner(System.in);

    // Definimos los tipos de emergencia soportados
    public enum TipoEmergencia {
        INCENDIO, EXPLOSION, ACCIDENTE, INUNDACION, DESCONOCIDO
    }

    /**
     * Simula la detección de un evento mediante entrada de consola.
     * @return El tipo de emergencia detectado.
     */
    public TipoEmergencia detectEvent() {
        System.out.println("\n--- MONITOR DE SENSORES ACTIVO ---");
        System.out.println("Seleccione tipo de emergencia detectada:");
        System.out.println("1. INCENDIO | 2. EXPLOSION | 3. ACCIDENTE | 4. INUNDACION");

        String input = scanner.nextLine().trim().toUpperCase();

        return switch (input) {
            case "1", "INCENDIO"  -> TipoEmergencia.INCENDIO;
            case "2", "EXPLOSION" -> TipoEmergencia.EXPLOSION;
            case "3", "ACCIDENTE" -> TipoEmergencia.ACCIDENTE;
            case "4", "INUNDACION" -> TipoEmergencia.INUNDACION;
            default -> {
                System.out.println("⚠️ Entrada no reconocida. Detectando como DESCONOCIDO.");
                yield TipoEmergencia.DESCONOCIDO;
            }
        };
    }

    /**
     * Verifica la gravedad según umbrales específicos para cada tipo.
     * @param tipo El tipo de emergencia.
     * @param magnitud Valor numérico que representa la escala (ej. grados, metros, fuerza).
     * @return true si supera el umbral de gravedad.
     */
    public boolean validateSeverity(TipoEmergencia tipo, double magnitud) {
        return switch (tipo) {
            case INCENDIO -> magnitud > 45.0; // Grados Celsius detectados
            case EXPLOSION -> magnitud > 0.5; // Presión de onda expansiva
            case ACCIDENTE -> magnitud > 50.0; // Fuerza de impacto (G)
            case INUNDACION -> magnitud > 1.0; // Metros de altura del agua
            case DESCONOCIDO -> false;
        };
    }
}