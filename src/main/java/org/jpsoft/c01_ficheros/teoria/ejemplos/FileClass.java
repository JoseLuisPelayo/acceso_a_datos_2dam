package org.jpsoft.c01_ficheros.teoria.ejemplos;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class FileClass {

    public static void main(String[] args) {
        /*
          La clase File de Java, ubicada en el paquete java.io, representa abstracciones de
          archivos y directorios en el sistema de archivos. Aunque no permite la lectura o
          escritura directa de datos, proporciona métodos para manipular y obtener
          información sobre archivos y directorios, como crear, eliminar, veriﬁcar existencia y
          listar contenidos.
         */

        System.out.println("\n********************* linea 17 creando objetos clase File **********************************");

        File file01 = new File("src/main/resources/ruta_relativa_o_absoluta.txt");
        // Obtenemos la ruta absoluta del File que acabamos de crear
        System.out.println("Ruta absoluta de file01: " + file01.getAbsolutePath());


        //Podemos crear un file con el path del padre y el nombre del hijo o fichero como parametros separados
        File file02 = new File("resources/directorio_padre", "archivo_de_texto.txt");

        //El padre tambien puede ser un File
        File filePadre = new File("src/main/resources");
        File file03 = new File(filePadre, "archivo_de_texto.txt");

        System.out.println("\n********************* linea 31 creando nuevos archivos **********************************");

        //Crear nuevos archivos
        try {
            if (new File(filePadre, "fichero_creado01.txt").createNewFile())
                System.out.println("Fichero creado correctamente");
            else
                System.out.println("El fichero ya existe");
        } catch (IOException e){
            System.out.println("Error al crear el fichero");
            System.out.println(e.getMessage());
        }

        System.out.println("\n********************* linea 44 creando nuevos directorios **********************************");

        //Crear un nuevo directorio
        File nuevoDirectorio = new File(filePadre, "nuevoDirectorio");

        if (nuevoDirectorio.mkdir()) {
            System.out.println("Directorio " + nuevoDirectorio.getName() + " creado correctamente");
        } else
            System.out.println("Error al crear el fichero");


        System.out.println("\n********************* linea 55 Comprobación legibilidad, escritura y existencia de archivos **********************************");

        //Comprobar si el archivo es legible se puede escribir y si existe
    File file04 = new File(filePadre, "fichero_creado01.txt");

    if (file04.exists()) {
        System.out.println("El fichero existe");

        System.out.println("¿Puedo leer el fichero? " + file04.canRead());
        System.out.println("Puedo escribir el fichero? " + file04.canWrite());
    } else
        System.out.println("El fichero no existe");

    System.out.println("\n********************* linea 68 Listar contenido de directorios **********************************");
    if (filePadre.isDirectory()) {
        String[] contenido = filePadre.list();

        if (contenido != null)
            Arrays.stream(contenido).forEach(System.out::println);
        else
            System.out.println("No se pudo obtener el contenido");
    } else
        System.out.println("La ruta no es un directorio");

    System.out.println("\n********************* linea 80 Eliminar archivos y directorios **********************************");
        //Eliminar archivo
        if (file04.delete())
            System.out.println("El fichero "  + file04.getName() + " eliminado correctamente");
        else
            System.out.println("Error al eliminar el fichero");

        //Eliminar directorio vacío
        if (nuevoDirectorio.delete())
            System.out.println("Directorio "  + nuevoDirectorio.getName() + " eliminado correctamente");
        else
            System.out.println("Error al eliminar el directorio. Asegúrese que está vacío.");





    }


}
