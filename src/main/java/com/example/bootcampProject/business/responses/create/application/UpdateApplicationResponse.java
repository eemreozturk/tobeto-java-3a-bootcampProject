package com.example.bootcampProject.business.responses.create.application;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateApplicationResponse {
    private int id;
    private int applicantId;
    private int bootcampId;
    private int applicationStateId;
}
