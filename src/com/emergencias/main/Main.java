package com.emergencias.main;

import com.emergencias.controller.EmergencyManager;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- INICIANDO SISTEMA DE GESTIÓN DE EMERGENCIAS ---");
        EmergencyManager manager = new EmergencyManager();
        manager.startSystem();
    }
}