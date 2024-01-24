package com.example.tibiaeventbusproject.models.DiffResources;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@AllArgsConstructor
public class Threads {


    private int id;

    private String name;

    private List<Post> postList;



}
