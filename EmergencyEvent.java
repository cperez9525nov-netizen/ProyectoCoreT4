public static EmergencyEvent {
    public class EmergencyEvent {
        private String userFullname;
        private String userPhoneNumber;
        private String locationAddress;
        private String incidentDescription;

        public EmergencyEvent(String userFullname, String userPhoneNumber, String locationAddress, String incidentDescription) {
            this.userFullname = userFullname;
            this.userPhoneNumber = userPhoneNumber;
            this.locationAddress = locationAddress;
            this.incidentDescription = incidentDescription;
        }
        // Métodos de la clase

        public String generateReport() {
            return "\n--- REPORTE DE EMERGENCIA ---\n" +
                    "Usuario: " + userFullname + "\n" +
                    "Contacto: " + userPhoneNumber + "\n" +
                    "Ubicación: " + locationAddress + "\n" +
                    "Incidentes: " + incidentDescription + "\n";
        }
        // Obtención de datos

        public String getUserFullname() {
            return userFullName;
        }

        public String getLocationAddress() {
            return locationAddress;
        }
        public class EmergencyEvent {
            public static void main(String[] args) {
                System.out.println("Iniciando aplicación de reporte de emergencias");
                EmergencyEvent myEmergency = new EmergencyEvent();

                String report = myEmergency.generateReport();
                System.out.println(report);

                System.out.println("Enviando equipo de respuesta a la dirección: " + myEmergency.getLocationAddress());
            }
        }
    }
}