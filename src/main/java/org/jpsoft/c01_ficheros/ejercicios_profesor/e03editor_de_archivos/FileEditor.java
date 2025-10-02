package org.jpsoft.c01_ficheros.ejercicios_profesor.e03editor_de_archivos;

import org.jpsoft.mis_utilidades.ScannerValidator;

import java.io.*;
import java.util.Scanner;

public class FileEditor {

    private final Scanner sc;

    public FileEditor(Scanner sc) {
        this.sc = sc;
    }

    public void fileEditorMenu(File file) throws IOException {
        int option = 0;

        do {
            option = drawMenu(file);
            switch (option) {
                case 1 -> {
                    System.out.println(MenuPrinter.fileEditionMenu(file.getAbsolutePath(), fileText(file)));
                }
                case 2 -> System.out.println("H");
            }
        } while (option != 3);

    }

    private int drawMenu(File file) throws IOException {
        System.out.println(MenuPrinter.fileEditionMenu(file.getAbsolutePath(), fileText(file)));
        int option = ScannerValidator.integerValidator(sc, MenuPrinter.fileEditionMenu(file.getAbsolutePath(), fileText(file)));

        while (option < 0 || option > 3) {
            System.err.println("Opción no valida");
            System.out.println(MenuPrinter.fileEditionMenu(file.getAbsolutePath(), fileText(file)));
            option = ScannerValidator.integerValidator(sc, MenuPrinter.fileEditionMenu(file.getAbsolutePath(), fileText(file)));
        }

        return option;
    }

    private void addTextToEndOfFile(File file) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))) {

        }
    }

    private static String fileText(File file) throws IOException {
        StringBuilder builder = new StringBuilder();

        try (BufferedReader bf = new BufferedReader(new FileReader(file))) {

            while (bf.ready()) {
                builder.append(bf.readLine()).append("\n");
            }
        }
        return builder.toString();
    }

    private static File filePromp() {
        return null;
    }
}
