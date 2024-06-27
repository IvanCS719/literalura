package com.ivandorid.literalura.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DeserializaDatos implements IDeserializaDatos {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public <T> T transformarDatos(String json, Class<T> clase) {
        try {
            return objectMapper.readValue(json, clase);
        }catch (JsonProcessingException e){
            System.err.println("No se puedo deserializar la respueta de la API: "
            + e.getMessage());
        }
        return null;
    }
}
