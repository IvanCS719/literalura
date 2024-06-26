package com.ivandorid.literalura.repository;

import com.ivandorid.literalura.models.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ILibroRepository extends JpaRepository<Libro, Long> {
    //Encontra libro registrado
    Optional<Libro> findByTitulo(String titulo);

    @Query("SELECT l FROM Libro l JOIN FETCH l.autor")
    List<Libro> todosLosLibrosRegistrados();

    @Query(value = "SELECT * FROM libros WHERE ?1 = ANY(idiomas)", nativeQuery = true)
    List<Libro> librosPorIdioma(String idioma);

    @Query("SELECT l FROM Libro l ORDER BY l.numeroDescargas DESC LIMIT 10")
    List<Libro> obtenerTop10LibrosMasDescargados();

}
