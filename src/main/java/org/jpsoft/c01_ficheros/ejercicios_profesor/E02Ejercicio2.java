package org.jpsoft.c01_ficheros.ejercicios_profesor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class E02Ejercicio2 {
    /*
    Ejercicio 2: Contador de palabras
    Desarrolla una aplicación que lea un archivo de texto y cuente cuántas palabras contiene. El programa debe mostrar
    también cuáles son las 5 palabras más frecuentes y cuántas veces aparece cada una. Ignora signos de puntuación y
    trata las palabras sin distinguir entre mayúsculas y minúsculas.

    Ejemplo de entrada:
    Archivo: C:/Datos/articulo.txt

    Contenido del archivo:
    Java es un lenguaje de programación muy popular. Java se utiliza para desarrollar aplicaciones web, aplicaciones
    móviles y aplicacio nes de escritorio. Java es un lenguaje orientado a objetos que fue diseñado para tener la menor
    cantidad posible de dependencias de implementación.

    Ejemplo de salida:
    Archivo: C:/Datos/articulo.txt
    Número total de palabras: 42

    Las 5 palabras más frecuentes:
    1. java: 3 veces
    2. aplicaciones: 3 veces
    3. de: 3 veces
    4. es: 2 veces
    5. un: 2 veces
     */

    private static final File entryFile = new File("src/main/resources/articulo.txt");
    private static final int listSize = 5;
    private static final String template = """
            \nArchivo: %s
            Número total de palabras: %d
            
            Las %d palabras más frecuentes:
            %s""";
    private static final String listTemplate = "%d. %s: %d veces\n";

    public static void main(String[] args) {

        try {
//            String text = entryFileTextToString();
//            List<String> textWords = splitString(text);
//
//            Set<String> wordsSet = new HashSet<>(textWords);
//            Map<String, Integer> wordCounts = new LinkedHashMap<>();
//
//            wordsSet.forEach(w -> {
//                int count = textWords.stream().filter(word -> word.equals(w)).toList().size();
//                wordCounts.put(w, count);
//            });
//
//            Map<String, Integer> orederedMap = new LinkedHashMap<>();
//            Comparator<Map.Entry<String, Integer>> comparator = Map.Entry.comparingByValue(Comparator.reverseOrder());

            /*
             * Collectors.toMap() recibe 4 parámetros en este caso:
             *
             * 1) Map.Entry::getKey → keyMapper
             *    Indica qué usar como clave en el nuevo mapa (aquí, la clave original del Entry).
             *
             * 2) Map.Entry::getValue → valueMapper
             *    Indica qué usar como valor en el nuevo mapa (aquí, el valor original del Entry).
             *
             * 3) (v1, v2) -> v1 → mergeFunction
             *    Se usa solo si aparecen claves duplicadas después de aplicar keyMapper.
             *    En este caso, en caso de colisión, se quedaría con el primer valor y descartaría el segundo.
             *    (Con entrySet() no se da el caso porque las claves de un Map son únicas).
             *
             * 4) LinkedHashMap::new → mapFactory
             *    Indica qué tipo de Map crear.
             *    Aquí usamos LinkedHashMap para conservar el orden de inserción,
             *    lo que asegura que el resultado mantenga el orden definido por .sorted(comparator).
             */
//            orederedMap = wordCounts.entrySet().stream()
//                    .sorted(comparator)
//                    .collect(Collectors
//                            .toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
//
//            System.out.printf(template, entryFile.getAbsolutePath(), textWords.size(), listSize, buildOutputListOfWords(newTry));

// *************************************** NUEVA APROXIMACION ****************************************************************

            List<String> textWords = splitString(entryFileTextToString());
            Comparator<Map.Entry<String, Integer>> comparatorByValue = Map.Entry.comparingByValue(Comparator.reverseOrder());


            LinkedHashMap<String, Integer> newTry = textWords.stream()
                    .collect(Collectors.groupingBy(
                            w -> w,
                            Collectors.summingInt(w -> 1)
                    ))
                    .entrySet().stream().sorted(comparatorByValue).collect(Collectors.toMap(
                            Map.Entry::getKey,
                            Map.Entry::getValue,
                            (e1, e2) -> e1,
                            LinkedHashMap::new
                    ));

            System.out.printf(
                    template,
                    entryFile.getAbsolutePath(),
                    textWords.size(),
                    listSize,
                    buildOutputListOfWords(newTry)
            );

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static String buildOutputListOfWords(Map<String, Integer> words) {
        StringBuilder listToShow = new StringBuilder();
        int count = 0;

        for (Map.Entry<String, Integer> entry : words.entrySet()) {
            count++;
            listToShow.append(String.format(listTemplate, count, entry.getKey(), entry.getValue()));
            if (count >= listSize) break;
        }
        return listToShow.toString();
    }

    private static List<String> splitString(String text) {
        return List.of(text
                .replace(",", "")
                .replace(".", "")
                .split("[ \n]")
        );
    }

    private static String entryFileTextToString() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(entryFile))) {
            StringBuilder content = new StringBuilder();
            br.lines().forEach(l -> content.append(l).append(" "));

            return content.toString();
        }
    }
}
