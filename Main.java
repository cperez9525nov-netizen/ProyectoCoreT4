public class Main {
    public static void main(String[] args) {
        EmergencyDetector detector = new EmergencyDetector();
        AlertSender sender = new AlertSender();
        EmergencyEvent event = detector.detectEvent();
        sender.sendAlert(event);
        
    }
}