package com.alura.oramar.literatura.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

@Component
public class JsonParser {

    private final ObjectMapper objectMapper = new ObjectMapper();

    public <T> T convertirDatos(String json, Class<T> clase) {

        try {
            return objectMapper.readValue(json, clase);
        } catch (Exception e) {
            throw new RuntimeException("Error al convertir JSON", e);
        }
    }
}