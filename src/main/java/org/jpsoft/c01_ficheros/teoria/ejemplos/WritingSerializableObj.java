package org.jpsoft.c01_ficheros.teoria.ejemplos;

import java.io.*;

public class WritingSerializableObj {
    public static void main(String[] args) {

        File directorioDestino = new File("src" + File.separator + "main" + File.separator + "resources");
        File ficheroDestino = new File(directorioDestino, "fichero_de_datos.dat");

        InterfazSerializable objetoSerializable = new InterfazSerializable(
                "Jose",
                40,
                "23444233",
                "Antes era un cocodrilo"
        );

        // El oos necesita un file output stream (fos) con el fichero;
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ficheroDestino))) {

            ficheroDestino.createNewFile();

            System.out.println(objetoSerializable);
            oos.writeObject(objetoSerializable);

            System.out.println("Objeto serializable guardado correctamente.");
        } catch (IOException e) {
            System.out.println("Error al guardar objeto serializable: "  + e.getMessage());
        }


        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ficheroDestino))) {

            InterfazSerializable obj = (InterfazSerializable) ois.readObject();
            System.out.println("Objeto serializable leido correctamente.");

            System.out.println(obj);

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al leer objeto serializable: "  + e.getMessage());
        }




    }
}
