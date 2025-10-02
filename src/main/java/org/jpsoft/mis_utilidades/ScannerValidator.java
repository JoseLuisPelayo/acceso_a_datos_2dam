package org.jpsoft.mis_utilidades;

import java.util.Scanner;

public class ScannerValidator {

    public static int integerValidator(Scanner scanner, String msj) {
        while (true) {
            if (scanner.hasNextInt()) return scanner.nextInt();
            else {
                System.err.println("Debes introducir un número.");
                System.out.print(msj);
                scanner.next();
            }
        }
    }

}
