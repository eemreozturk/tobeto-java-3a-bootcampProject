package com.example.bootcampProject.entities.concretes;

import com.example.bootcampProject.core.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="bootcampState")
@EqualsAndHashCode(callSuper = true)
public class BootcampState extends BaseEntity<Integer> {

    @Column(name = "Name")
    private String name;
    //id,name
    @OneToMany(mappedBy = "bootcampState", cascade = CascadeType.REMOVE)
    private List<Bootcamp> bootcamps;
}
