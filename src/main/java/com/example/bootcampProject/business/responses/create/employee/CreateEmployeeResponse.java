package com.example.bootcampProject.business.responses.create.employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateEmployeeResponse {
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String nationalIdentity;
    private String email;
    private String password;
    private String position;
}
