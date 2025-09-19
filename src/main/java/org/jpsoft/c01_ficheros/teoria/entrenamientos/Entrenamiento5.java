package org.jpsoft.c01_ficheros.teoria.entrenamientos;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Entrenamiento5 {

    private final static File file = new File("src/main/java/org/jpsoft/c01_ficheros/teoria/entrenamientos/productos.dat");
    private final static Double filtroPrecioMayorQue = 50.00;

    public static void main(String[] args) {

        // Productos para serializar
        List<Producto> listaDeProductos = cargarProductos();

        //Variable y Lista para la des serialización
        Producto prod;
        List<Producto> listaDeProductosDesserializados = new ArrayList<>();

//        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
//
//            for (Producto producto : listaDeProductos) {
//                oos.writeObject(producto);
//            }
//
//            System.out.println("Productos guardados correctamente");
//        } catch (IOException e) {
//            System.out.println("Error al guardar los datos" + e.getMessage());
//        }

        try {
            UtilitySerialization.serializeObjects(file, listaDeProductos);
        } catch (IOException e) {
            System.out.println("Error al serializar los datos" + e.getMessage());
            throw new RuntimeException(e);
        }
        System.out.println("Productos serializados correctamente.\n");

//        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
//
//            while (true) {
//                listaDeProductosDesserializados.add((Producto) ois.readObject());
//            }
//
//        } catch (EOFException e) {
//            System.out.println("Archivo leído completamente");
//        } catch (IOException | ClassNotFoundException e) {
//            System.out.println("Error al abrir el archivo " + e.getMessage());
//        }

        try {
            listaDeProductosDesserializados = UtilitySerialization.deserializeObjects(file, Producto.class);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al deserializar los datos" + e.getMessage());
            throw new RuntimeException(e);
        }

        listaDeProductosDesserializados
                .stream()
                .filter(p -> p.getPrecio() > filtroPrecioMayorQue)
                .forEach(System.out::println);
    }

    private static List<Producto> cargarProductos() {
        return List.of(
                new Producto("Patatas", 34.55, "Comestible"),
                new Producto("Manzanas", 12.30, "Comestible"),
                new Producto("Leche", 1.15, "Comestible"),
                new Producto("Camiseta", 9.99, "Ropa"),
                new Producto("Pantalón", 24.50, "Ropa"),
                new Producto("Zapatillas", 49.95, "Calzado"),
                new Producto("Portátil", 799.00, "Electrónica"),
                new Producto("Auriculares", 25.75, "Electrónica"),
                new Producto("Cargador USB", 8.90, "Electrónica"),
                new Producto("Silla", 59.99, "Mueble"),
                new Producto("Mesa", 120.00, "Mueble"),
                new Producto("Detergente", 4.20, "Limpieza"),
                new Producto("Jabón de manos", 2.10, "Higiene"),
                new Producto("Cepillo de dientes", 3.50, "Higiene"),
                new Producto("Pelota de fútbol", 15.00, "Deporte"),
                new Producto("Bicicleta", 299.00, "Deporte")
        );
    }

}

final class Producto implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private String nombre;
    private Double precio;
    private String categoria;

    public Producto(String nombre, Double precio, String categoria) {
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Producto producto = (Producto) o;
        return Objects.equals(nombre, producto.nombre) && Objects.equals(precio, producto.precio) && Objects.equals(categoria, producto.categoria);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, precio, categoria);
    }

    @Override
    public String toString() {
        return "Producto{" +
                "nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", categoria='" + categoria + '\'' +
                '}';
    }
}
