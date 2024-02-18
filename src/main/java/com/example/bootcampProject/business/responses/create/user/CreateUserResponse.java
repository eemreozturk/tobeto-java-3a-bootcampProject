package com.example.bootcampProject.business.responses.create.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateUserResponse {
    private int id;
    private String firstName;
}
