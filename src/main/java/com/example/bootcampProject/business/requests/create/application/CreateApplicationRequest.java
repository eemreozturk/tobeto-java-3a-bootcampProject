package com.example.bootcampProject.business.requests.create.application;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateApplicationRequest {
    @Min(1)
    @Positive
    private int id;
    private int applicantId;
    private int bootcampId;
    private int applicationStateId;
}
