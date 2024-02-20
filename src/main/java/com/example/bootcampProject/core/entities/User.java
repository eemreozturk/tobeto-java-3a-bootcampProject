package com.example.bootcampProject.core.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.swing.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="users")

public class User {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "userName")
    private String userName;
    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "dateOfBirth")
    private LocalDate dateOfBirth;
    @Column(name = "nationalIdentity")
    private String nationalIdentity;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;

    @Column(name="createdDate")
    private LocalDateTime createdDate;

    @Column(name="updatedDate")
    private LocalDateTime updatedDate;

    @Column(name="deletedDate")
    private LocalDateTime deletedDate;


}
