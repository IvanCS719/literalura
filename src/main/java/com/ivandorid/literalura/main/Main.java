package com.ivandorid.literalura.main;

import com.ivandorid.literalura.models.*;
import com.ivandorid.literalura.repository.IAutorRepository;
import com.ivandorid.literalura.repository.ILibroRepository;
import com.ivandorid.literalura.service.ConsumoApi;
import com.ivandorid.literalura.service.DeserializaDatos;

import java.util.*;

public class Main {
    private ConsumoApi consumoApi = new ConsumoApi();
    private DeserializaDatos deserializaDatos = new DeserializaDatos();
    private Scanner teclado = new Scanner(System.in);
    private List<Libro> librosRegistrados = new ArrayList<>();
    private List<Autor> autoresRegistrados = new ArrayList<>();

    private final String URL_BASE = "https://gutendex.com/books/?search=";

    private IAutorRepository autorRepositorio;
    private ILibroRepository libroRepositorio;

    public Main(IAutorRepository autorRepository, ILibroRepository libroRepository){
        this.autorRepositorio = autorRepository;
        this.libroRepositorio = libroRepository;
    }

    public void ejecutarAplicacion() {
        //Mostrar el menú de opciones para interactuar con el usuario
        int opcion = -1;
        while (opcion != 0) {

            String mensaje = """
                    \n-------------------
                    Elige la opción a través de su número:
                    1- Buscar el libro por el título en Internet para registrarlo
                    2- Listar libros registrados
                    3- Listar Autores registrados
                    4- Listar autores en un determinado año
                    5- Listar libros por idioma
                    0- Salir
                    """;
            try {
                System.out.println(mensaje);
                opcion = teclado.nextInt();
                teclado.nextLine();
            } catch (InputMismatchException e) {
                System.err.println("Debe ingresar un número relacionado con las opciones del menú");
                teclado.nextLine();
            }

            switch (opcion) {
                case 0:
                    System.out.println("Saliendo de LiterAlura...");
                    break;
                case 1:
                    buscarLibroTituloWeb();
                    break;
                case 2:
                    listarLibrosRegistrados();
                    break;
                case 3:
                    listarAutoresRegistrados();
                    break;
                case 4:
                    listarAutoresAnioDeterminado();
                    break;
                case 5:
                    listarLibrosPorIdioma();
                    break;
                default:
                    System.err.println("Opción no válida");
                    break;
            }
        }
    }

    //Obtener y tranformar la respuesta de la API
    private DatosRespuestaGeneral obtenerDatosLibrosWeb() {
        System.out.println("Escribe el título del libro");
        String titulo = teclado.nextLine().toLowerCase().replace(" ", "+");

        String json = consumoApi.obtenerDatos(URL_BASE + titulo);

        return deserializaDatos
                .transformarDatos(json, DatosRespuestaGeneral.class);
    }

    //Buscar el libro mediante el título
    private void buscarLibroTituloWeb() {
        DatosRespuestaGeneral datos = obtenerDatosLibrosWeb();

        Optional<Libro> libro = datos.libros().stream()
                .findFirst()
                .map(l -> new Libro(l.titulo(), l.autor().stream()
                        .findFirst()
                        .map(a -> new Autor(a.nombreAutor(), a.anio_nacimiento(),
                                a.anio_fallecimiento()))
                        .orElse(new Autor("Desconocido",
                                0, 0)),
                        l.idiomas(), l.numeroDescargas()));

        if (libro.isPresent()) {
            comprobarRegistroDelLibro(libro.get());
        } else {
            System.out.println("*** Libro no encontrado ***");
        }
    }

    //Listar todos los libros registrados
    private void listarLibrosRegistrados() {
        List<Libro> libroList = libroRepositorio.todosLosLibrosRegistrados();
        System.out.println("\nSus Libros Registrados:");
        libroList.forEach(System.out::println);
    }

    //Comprobar que al registrar un libro no este dublicado
    private void comprobarRegistroDelLibro(Libro libro) {

        System.out.println(libro);

        Optional<Libro> libroEncontrado = libroRepositorio.findByTitulo(libro.getTitulo());

        if (libroEncontrado.isPresent()) {
            System.out.println("\n*** Este libro ya esta regitrado ***");
            return;
        }

        Optional<Autor> autorEncontrado = autorRepositorio.findByNombreAutor(libro.getAutor().getNombreAutor());

        if (autorEncontrado.isPresent()){
            libro.setAutor(autorEncontrado.get());
        }else {
            autorRepositorio.save(libro.getAutor());
        }

        libroRepositorio.save(libro);
        System.out.println("\n*** El libro se ha agregado a su registro ***");

    }

    //Listar todos los autores registrados
    private void listarAutoresRegistrados() {
        System.out.println("\nAutores Registrados:");
        List<Autor> autorList = autorRepositorio.findAll();
        autorList.forEach(System.out::println);
    }

    //Listar todos los autores vivos en un determinado año
    private void listarAutoresAnioDeterminado() {
        try {
            System.out.println("Ingrese el año para buscar autores vivos");

            int anioVivo = teclado.nextInt();

            System.out.println("Autores vivos en el año " + anioVivo + ":");

            List<Autor> autorList = autorRepositorio.encontrarAutorVivoPorAnio(anioVivo);

            autorList.forEach(System.out::println);

        }catch (InputMismatchException e) {
            System.err.println("Debe ingresar un número que represente el año " +
                    "que los autores estuvieron vivos");
            teclado.nextLine();
        }
    }

    //Listar libros por idioma
    public void listarLibrosPorIdioma(){
        String mensaje = """
                Ingrese el idioma para buscar los libros:
                es -> Español
                en -> Inglés
                fr -> Francés
                pt -> Portugués
                """;
        System.out.println(mensaje);
        String idioma = teclado.nextLine();

        List<Libro> libroList = libroRepositorio.librosPorIdioma(idioma);

        System.out.println("Total de libros en el idioma seleccionado: " + libroList.size());
        libroList.forEach(System.out::println);

    }
}
