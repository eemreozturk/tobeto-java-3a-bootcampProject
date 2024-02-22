package com.example.bootcampProject.business.requests.creat.application;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateApplicationRequest {
    private int id;
    private int applicantId;
    private int bootcampId;
    private int applicationStateId;
}
