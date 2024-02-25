package com.example.bootcampProject.business.responses.get.employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetAllEmployeeResponse {
    private int id;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String nationalIdentity;
    private String email;
    private String password;
    private String position;
}
