package org.jpsoft;

import org.jpsoft.c02_xml.clases.Clase_09Y14_10_25;
import org.jpsoft.c02_xml.clases.Clase_21_10_25;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //ARCHIVOS
/*
        E01ListarArchivos.directoryList("/home/jose/proyectos/untitled/src/main/java/org/jpsoft", true);
        System.out.println("jose Luis Garcia".indexOf('i', 10));
        */

        //XML
        /*
        Clase_09Y14_10_25 operaciones = new Clase_09Y14_10_25();
        operaciones.lecturaXML();

        operaciones.escrituraXML();
        Clase_21_10_25 clase_21_10_25 = new Clase_21_10_25();
        clase_21_10_25.crearXMLConJaxBYJakartaBin();
        clase_21_10_25.leerXMLConJaxBYJakartaBin();
        */

//        JSON con Jackson
        Clase_21_10_25 clase_21_10_25 = new Clase_21_10_25();
        clase_21_10_25.lectorJson();


    }
}