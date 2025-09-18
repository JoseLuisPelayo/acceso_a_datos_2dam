package org.jpsoft.c01_clase_file;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WritingFile {

    public static void main(String[] args) {
        File file = new File("src/main/resources/películas.txt");

        String[] peliculas = {"El padrino", "Pulp fiction", "La La Land"};

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file.getAbsolutePath()))) {

            for (String p : peliculas) {
                bufferedWriter.write(p);
                bufferedWriter.newLine();
            }

            System.out.println("Las peliculas se han escrito correctamente en el archivo");

        } catch (IOException e) {
            System.out.println("Error al escribir el archivo "  + e.getMessage());
        }


    }
}
