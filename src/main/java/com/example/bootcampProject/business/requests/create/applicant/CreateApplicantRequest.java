package com.example.bootcampProject.business.requests.create.applicant;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateApplicantRequest {
    @NotEmpty(message = "Applicant first name can't be empty.")
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    @Pattern(regexp ="[0-9\\s]{11}",message = "National identity must consist of 11 characters.")
    private String nationalIdentity;
    @Email(message = "Wrong email")
    private String email;
    @Size(min=8,message = "Password must be at least 8 characters")
    private String password;
    private String about;
}
