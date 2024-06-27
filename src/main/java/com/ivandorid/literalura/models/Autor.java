package com.ivandorid.literalura.models;

public class Autor {
    private String nombreAutor;
    private Integer anio_nacimiento;
    private Integer anio_fallecimiento;

    public Autor(String nombreAutor, Integer anio_fallecimiento, Integer anio_nacimiento) {
        this.nombreAutor = nombreAutor;
        this.anio_fallecimiento = anio_fallecimiento;
        this.anio_nacimiento = anio_nacimiento;
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

    @Override
    public String toString() {
        return "---------- Autor ----------" +
                "\nNombre: " + nombreAutor +
                "\nAño de nacimiento: " + anio_nacimiento +
                "\nAño de fallecimiento: " + anio_fallecimiento +
                "\n---------------------------";
    }
}
