package org.jpsoft.c02_xml.clases.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Pelicula {
    private String nombre;
    private String director;
    private String genero;
    private Actor[] actores;
    private int anio;
    private double calificacion;
    private String src;


}
