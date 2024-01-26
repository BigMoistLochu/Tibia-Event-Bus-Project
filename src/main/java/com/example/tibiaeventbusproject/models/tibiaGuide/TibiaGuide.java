package com.example.tibiaeventbusproject.models.tibiaGuide;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class TibiaGuide {

    @Id
    private String id;
    private String name;

    private String description;


    public TibiaGuide() {}

    public TibiaGuide(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
