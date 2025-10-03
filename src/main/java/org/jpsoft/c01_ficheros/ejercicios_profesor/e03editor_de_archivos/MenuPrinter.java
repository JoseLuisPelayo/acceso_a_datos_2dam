package org.jpsoft.c01_ficheros.ejercicios_profesor.e03editor_de_archivos;

public class MenuPrinter {
    public static String mainMenu() {
        return """
            \n|-**************************-|
            |****** Menú Principal ******|
            |-**************************-|
            | 1. Crear archivo nuevo     |
            | 2. Abrir archivo existente |
            | 3. Salir                   |
            |-**************************-|
            
            Selecciona una opción:""";
    }

    public static String fileEditionMenu(String filePath, String fileContent) {
        return String.format("""
                Ruta del archivo: %s
                
                === Contenido actual del archivo ===
                %s=== Fin del contenido ===
                
                            ¿Qué desea hacer?
                                1. Sobrescribir el archivo
                                2. Añadir texto al final
                                3. Volver al menú principal
                
                Seleccione una opción:""", filePath, fileContent);
    }
}
