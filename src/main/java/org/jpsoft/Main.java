package org.jpsoft;

import org.jpsoft.c01_ficheros.ejercicios_profesor.E01ListarArchivos;

import java.io.File;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        E01ListarArchivos.directoryList("/home/jose/proyectos/untitled/src/main/java/org/jpsoft", true);
        System.out.println("jose Luis Garcia".indexOf('i', 10));
    }
}