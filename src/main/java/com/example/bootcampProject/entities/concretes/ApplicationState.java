package com.example.bootcampProject.entities.concretes;

import com.example.bootcampProject.core.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="applicationState")
@PrimaryKeyJoinColumn(name = "id")
public class ApplicationState extends BaseEntity<Integer> {

    //id,name
    @Column(name = "Name")
    private String name;

    @OneToMany(mappedBy = "applicationState", cascade = CascadeType.REMOVE)
    private List<Application> applications;
}
