package com.ivandorid.literalura.service;

public interface IDeserializaDatos {
    <T> T transformarDatos(String json, Class<T> clase);
}
