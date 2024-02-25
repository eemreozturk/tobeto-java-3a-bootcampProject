package com.example.bootcampProject.business.responses.update.instructor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateInstructorResponse {
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String email;
    private String password;
    private String companyName;
}
