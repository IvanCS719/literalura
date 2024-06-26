package com.ivandorid.literalura.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsumoApi {

    //Obtener datos de la API
    public String obtenerDatos(String urlApi) {
        try {
            //Se crea el cliente para enviar la solicitud
            HttpClient client = HttpClient.newHttpClient();

            //Se crea la solicitud GET para la API
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(urlApi))
                    .build();

            //Se envía la solicitud utilizando el client
            //Se recibe la respuesta como un String
            HttpResponse<String> response = client.send(request,
                    HttpResponse.BodyHandlers.ofString());

            return response.body();
        } catch (IOException | InterruptedException e) {
            System.err.println("Error al conectar con el API: " + e.getMessage());
        }
        return null;
    }
}
