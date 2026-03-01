package com.emergencias.main;

import java.util.List;
import java.util.Scanner; // Importación necesaria para leer por teclado
import com.emergencias.controller.EmergencyManager;
import com.emergencias.model.CentroMedico;
import com.emergencias.controller.CentroMedicoService;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- INICIANDO SISTEMA DE GESTIÓN DE EMERGENCIAS ---");
        EmergencyManager manager = new EmergencyManager();
        manager.startSystem();

        // Preguntamos al usuario si desea ver los centros médicos
        System.out.println("\n¿Desea consultar los centros médicos disponibles más cercanos? (S/N)");
        Scanner scanner = new Scanner(System.in);

        if (scanner.nextLine().trim().equalsIgnoreCase("S")) {
            // Instanciamos el servicio de lectura
            CentroMedicoService servicio = new CentroMedicoService();
            List<CentroMedico> listaCargada = servicio.cargarCentros();

            // Verificamos y trabajamos directamente con la lista devuelta, evitando redundancias
            if (listaCargada != null && !listaCargada.isEmpty()) {
                System.out.println("Centros médicos encontrados: " + listaCargada.size());
                for (CentroMedico centro : listaCargada) {
                    System.out.println(centro); // Llama al toString()
                }
            } else {
                System.out.println("No se encontraron centros médicos.");
            }
        } else {
            System.out.println("Cerrando el sistema sin consultar centros médicos. ¡Cuídese!");
        }
        scanner.close();
    }
}