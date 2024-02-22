package com.example.bootcampProject.core.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class UserBaseEntity<T>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;


    @Column(name="createdDate")
    private LocalDateTime createdDate;

    @Column(name="updatedDate")
    private LocalDateTime updatedDate;

    @Column(name="deletedDate")
    private LocalDateTime deletedDate;
}
