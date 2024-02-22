package com.example.bootcampProject.entities.concretes;

import com.example.bootcampProject.core.entities.ApplicationBaseEntitiy;
import jakarta.persistence.Column;

public class ApplicationState extends ApplicationBaseEntitiy {
    //id,name
    @Column(name = "Name")
    private String name;
}
