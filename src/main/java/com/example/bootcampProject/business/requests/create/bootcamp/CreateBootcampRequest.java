package com.example.bootcampProject.business.requests.create.bootcamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateBootcampRequest {
    private int id;
    private String name;
    private int instructorId;
    private int bootcampStateId;
    private String startDate;
    private String endDate;


}
