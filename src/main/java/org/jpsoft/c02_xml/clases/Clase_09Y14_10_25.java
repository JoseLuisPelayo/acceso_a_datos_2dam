package org.jpsoft.c02_xml.clases;

import org.jpsoft.c02_xml.clases.model.Actor;
import org.jpsoft.c02_xml.clases.model.Pelicula;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Clase_09Y14_10_25 {

    public void lecturaXML() {

        File file = new File("src/main/java/org/jpsoft/c02_xml/clases/usuarios.xml");

        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document document = dBuilder.parse(file);

            NodeList nodosUsuario = document.getElementsByTagName("usuario");

            for(int i = 0; i < nodosUsuario.getLength(); i++){

                Element nodeUsuario = (Element) nodosUsuario.item(i);
                String nacionalidad = nodeUsuario.getAttribute("nacionalidad");
                int edad = Integer.parseInt(nodeUsuario.getAttribute("edad"));
                String nombre = nodeUsuario.getElementsByTagName("nombre").item(0).getTextContent();
                String apellido = nodeUsuario.getElementsByTagName("apellido").item(0).getTextContent();

                System.out.printf("Nombre: %s %s - Edad: %d - Nacionalidad: %s\n", nombre ,apellido, edad,nacionalidad );

            }
            System.out.println(nodosUsuario.getLength());

        } catch (ParserConfigurationException e) {
            System.out.println("Error: En el parseo." +  e.getMessage());
        } catch (IOException e) {
            System.out.println("Error: No tienes permisos de lectura " +  e.getMessage());
        } catch (SAXException e) {
            System.out.println("Error: Ha ocurrido un error de SAX");
        }

    }


    public void escrituraXML() {

        try {
            Transformer transformer = TransformerFactory.newInstance().newTransformer();

//            Vamos a necesitar un DOMSource para el transform este se crea pasandole el document
            DOMSource cartelera = new DOMSource(new XMLParserCartelera().carteleraToXml(loadData()));

//            Y un StreamResult pasandole el luegar donde lo quieres guardar en este caso un File
            StreamResult streamResult = new StreamResult(new File("src/main/resources/peliculas.xml"));

            transformer.transform(cartelera, streamResult);
        } catch (TransformerException e) {
            System.out.println("Error: error en la configuración del xml");
        }

    }


    public ArrayList<Pelicula> loadData() {
        ArrayList<Pelicula> peliculas = new ArrayList<>();

        peliculas.add(new Pelicula(
                "Inception",
                "Christopher Nolan",
                "Ciencia ficción / Acción",
                new Actor[]{new Actor("Leonardo DiCaprio"), new Actor("Joseph Gordon-Levitt"), new Actor("Elliot Page")},
                2010,
                8.8,
                "SRC del cartel de la imagen"));

        peliculas.add(new Pelicula(
                "The Matrix",
                "Lana Wachowski, Lilly Wachowski",
                "Ciencia ficción / Acción",
                new Actor[]{new Actor("Keanu Reeves"), new Actor("Carrie-Anne Moss"), new Actor("Laurence Fishburne")},
                1999,
                8.7,
                "SRC del cartel de la imagen"));

        peliculas.add(new Pelicula(
                "Interstellar",
                "Christopher Nolan",
                "Ciencia ficción / Aventura",
                new Actor[]{new Actor("Matthew McConaughey"), new Actor("Anne Hathaway"), new Actor("Jessica Chastain")},
                2014,
                8.6,
                "SRC del cartel de la imagen"));

        peliculas.add(new Pelicula(
                "Parasite",
                "Bong Joon-ho",
                "Thriller / Drama",
                new Actor[]{new Actor("Song Kang-ho"), new Actor("Choi Woo-shik"), new Actor("Park So-dam")},
                2019,
                8.5,
                "SRC del cartel de la imagen"));

        peliculas.add(new Pelicula(
                "El viaje de Chihiro",
                "Hayao Miyazaki",
                "Animación / Fantasía",
                new Actor[]{new Actor("Rumi Hiiragi"), new Actor("Miyu Irino"), new Actor("Mari Natsuki")},
                2001,
                8.6,
                "SRC del cartel de la imagen"));

        peliculas.add(new Pelicula(
                "El padrino",
                "Francis Ford Coppola",
                "Crimen / Drama",
                new Actor[]{new Actor("Marlon Brando"), new Actor("Al Pacino"), new Actor("James Caan")},
                1972,
                9.2,
                "SRC del cartel de la imagen"));

        peliculas.add(new Pelicula(
                "Pulp Fiction",
                "Quentin Tarantino",
                "Crimen / Comedia negra",
                new Actor[]{new Actor("John Travolta"), new Actor("Samuel L. Jackson"), new Actor("Uma Thurman")},
                1994,
                8.9,
                "SRC del cartel de la imagen"));

        peliculas.add(new Pelicula(
                "El caballero oscuro",
                "Christopher Nolan",
                "Acción / Crimen",
                new Actor[]{new Actor("Christian Bale"), new Actor("Heath Ledger"), new Actor("Aaron Eckhart")},
                2008,
                9.0,
                "SRC del cartel de la imagen"));

        peliculas.add(new Pelicula(
                "Amélie",
                "Jean-Pierre Jeunet",
                "Comedia / Romance",
                new Actor[]{new Actor("Audrey Tautou"), new Actor("Mathieu Kassovitz"), new Actor("Rufus")},
                2001,
                8.3,
                "SRC del cartel de la imagen"));

        peliculas.add(new Pelicula(
                "La La Land",
                "Damien Chazelle",
                "Musical / Romance",
                new Actor[]{new Actor("Ryan Gosling"), new Actor("Emma Stone"), new Actor("John Legend")},
                2016,
                8.0,
                "SRC del cartel de la imagen"));

        peliculas.add(new Pelicula(
                "Mad Max: Fury Road",
                "George Miller",
                "Acción / Aventura",
                new Actor[]{new Actor("Tom Hardy"), new Actor("Charlize Theron"), new Actor("Nicholas Hoult")},
                2015,
                8.1,
                "SRC del cartel de la imagen"));

        return peliculas;
    }
}
