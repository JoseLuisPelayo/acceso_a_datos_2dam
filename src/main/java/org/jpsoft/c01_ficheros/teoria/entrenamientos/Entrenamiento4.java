package org.jpsoft.c01_ficheros.teoria.entrenamientos;

import java.io.*;
import java.util.Objects;

public class Entrenamiento4 {
    public static void main(String[] args) {

        File file = new File("src/main/java/org/jpsoft/c01_ficheros/teoria/entrenamientos/persona.dat");

        Persona persona = new Persona("Jose", 39);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))){

            oos.writeObject(persona);
            System.out.println("Persona guardada correctamente");

        } catch (IOException e){

            System.out.println("Error guardando persona: "  + e.getMessage());

        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {

            Persona personaLeida = (Persona) ois.readObject();
            System.out.println("Persona leida correctamente: " + personaLeida);

        } catch (IOException e) {
            System.out.println("Error leyendo archivo: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("La información del archivo persona es incorrecta: " + e.getMessage());
        }
    }
}


class Persona implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String nombre;
    private int edad;

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
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
        Persona persona = (Persona) o;
        return edad == persona.edad && Objects.equals(nombre, persona.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, edad);
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                '}';
    }
}