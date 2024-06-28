package com.ivandorid.literalura.repository;

import com.ivandorid.literalura.models.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IAutorRepository extends JpaRepository<Autor, Long> {
    //Encontra autor registrado
    Optional<Autor> findByNombreAutor(String nombreAutor);
}
