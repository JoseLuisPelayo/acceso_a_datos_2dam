package org.jpsoft.c01_ficheros.teoria.ejemplos;

/*
En Java, la serialización es el proceso que permite convertir un objeto en una secuencia de bytes, lo que facilita su
almacenamiento en archivos o su transmisión a través de redes. La deserialización es el proceso inverso, donde se
reconstruye el objeto original a partir de dicha secuencia de bytes. Para que una clase sea serializable, debe
 implementar la interfaz Serializable del paquete java.io. Esta interfaz actúa como una interfaz de marcador
 (marker interface), es decir, no contiene métodos ni campos, pero indica al sistema que los objetos de la clase
 pueden ser serializados.
 */

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class InterfazSerializable implements Serializable {


    /*
    El campo, serialVersionUID es un identificador único que se utiliza durante la deserialización para verificar que
    el emisor y el receptor de un objeto serializado han cargado clases compatibles en términos de serialización. Si
    no coinciden, se lanzará una excepción InvalidClassException. Aunque el entorno de ejecución de Java puede calcular
    un serialVersionUID predeterminado, basado en diversos aspectos de la clase, se recomienda declarar este campo
    explícitamente para asegurar la compatibilidad entre diferentes versiones de la clase y evitar posibles
    problemas durante la deserialización.
     */
    @Serial
    private static final long serialVersionUID = 1L;

    private String nombre;
    private int edad;
    private String matricula;

    /*
    El modificador transient se utiliza para excluir ciertos campos de la serialización. Esto es útil cuando ciertos
    datos no deben persistir o se pueden recalcular fácilmente.
    Esto significa que el valor del campo transient no se guardará cuando el objeto se serialice y su valor se
    establecerá en el valor predeterminado de su tipo de datos.
     */
    private transient String datoSensible;


    public InterfazSerializable() {}

    public InterfazSerializable(String nombre, int edad, String matricula, String datoSensible) {
        this.nombre = nombre;
        this.edad = edad;
        this.matricula = matricula;
        this.datoSensible = datoSensible;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        InterfazSerializable that = (InterfazSerializable) o;
        return Objects.equals(nombre, that.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nombre);
    }

    @Override
    public String toString() {
        return "InterfazSerializable{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", matricula='" + matricula + '\'' +
                ", datoSensible='" + datoSensible + '\'' +
                '}';
    }
}
