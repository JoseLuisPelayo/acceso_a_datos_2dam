package org.jpsoft.c01_ficheros.clases;

import org.jpsoft.c01_ficheros.clases.clase1.Operaciones;

public class EntradaTema1 {

    public static void main(String[] args) {
        Operaciones ops = new Operaciones();
        String file = "src/main/resources/prueba1.txt";
//        ops.informacionFichero(file);
//        ops.escribirFichero(file);
//        String mensajeParaCifrar = "Esto es un mensaje cifrado con las preguntas del examen";
//        ops.escribirFicheroCifrado(file, mensajeParaCifrar);
        ops.escrituraSuperior(file);


    }
}
