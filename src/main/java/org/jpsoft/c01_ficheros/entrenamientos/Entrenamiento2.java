package org.jpsoft.c01_ficheros.entrenamientos;

import java.io.File;
import java.util.Arrays;

/*
Listar el contenido de un directorio: crea un programa que liste los nombres de los archivos y subdirectorios dentro
 de un directorio llamado misArchivos. Si el directorio no existe, el programa debe indicarlo.
 */
public class Entrenamiento2 {

    public static void main(String[] args) {

        File directorio = new File("misArchivos");

        String[] lista = directorio.list();

        if ( lista != null ) {

            if (lista.length == 0)
                System.out.println("El directorio está vacío");
            else {
                for (String s : lista) {
                    System.out.println(s);
                }
            }

        } else
            System.out.println("No existe el directorio");
    }
}
