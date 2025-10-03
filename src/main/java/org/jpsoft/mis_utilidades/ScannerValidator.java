package org.jpsoft.mis_utilidades;

import java.util.Scanner;

public class ScannerValidator {

    public static int integerValidator(Scanner scanner, String msj) {
        while (true) {
            if (!scanner.hasNextInt()) {
                System.err.println("Debes introducir un número.");
                System.out.print(msj);
                scanner.next();
                continue;
            }
            else {
                return scanner.nextInt();
            }
        }
    }

    public static Boolean yesOrNoValidator(Scanner scanner, String msj) {
        String yesOrNo = scanner.next().toLowerCase();

        while (true) {
            if (!yesOrNo.equals("y")  && !yesOrNo.equals("n")) {
                System.err.println("Debes introducir un 'y' o 'n'.");
                System.out.print(msj);
                yesOrNo = scanner.next().toLowerCase();
                continue;
            } else {
                return yesOrNo.equals("y");
            }
        }
    }

}
