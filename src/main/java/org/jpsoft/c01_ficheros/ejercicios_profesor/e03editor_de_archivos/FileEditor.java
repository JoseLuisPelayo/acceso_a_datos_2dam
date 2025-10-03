package org.jpsoft.c01_ficheros.ejercicios_profesor.e03editor_de_archivos;

import org.jpsoft.mis_utilidades.ScannerValidator;

import java.io.*;
import java.util.Scanner;

public class FileEditor {

    private final Scanner sc;

    public FileEditor(Scanner sc) {
        this.sc = sc;
    }

    public void fileEditorMenu(File file) {
        int option = 0;

        do {
            option = drawMenu(file);
            switch (option) {
                case 1 -> {
                   overrideTextFile(file);
                }
                case 2 -> {
                    addTextToEndOfFile(file);
                }
            }
        } while (option != 3);

    }

    private int drawMenu(File file) {
        System.out.println(MenuPrinter.fileEditionMenu(file.getAbsolutePath(), textFileReader(file)));
        int option = ScannerValidator.integerValidator(sc, MenuPrinter.fileEditionMenu(file.getAbsolutePath(), textFileReader(file)));

        while (option < 0 || option > 3) {
            System.err.println("Opción no valida");
            System.out.println(MenuPrinter.fileEditionMenu(file.getAbsolutePath(), textFileReader(file)));
            option = ScannerValidator.integerValidator(sc, MenuPrinter.fileEditionMenu(file.getAbsolutePath(), textFileReader(file)));
        }

        return option;
    }

    private static String textFileReader(File file) {
        StringBuilder builder = new StringBuilder();

        try (BufferedReader bf = new BufferedReader(new FileReader(file))) {

            while (bf.ready()) {
                builder.append(bf.readLine()).append("\n");
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return builder.toString();
    }

    private void addTextToEndOfFile(File file) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(file, true))) {
            System.out.print("Introduce la linea que quieres añadir: ");
            sc.nextLine();
            String line = sc.nextLine();
            pw.println(line);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private void overrideTextFile(File file) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(file))) {
            System.out.print("Introduce el texto que quieras escribir en el archivo: ");
            sc.nextLine();
            String line = sc.nextLine();
            pw.println(line);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
