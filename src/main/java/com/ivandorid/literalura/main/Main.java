package com.ivandorid.literalura.main;

import com.ivandorid.literalura.models.DatosRespuestaGeneral;
import com.ivandorid.literalura.service.ConsumoApi;
import com.ivandorid.literalura.service.DeserializaDatos;

public class Main {
    ConsumoApi consumoApi = new ConsumoApi();
    DeserializaDatos deserializaDatos = new DeserializaDatos();

    public void EJcutarAplicacion(){
        String json = consumoApi.obtenerDatos("https://gutendex.com/books/?search=great+expectations");

        DatosRespuestaGeneral datos = deserializaDatos.transformarDatos(
                json, DatosRespuestaGeneral.class);

        System.out.println(datos);
    }
}
