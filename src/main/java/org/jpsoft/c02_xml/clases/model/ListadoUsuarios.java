package org.jpsoft.c02_xml.clases.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@XmlRootElement(name = "usuarios")
@XmlAccessorType(XmlAccessType.FIELD)
public class ListadoUsuarios {

    @XmlElement(name = "usuario")
    private List<Usuario> usuarios;


}
