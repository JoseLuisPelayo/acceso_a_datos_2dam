package org.jpsoft.c02_xml.clases.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Product {

    private int id;
    private String title;
    private String description;
    private Double price;

}