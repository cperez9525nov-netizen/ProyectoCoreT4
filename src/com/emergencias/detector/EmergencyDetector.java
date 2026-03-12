package com.emergencias.detector;

import java.util.Scanner;
//Importamos la clase de unión entre las dos clases del directorio "detector"
import com.emergencias.detector.SeverityAnalizer.NivelSeveridad;

public class EmergencyDetector {
    private final Scanner scanner = new Scanner(System.in);
    // Creamos una instancia del analizador para usarlo aquí
    private final SeverityAnalizer analyzer = new SeverityAnalizer();

    public enum TipoEmergencia {
        INCENDIO, EXPLOSION, ACCIDENTE, INUNDACION, DESCONOCIDO
    }

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

    //Usamos el analizador para obtener el nivel de severidad real de la emergencia

    public void procesarDeteccion() {
        TipoEmergencia tipo = detectEvent();

        System.out.println("Introduzca la magnitud detectada(0 - 100):");
        double magnitud = Double.parseDouble(scanner.nextLine());

        // Aquí delegamos el trabajo al Analizer

        NivelSeveridad nivel = analyzer.evaluateSeverity(tipo, magnitud);

        System.out.println(">>> [ANÁLISIS] Tipo: " + tipo + " | Nivel de Severidad: " + nivel);
    }
}