package com.ivandorid.literalura.main;

import com.ivandorid.literalura.models.Autor;
import com.ivandorid.literalura.models.DatosRespuestaGeneral;
import com.ivandorid.literalura.models.Libro;
import com.ivandorid.literalura.service.ConsumoApi;
import com.ivandorid.literalura.service.DeserializaDatos;

import java.util.Optional;
import java.util.stream.Collectors;

public class Main {
    ConsumoApi consumoApi = new ConsumoApi();
    DeserializaDatos deserializaDatos = new DeserializaDatos();

    public void EJcutarAplicacion(){
        String json = consumoApi.obtenerDatos("https://gutendex.com/books/?search=great+expectations");

        DatosRespuestaGeneral datos = deserializaDatos.transformarDatos(
                json, DatosRespuestaGeneral.class);

        Optional<Libro> libro = datos.libros().stream()
                .findFirst()
                .map(l -> new Libro(l.titulo(), l.autor().stream()
                                .findFirst()
                        .map(a -> new Autor(a.nombreAutor(), a.anio_nacimiento(),
                                a.anio_fallecimiento()))
                        .orElse(new Autor("Desconocido",
                                0, 0)),
                        l.idiomas(), l.numeroDescargas()));
        if (libro.isPresent()){
            System.out.println(libro.get());
        }else {
            System.out.println("Libro no encontrado");
        }
    }
}
