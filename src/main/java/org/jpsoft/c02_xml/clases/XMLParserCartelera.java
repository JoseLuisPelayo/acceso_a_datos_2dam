package org.jpsoft.c02_xml.clases;

import org.jpsoft.c02_xml.clases.model.Actor;
import org.jpsoft.c02_xml.clases.model.Pelicula;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.util.ArrayList;


public class XMLParserCartelera {

    private Document document;

    public XMLParserCartelera() {
        try {
            this.document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
        } catch (ParserConfigurationException e) {
            System.out.println("Error de parseo al crear el documento");
        }
    }

    public Document carteleraToXml(ArrayList<Pelicula> films) {
        Element rootElement = createCarteleraRootElement();

        for (Pelicula film : films) {
            rootElement.appendChild(filmToXML(film));
        }

        document.appendChild(rootElement);

        return document;
    }

    private Element createCarteleraRootElement() {
        Element rootElement = this.document.createElement("cartelera");
        rootElement.setAttribute("id", "1");

        return rootElement;
    }

    private Element filmToXML(Pelicula film) {
        Element filmToXML =  this.document.createElement("pelicula");
        filmToXML.setAttribute("anio", String.valueOf(film.getAnio()));
        filmToXML.setAttribute("genero", film.getGenero());

        filmToXML.appendChild(document.createElement("titulo"));
        filmToXML.appendChild(document.createElement("director"));
        filmToXML.appendChild(actorsToXML(film.getActores()));
        filmToXML.appendChild(document.createElement("cartel"));

        filmToXML.getElementsByTagName("titulo").item(0).setTextContent(film.getNombre());
        filmToXML.getElementsByTagName("director").item(0).setTextContent(film.getDirector());
        filmToXML.getElementsByTagName("cartel").item(0).setTextContent(film.getSrc());

        return filmToXML;
    }

    private Element actorsToXML(Actor[] actors) {
        Element actorsParentNode = document.createElement("actores");

        for (Actor actor : actors) {
            Element xmlActor = document.createElement("actor");
            xmlActor.setTextContent(actor.getNombre());

            actorsParentNode.appendChild(xmlActor);
        }

        return actorsParentNode;
    }
}
