package org.jpsoft.c01_ficheros.clases.clase1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Operaciones {
    public void informacionFichero(String file) {
        File fileFichero = new File(file);

        if (!fileFichero.exists()) {
            try {
                System.out.println(fileFichero.createNewFile());
            } catch (IOException e) {
                System.out.println(e.getMessage());;
            }
        } else {
            System.out.println(fileFichero.exists());
            System.out.println(fileFichero.isFile());
            System.out.println(fileFichero.canRead());
            System.out.println(fileFichero.canWrite());
            System.out.println(fileFichero.canExecute());
            System.out.println(fileFichero.isDirectory());
        }

    }

    public void escribirFichero(String file) {
        File fileFichero = new File(file);

        try(FileWriter fw = new FileWriter(fileFichero)) {
            fw.write("Esto es un ejemplo de escritura para la clase");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void escribirFicheroCifrado(String file, String msg) {
        File fileFichero = new File(file);

        try(FileWriter fw = new FileWriter(fileFichero)) {
            for (int i = 0; i < msg.length(); i++) {
                char letra = msg.charAt(i);
                fw.write((int)letra * 1234);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void escrituraSuperior(String file) {
        File fileFichero = new File(file);

        try(PrintWriter pw = new PrintWriter(new FileWriter(file, true))) {
            pw.println("Esto es un ejemplo de escritura para la clase con buffer");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
