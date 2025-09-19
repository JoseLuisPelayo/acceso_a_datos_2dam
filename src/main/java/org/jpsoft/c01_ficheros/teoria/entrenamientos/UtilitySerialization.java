package org.jpsoft.c01_ficheros.teoria.entrenamientos;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public abstract class UtilitySerialization {

    public static <T extends Serializable> void serializeObjects(File file, T obj) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(obj);
        }
    }

    public static <T extends Serializable> void serializeObjects(File file, List<T> obj) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            for (Object object : obj) {
                oos.writeObject(object);
            }
        }
    }

    public static <T extends Serializable> List<T> deserializeObjects(File file, Class<T> classType) throws IOException, ClassNotFoundException {
        List<T> lista = new ArrayList<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {

            while (true) {
                lista.add(classType.cast(ois.readObject()));
            }

        } catch (EOFException e) {
            return lista;
        }
    }

}
