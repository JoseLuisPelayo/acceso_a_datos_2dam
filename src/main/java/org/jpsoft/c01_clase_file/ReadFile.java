package org.jpsoft.c01_clase_file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.util.stream.Stream;

public class ReadFile {
    public static void main(String[] args) {
        File file = new File("src/main/resources/películas.txt");

        //Otra manera de instancias un buffer mas moderna
        // BufferedReader br = Files.newBufferedReader(Path.of(file.toPath())
        // Files es el paquete moderno para manejar archivos de java.nio
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;

            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo " + e.getMessage());
            e.printStackTrace();
        }

        System.out.println("\n ********************* Más Moderno *************************");

        //Una manera mas moderna de hacerlo
        try (Stream<String> lines = Files.lines(file.toPath())) {
            lines.forEach(System.out::println);
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
            e.printStackTrace();
        }

    }
}
