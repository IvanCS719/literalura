package com.ivandorid.literalura.main;

import com.ivandorid.literalura.models.Autor;
import com.ivandorid.literalura.models.DatosRespuestaGeneral;
import com.ivandorid.literalura.models.Libro;
import com.ivandorid.literalura.service.ConsumoApi;
import com.ivandorid.literalura.service.DeserializaDatos;

import java.util.InputMismatchException;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    private ConsumoApi consumoApi = new ConsumoApi();
    private DeserializaDatos deserializaDatos = new DeserializaDatos();
    private Scanner teclado = new Scanner(System.in);

    private final String URL_BASE = "https://gutendex.com/books/?search=";

    public void ejecutarAplicacion() {
        int opcion = -1;

        while (opcion != 0) {
            try {
                String mensaje = """
                        \n*****************
                        Elige la opción a través de su número:
                        1- Buscar el libro por el título en Internet para registrarlo
                        2- Listar libros registrados
                        3- Listar Autores registrados
                        4- Listar autores en un determinado año
                        5- Listar libros por idioma
                        0- Salir
                        """;

                System.out.println(mensaje);
                opcion = teclado.nextInt();
                teclado.nextLine();

                switch (opcion) {
                    case 0:
                        System.out.println("Saliendo de LiterAlura...");
                        break;
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                    default:
                        System.err.println("Opción no válida");
                        break;
                }
            } catch (InputMismatchException e) {
                System.err.println("Debe ingresar un número relacionado con las opciones del menú");
                teclado.nextLine(); // Consumir la entrada inválida
            }
        }
    }
}
