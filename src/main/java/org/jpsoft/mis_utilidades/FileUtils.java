package org.jpsoft.mis_utilidades;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FileUtils {

    public static Boolean ensureFile(File file, Scanner scanner) {
        String options = """
                    ¿Deseas crear el fichero?
                    [y] -> Si  [n] -> No
                    """;

        if (!file.exists()) {
            System.out.printf("No existe el archivo %s\n", file.getAbsolutePath());
            System.out.println(options);
            System.out.print("Introduce una opción: ");
            if (ScannerValidator.yesOrNoValidator(scanner,  options)) {
                try {
                    file.createNewFile();
                    return true;
                } catch (IOException e) {
                    System.out.println(e.getMessage());;
                }
            }  else  {
                return false;
            }
        }

        return true;
    }


}
