package com.example.bootcampProject.business.responses.get.instructor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetInstructorResponse {
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String email;
    private String password;
    private String companyName;
}
