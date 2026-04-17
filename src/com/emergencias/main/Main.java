package com.emergencias.main;

import java.util.ArrayList;
import java.util.List;

import com.emergencias.controller.PerfilUsuarioService;
import com.emergencias.detector.EmergencyDetector;
import com.emergencias.controller.EmergencyManager;
import com.emergencias.model.CentroMedico;
import com.emergencias.controller.CentroMedicoService;
import com.emergencias.model.PerfilUsuario;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- INICIANDO SISTEMA DE GESTIÓN DE EMERGENCIAS ---");

        // ---INICIAMOS CARGA Y LECTURA CENTROS MÉDICOS ---
        //Instanciamos el servicio de lectura
        CentroMedicoService servicio = new CentroMedicoService();

        //Cargamos los centros médicos a través de un ArrayList
        List<CentroMedico> listaCargada = servicio.cargarCentros();

        //Verificamos que la lísta
        ArrayList<CentroMedico> listaCentros = new ArrayList<>();
        if (listaCargada != null) {
            listaCentros.addAll(listaCargada);
            System.out.println("Centros médicos encontrados: " + listaCentros.size());

            //Trabajamos con el arraylist en el caso de que se hayan encontrado centros médicos cercanos
            for (CentroMedico centro : listaCentros) {
                System.out.println(centro); //llama el toString
            }
        } else {
            System.out.println("No se encontraron centros médicos");
        }

        // CARGA DEL PERFIL DE USUARIO (Cristian)
        PerfilUsuarioService servicioPerfil = new PerfilUsuarioService();
        PerfilUsuario usuarioCristian = servicioPerfil.obtenerPerfilCompleto("74221034W");

        if (usuarioCristian != null) {
            System.out.println("Perfil cargado desde la Base de Datos: " + usuarioCristian.getNombre() + " " + usuarioCristian.getApellidos());
        } else {
            System.out.println("No se encontró en la BD. Intentando carga de emergencia desde JSON...");
            usuarioCristian = servicioPerfil.cargarPerfil(); // Intento de respaldo
        }

        // --- INICIO DEL CONTROLADOR ---
        EmergencyManager manager = new EmergencyManager(usuarioCristian);

        // Pasamos los datos que acabamos de leer del JSON
        manager.setCentrosDisponibles(listaCentros);

        System.out.println("\n--- SISTEMA LISTO Y MONITORIZANDO ---");

        // Llamamos internamente al detector.detectEvent()
        manager.startSystem();

        System.out.println("\n--- FIN DEL PROGRAMA ---");
    }
}