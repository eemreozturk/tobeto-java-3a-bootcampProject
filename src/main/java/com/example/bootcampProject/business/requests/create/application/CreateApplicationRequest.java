package com.example.bootcampProject.business.requests.create.application;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateApplicationRequest {
    private int id;
    private int applicantId;
    private int bootcampId;
    private int applicationStateId;
}
