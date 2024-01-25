package com.example.tibiaeventbusproject.models.DiffResources;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
public class Threads {


    private int id;

    private String name;

    private List<Post> postList;


    public Threads() {}

    public Threads(int id, String name, List<Post> postList) {
        this.id = id;
        this.name = name;
        this.postList = postList;
    }

    public Threads(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
