package com.emergencias.controller;

import com.emergencias.model.PerfilUsuario;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*; // IMPORTANTE: Para Connection, PreparedStatement, etc.
import java.util.List;

public class PerfilUsuarioService {

    public PerfilUsuario obtenerPerfilCompleto(String dni) {
        // 1. Intentamos primero cargar de la Base de Datos
        PerfilUsuario perfil = cargarDesdeBD(dni);

        // 2. Si falla la BD, usamos el método que ya había en el archivo JSON
        if (perfil == null) {
            System.out.println("⚠️ Alerta: Cargando perfil desde JSON (BD no disponible).");
            perfil = cargarPerfil(); // Llamamos al método para cargar perfiles desde el JSON
        }

        return perfil;
    }

    private PerfilUsuario cargarDesdeBD(String dni) {
        String sql = "SELECT * FROM Personas WHERE dni = ?";

        try (Connection con = DataBaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, dni);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    PerfilUsuario p = new PerfilUsuario();

                    p.setNombre(rs.getString("nombre"));
                    p.setTelefono(rs.getString("telefono"));

                    return p;
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al conectar con MariaDB: " + e.getMessage());
        }
        return null;
    }

    // Método para cargar los perfiles del Archivo JSON
    public PerfilUsuario cargarPerfil() {
        ObjectMapper mapper = new ObjectMapper();
        try (InputStream is = getClass().getClassLoader().getResourceAsStream("perfil-usuario.json")) {
            if (is == null) return null;
            return mapper.readValue(is, PerfilUsuario.class);
        } catch (IOException e) {
            return null;
        }
    }
}