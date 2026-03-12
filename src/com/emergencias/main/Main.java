package com.emergencias.main;

import java.util.ArrayList;
import java.util.List;
import com.emergencias.detector.EmergencyDetector;
import com.emergencias.controller.EmergencyManager;
import com.emergencias.model.CentroMedico;
import com.emergencias.controller.CentroMedicoService;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- INICIANDO SISTEMA DE GESTIÓN DE EMERGENCIAS ---");
        EmergencyManager manager = new EmergencyManager();
        manager.startSystem();

        //Instanciamos el servicio de lectura
        CentroMedicoService servicio = new CentroMedicoService();

        //Cargamos los centros médicos a través de un ArrayList
        List<CentroMedico> listaCargada = servicio.cargarCentros();

        //Verificamos que la lísta
        ArrayList<CentroMedico> listaCentros = new ArrayList<>();
        if (listaCargada != null) {
            listaCentros.addAll(listaCargada);
            System.out.println("Centros médicos encontrados: " + listaCentros.size());
        } else {
            System.out.println("No se encontraron centros médicos");
        }

        //Trabajamos con el arraylist
        for (CentroMedico centro : listaCentros) {
            System.out.println(centro); //llama el toString
        }

        // --- AQUÍ VA A IR EL DETECTOR ---
        System.out.println("\n--- SISTEMA LISTO PARA DETECTAR EMERGENCIAS ---");

        // Instanciamos el detector
        EmergencyDetector detector = new EmergencyDetector();

        // Ejecutamos la detección (esto pedirá los datos por consola)
        detector.procesarDeteccion();

        System.out.println("\n--- FIN DEL PROGRAMA ---");
    }
}