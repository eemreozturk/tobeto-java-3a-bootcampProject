package com.example.bootcampProject.business.responses.update.application;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateApplicationResponse {
    private int applicantId;
    private int bootcampId;
    private int applicationStateId;
}
