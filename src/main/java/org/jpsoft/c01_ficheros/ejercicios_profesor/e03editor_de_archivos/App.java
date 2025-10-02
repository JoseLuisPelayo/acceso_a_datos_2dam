package org.jpsoft.c01_ficheros.ejercicios_profesor.e03editor_de_archivos;

import org.jpsoft.mis_utilidades.ScannerValidator;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class App {
    private static final Scanner sc;
    private static final File baseFolder;

    static {
        sc = new Scanner(System.in);
        baseFolder = new File("src/main/resources");
    }

    public static void main(String[] args) {
        int opcion = 0;

        do {
            opcion = drawMenu();

            try {
                switch (opcion) {
                    case 1 -> createTextFile();
                    case 2 ->{
                        new FileEditor(sc).fileEditorMenu(new File(baseFolder, "prueba.txt"));
                    }
                }

            } catch (IOException e) {
                System.out.println(e.getMessage());
            }

        } while (opcion != 3);

        sc.close();
}

private static int drawMenu() {
    System.out.print(MenuPrinter.mainMenu());
    int opcion = ScannerValidator.integerValidator(sc, MenuPrinter.mainMenu());

    while (opcion < 0 || opcion > 3) {
        System.err.println("Opción no valida");
        System.out.print(MenuPrinter.mainMenu());
        opcion = ScannerValidator.integerValidator(sc, MenuPrinter.mainMenu());
    }

    return opcion;
}

private static void createTextFile() {
    try {
        String template = "%s.txt";

        System.out.print("Introduce el nombre del archivo: ");
        File file = new File(String.format("%s/%s.txt", baseFolder, sc.next()));

        if (file.exists()) {
            System.out.println("El archivo existe");
        } else if (file.createNewFile())
            System.out.printf("Archivo creado correctamente en: %s", file.getAbsolutePath());
        else
            System.out.println("Ocurrió un error inesperado");
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
}

}
