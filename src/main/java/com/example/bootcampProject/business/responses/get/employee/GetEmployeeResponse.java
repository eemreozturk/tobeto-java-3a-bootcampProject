package com.example.bootcampProject.business.responses.get.employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetEmployeeResponse {
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String email;
    private String password;
    private String position;
}
