package com.ivandorid.literalura.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "autores")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String nombreAutor;
    private Integer anio_nacimiento;
    private Integer anio_fallecimiento;
    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Libro> libros;

    public Autor() {
    }

    public Autor(String nombreAutor, Integer anio_nacimiento, Integer anio_fallecimiento) {
        this.nombreAutor = nombreAutor;
        this.anio_nacimiento = anio_nacimiento;
        this.anio_fallecimiento = anio_fallecimiento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreAutor() {
        return nombreAutor;
    }

    public void setNombreAutor(String nombreAutor) {
        this.nombreAutor = nombreAutor;
    }

    public Integer getAnio_nacimiento() {
        return anio_nacimiento;
    }

    public void setAnio_nacimiento(Integer anio_nacimiento) {
        this.anio_nacimiento = anio_nacimiento;
    }

    public Integer getAnio_fallecimiento() {
        return anio_fallecimiento;
    }

    public void setAnio_fallecimiento(Integer anio_fallecimiento) {
        this.anio_fallecimiento = anio_fallecimiento;
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }

    @Override
    public String toString() {
        return "\n---------- Autor ----------" +
                "\nNombre: " + nombreAutor +
                "\nAño de nacimiento: " + anio_nacimiento +
                "\nAño de fallecimiento: " + anio_fallecimiento +
                "\nLibros: " + libros.stream().map(Libro::getTitulo).toList() +
                "\n---------------------------";
    }
}
