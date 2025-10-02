package org.jpsoft.c01_ficheros.ejercicios_profesor;

import java.io.File;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class E01ListarArchivos {
    /*
    Crea un programa que solicite al usuario una ruta de directorio y muestre una lista de todos los archivos y
    subdirectorios contenidos en él. Para cada elemento, indica si es un archivo o un directorio, su tamaño en bytes
    (si es un archivo) y la fecha de última modificación.

    Ejemplo de entrada: Ruta: C:/Users/usuario/Documents

    Ejemplo de salida:
                Directorio: C:/Users/usuario/Documents
                - [ARCHIVO] informe.pdf (245678 bytes) - Última modificación: 23/09/2025 09:45
                - [DIRECTORIO] Proyectos - Última modificación: 20/09/2025 14:30
                - [ARCHIVO] presupuesto.xlsx (35420 bytes) - Última modificación: 15/09/2025 11:20
                - [DIRECTORIO] Imágenes - Última modificación: 10/09/2025 16:15
    */

//    private static final String path = "/home/jose/Documentos/aws";


    private static final String template = "\n- [%s] %s %s- Última modificación: %s";

    public static void directoryList(String path) {
        File folder = new File(path);

        if (!folder.exists()) System.out.printf("El fichero %s no existe\n", path);
        else if (!folder.isDirectory())
            System.out.printf("El path proporcionado: %s es de un fichero, debe ser de un directorio.%n", path);
        else {
            File[] files = folder.listFiles();
            System.out.printf("\nDirectorio: %s", path);
            if (files.length == 0) System.out.printf("El directorio %s está vacío.%n", path);
            else {
                Arrays.stream(files).forEach(f -> {
                    System.out.printf((template), typeOfFile(f), f.getName(), fileSize(f), dateFromMilliseconds(f));
                });
            }
        }
    }

    public static void directoryList(String path, Boolean recursivity) {
        File folder = new File(path);

        if (!folder.exists()) System.out.printf("El fichero %s no existe\n", path);
        else if (!folder.isDirectory())
            System.out.printf("El path proporcionado: %s es de un fichero, debe ser de un directorio.%n", path);
        else {
            File[] files = folder.listFiles();
            System.out.printf("\nDirectorio: %s", path);
            if (files.length == 0) System.out.printf("El directorio %s está vacío.%n", path);
            else {
                Arrays.stream(files).forEach(f -> {
                    System.out.printf((template), typeOfFile(f), f.getName(), fileSize(f), dateFromMilliseconds(f));
                    if (f.isDirectory() && recursivity) {
                        directoryList(f.getAbsolutePath(), true);
                    }
                });
            }
        }
    }

    private static String typeOfFile(File f) {
        if (f.isFile()) return "ARCHIVO";
        else return "DIRECTORIO";
    }

    private static String dateFromMilliseconds(File f) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm").withZone(ZoneId.of("UTC"));
        return formatter.format(Instant.ofEpochMilli(f.lastModified()));
    }

    private static String fileSize(File f) {
        long size = f.length();

        return f.isFile() ? String.format("(%d bytes) ", size) : "";
    }

}