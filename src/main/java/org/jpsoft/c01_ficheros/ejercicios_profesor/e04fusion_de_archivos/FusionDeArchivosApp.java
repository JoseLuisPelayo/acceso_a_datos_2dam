package org.jpsoft.c01_ficheros.ejercicios_profesor.e04fusion_de_archivos;

import org.jpsoft.mis_utilidades.FileUtils;
import org.jpsoft.mis_utilidades.ScannerValidator;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FusionDeArchivosApp {

    private static final String menu;
    private static final Scanner sc;
    private static final File baseFolder;

    static {
        menu = "¿Añadir línea en blanco entre archivos? (Y/N): ";
        sc = new Scanner(System.in);
        baseFolder = new File("src/main/resources");
    }

    public static void main(String[] args) {
        File f1 = new File("src/main/resources/prueba.txt");
        File f2 = new File("src/main/resources/prueba1.txt");
        File f3 = new File("src/main/resources/pueba1.txt");

        List<File> files = new ArrayList<>();
        files.add(f1);
        files.add(f2);
        files.add(f3);

        System.out.print("Escribe el nombre del archivo donde los quieras fusionar: ");
        File fusion = new File(baseFolder, "/" + sc.nextLine());

        if (FileUtils.ensureFile(fusion, sc)) {
            System.out.println(menu);

            try (PrintWriter pw = new PrintWriter(new FileWriter(fusion, true))) {

                boolean appendLines = ScannerValidator.yesOrNoValidator(sc, menu);
                filesFusion(files, pw, appendLines);

            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        sc.close();
    }

    private static void filesFusion(List<File> files, PrintWriter pw ,boolean lineAppend) {
        files.forEach(file -> {
            if (file.exists() && file.canRead()) {
                try (BufferedReader bf = new BufferedReader(new FileReader(file))) {

                    while (bf.ready()) {
                        pw.println(bf.readLine());
                    }

                    if (lineAppend) {
                        pw.print("\n");
                    }

                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }

            } else
                System.out.println(file.getAbsolutePath() + " no existe el archivo o no se legible.");
        });
    }
}

