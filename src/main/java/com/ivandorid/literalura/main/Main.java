package com.ivandorid.literalura.main;

import com.ivandorid.literalura.service.ConsumoApi;

public class Main {
    ConsumoApi consumoApi = new ConsumoApi();
    public void EJcutarAplicacion(){
        System.out.println(consumoApi.obtenerDatos("https://gutendex.com/books/"));
    }
}
