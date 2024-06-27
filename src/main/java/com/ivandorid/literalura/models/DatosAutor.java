package com.ivandorid.literalura.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//Deserializar los datos del Autor
@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosAutor(
    @JsonAlias("name") String nombreAutor,
    @JsonAlias("birth_year") Integer anio_nacimiento,
    @JsonAlias("death_year") Integer anio_fallecimiento
) {
}
