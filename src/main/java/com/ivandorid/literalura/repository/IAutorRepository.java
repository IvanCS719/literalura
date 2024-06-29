package com.ivandorid.literalura.repository;

import com.ivandorid.literalura.models.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface IAutorRepository extends JpaRepository<Autor, Long> {
    //Encontra autor registrado
    Optional<Autor> findByNombreAutor(String nombreAutor);

    @Query("SELECT a FROM Autor a WHERE :anio >= anio_nacimiento AND :anio <= anio_fallecimiento")
    List<Autor> encontrarAutorVivoPorAnio(Integer anio);
}
