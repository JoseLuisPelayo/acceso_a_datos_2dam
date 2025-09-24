package org.jpsoft.c01_ficheros.entrenamientos;

/*
Planteamiento del ejercicio Crear un archivo: escribe un programa en Java que cree un archivo llamado miArchivo.txt en
el directorio actual. Si el archivo ya existe, el programa debe mostrar un mensaje indicando que el archivo
ya estaba creado.
 */

import java.io.File;
import java.io.IOException;

public class Entrenamiento1 {

    public static void main(String[] args) {
        try {

            if (new File("miArchivo.txt").createNewFile())
                System.out.println("Archivo creado correctamente.");
            else
                System.out.println("Ha ocurrido algún error o el archivo ya existe.");

        } catch (IOException ex) {
            System.out.println("Error al crear el archivo." + ex.getMessage());
        }


    }

}
