package com.ivandorid.literalura.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

//Deserializar la respuesta del API
@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosRespuestaGeneral(
        @JsonAlias("results") List<DatosLibro> libros
        ) {
}
