import java.util.Scanner;
public class EmergencyDetector {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("SISTEMA DE DETECCIÓN DE EMERGENCIA");

        String activationInput = scanner.nextLine().trim().toUpperCase();

        if (!activationInput.equals("A")) {
            System.out.println("Activación cancelada o inválida");
            scanner.close();
            return;
        }

        System.out.println("EMERGENCIA ACTIVADA");
        System.out.println("Ingrese el tipo de incidente: ");
        String incidentType = scanner.nextLine().trim();

        System.out.print("Ingrese el número estimado de personas afectadas: ");
        int affectedPeople = -1;
        try {
            affectedPeople = Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida para personas afectadas");
            affectedPeople = -1;
        }

        String severity = classifySeverity(affectedPeople, incidentType);

        System.out.println("\n--- RESULTADO DE LA EMERGENCIA ---");
        System.out.println("Tipo de Incidente: **" + incidentType.toUpperCase() + "**");
        System.out.println("Personas Afectadas: **" + affectedPeople + "**");
        System.out.println("Nivel de Gravedad: " + severity);
        System.out.println("----------------------------------");
        System.out.println("📢 Protocolo de respuesta **" + getAction(severity) + "** iniciado.");

        scanner.close();
    }

    private static String classifySeverity(int affected, String type) {
        if (affected >= 5) {
            return "Cŕitica";
        }

        if (normalizedType.contains("fuego") || normalizedType.contains("explosión")) {
            return "Peligro inmediato";
        }

        if (affected > 0) {
            return "Peligro. Asistencia urgente";
        }

        private static String getAction(String severity) {
            if (severity.contains("CRÍTICA")) {
                return "MAXIMA ALERTA (Envío Inmediato de Todos los Recursos)";
            } else if (severity.contains("MEDIA")) {
                return "ALERTA MODERADA (Envío de Recursos Específicos)";
            } else {
                return "VERIFICACIÓN INICIAL (Contacto con el Reportante)";
            }


    }
        }
    }
}