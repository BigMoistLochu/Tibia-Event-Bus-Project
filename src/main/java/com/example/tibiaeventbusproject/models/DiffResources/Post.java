package com.example.tibiaeventbusproject.models.DiffResources;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Post {
    private int id;

    private String name;

    private int userID;
}
