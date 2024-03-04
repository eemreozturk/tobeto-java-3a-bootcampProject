package com.example.bootcampProject.business.requests.update.applicationState;

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
public class UpdateApplicationStateRequest {
    @Min(1)
    @Positive
    private int id;
    @NotEmpty(message = "Application state name can't be empty.")
    private String name;
}
