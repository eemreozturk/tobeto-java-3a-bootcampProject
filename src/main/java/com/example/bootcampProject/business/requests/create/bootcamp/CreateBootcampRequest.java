package com.example.bootcampProject.business.requests.create.bootcamp;

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
public class CreateBootcampRequest {
    @Min(1)
    @Positive
    private int id;
    @NotEmpty(message = "Bootcamp name can't be empty.")
    private String name;
    private int instructorId;
    private int bootcampStateId;
    private String startDate;
    private String endDate;


}
