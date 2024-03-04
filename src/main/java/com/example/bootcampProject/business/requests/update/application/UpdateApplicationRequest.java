package com.example.bootcampProject.business.requests.update.application;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateApplicationRequest {
    @Min(1)
    @Positive
    private int id;
    private int applicantId;
    private int bootcampId;
    private int applicationStateId;
}
