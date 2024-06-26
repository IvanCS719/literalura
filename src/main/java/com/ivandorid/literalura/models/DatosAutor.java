package com.ivandorid.literalura.models;

import com.fasterxml.jackson.annotation.JsonAlias;

//Deserializar los datos del Autor
public record DatosAutor(
    @JsonAlias("name") String nombreAutor,
    @JsonAlias("birth_year") Integer anio_nacimiento,
    @JsonAlias("death_year") Integer anio_fallecimiento
) {
}
