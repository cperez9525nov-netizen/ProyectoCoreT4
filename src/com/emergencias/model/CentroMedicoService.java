package com.emergencias.model;

import java.io.File;
import java.util.List;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CentroMedicoService {
    public List<CentroMedico> cargarCentros() {
        ObjectMapper mapper = new ObjectMapper();
        //quiero que ignore mayúsculas y minúsculas
        mapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
        try {
            // Buscamos el archivo como un "recurso" del sistema
            // IMPORTANTE: Nota la "/" al principio y la ruta completa de paquetes
            var inputStream = getClass().getResourceAsStream("/com/emergencias/model/centros_alicante.json");

            if (inputStream == null) {
                System.err.println("❌ Error: El ClassLoader no encuentra el archivo en la ruta de paquetes.");
                return null;
            }

            return mapper.readValue(inputStream, new TypeReference<List<CentroMedico>>() {});
        } catch (Exception e) {
            System.err.println("❌ Error al procesar el JSON: " + e.getMessage());
            return null;
        }
    }
}
