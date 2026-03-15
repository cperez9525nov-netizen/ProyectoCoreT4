package com.emergencias.controller;

import com.emergencias.model.PerfilUsuario;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.InputStream;

public class PerfilUsuarioService {

    //Cargar el archivo JSON desde la carpeta resources
    public PerfilUsuario cargarPerfil() {
        ObjectMapper mapper = new ObjectMapper();

        // Intentamos obtener el archivo desde la carpeta resources
        try (InputStream is = getClass().getClassLoader().getResourceAsStream("perfil-usuario.json")) {

            if (is == null) {
                System.err.println("No se encontró el archivo perfil-usuario.json en resources.");
                return null;
            }

            // Convertimos el JSON directamente en nuestro objeto POJO
            return mapper.readValue(is, PerfilUsuario.class);

        } catch (IOException e) {
            System.err.println("Error al procesar el JSON del perfil: " + e.getMessage());
            return null;
        }
    }
}