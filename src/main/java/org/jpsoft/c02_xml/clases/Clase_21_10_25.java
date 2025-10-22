package org.jpsoft.c02_xml.clases;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.StreamReadFeature;
import com.fasterxml.jackson.core.StreamWriteFeature;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.json.JsonReadFeature;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import org.jpsoft.c02_xml.clases.model.ListadoUsuarios;
import org.jpsoft.c02_xml.clases.model.ProductResponse;
import org.jpsoft.c02_xml.clases.model.Usuario;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class Clase_21_10_25 {

    private final ListadoUsuarios listadoUsuarios = new ListadoUsuarios();

    public void crearXMLConJaxBYJakartaBin() {
        listadoUsuarios.setUsuarios(cargarUsuarios());

        try {
            //carga el contexto de listado usuarios con todas las anotaciones y demas
            JAXBContext context = JAXBContext.newInstance(ListadoUsuarios.class);

//            Creanois el mapeador de objetos
            var marshaller = context.createMarshaller();
            marshaller.marshal(listadoUsuarios, new File("src/main/resources/usuarios.xml"));
        } catch (JAXBException e) {
            System.out.println("Error al crear el contexto JAXB: " + e.getMessage());
        }
    }

    public void leerXMLConJaxBYJakartaBin() {
        try {
            JAXBContext context = JAXBContext.newInstance(ListadoUsuarios.class);
            var unmarshaller = context.createUnmarshaller();
            ListadoUsuarios lista = (ListadoUsuarios) unmarshaller.unmarshal(new File("src/main/resources/usuarios.xml"));
            lista.getUsuarios().forEach(usuario -> System.out.println(usuario.getDni() + " " + usuario.getNombre() + " " + usuario.getApellido()));
        } catch (JAXBException e) {
            System.out.println("Error al crear el contexto JAXB: " + e.getMessage());
        }
    }

    public void lectorJson() {
        ObjectMapper mapper = new ObjectMapper();

        try {
            URL uri = new URI("https://dummyjson.com/products").toURL();
            ProductResponse products = mapper.readValue(uri, ProductResponse.class);

            products.getProducts().forEach(product -> System.out.println(product.getId() + " " + product.getTitle() + " " + product.getPrice()));
        } catch (URISyntaxException | MalformedURLException e) {
            System.out.println("Error en la URI: " + e.getMessage());
        } catch (StreamReadException e) {
            System.out.println("Error en la lectura del json");
        } catch (DatabindException e) {
            System.out.println("Error en l mapeado del json");
        } catch (IOException e) {
            System.out.println("Error en la conexión " + e.getMessage());
        }


    }


   private List<Usuario> cargarUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Usuario("12345678A", "Jose", "Garcia"));
        usuarios.add(new Usuario("87654321B", "Ana", "Lopez"));
        usuarios.add(new Usuario("11223344C", "Luis", "Martinez"));
        usuarios.add(new Usuario("4567890D", "Jose", "Martinez"));
        return usuarios;
    }


}


