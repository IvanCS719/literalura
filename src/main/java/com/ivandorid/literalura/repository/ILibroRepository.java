package com.ivandorid.literalura.repository;

import com.ivandorid.literalura.models.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ILibroRepository extends JpaRepository<Libro, Long> {
    //Encontra libro registrado
    Optional<Libro> findByTitulo(String titulo);
}
