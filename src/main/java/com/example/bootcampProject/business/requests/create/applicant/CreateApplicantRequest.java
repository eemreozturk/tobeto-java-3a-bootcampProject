package com.example.bootcampProject.business.requests.create.applicant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateApplicantRequest {
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String nationalIdentity;
    private String email;
    private String password;
    private String about;
}
