package org.jpsoft.c01_ficheros.teoria.entrenamientos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/*
Leer un archivo línea por línea: escribe un programa que lea el contenido de un archivo de texto llamado datos.txt
y muestre solo aquellas líneas que contengan la palabra «hola» en la consola. Maneja las posibles
excepciones si el archivo no existe.
 */
public class Entrenamiento3 {

    private static final File archivo = new File("src/main/java/org/jpsoft/c01_ficheros/teoria/entrenamientos/datos_e3.txt");

    public static void main(String[] args) {

        String line;

        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {

            while((line = reader.readLine()) != null) {
                if (line.toLowerCase().contains("hola"))
                    System.out.println(line);
            }

        } catch (IOException e) {
            System.out.println("Error al leer el archivo " + e.getMessage());
        }

    }
}
