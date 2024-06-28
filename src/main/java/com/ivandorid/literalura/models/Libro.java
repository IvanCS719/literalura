package com.ivandorid.literalura.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "libros")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String titulo;
    private List<String> idiomas;
    private Integer numeroDescargas;
    @ManyToOne
    private Autor autor;

    public Libro() {
    }

    public Libro(String titulo, Autor autor, List<String> idiomas, Integer numeroDescargas) {
        this.titulo = titulo;
        this.autor = autor;
        this.idiomas = idiomas;
        this.numeroDescargas = numeroDescargas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo(){
        return this.titulo;
    }

    public void setTitulo(String titulo){
        this.titulo = titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public List<String> getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(List<String> idiomas) {
        this.idiomas = idiomas;
    }

    public Integer getNumeroDescargas() {
        return numeroDescargas;
    }

    public void setNumeroDescargas(Integer numeroDescargas) {
        this.numeroDescargas = numeroDescargas;
    }

    @Override
    public String toString() {
        return "\n---------- LIBRO ----------" +
                "\nTítulo: " + titulo +
                "\nAutor: " + autor.getNombreAutor() +
                "\nIdiomas: " + String.join(", ", idiomas) +
                "\nNúmero de descargas: " + numeroDescargas +
                "\n---------------------------";
    }
}
