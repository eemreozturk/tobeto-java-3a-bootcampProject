package com.example.bootcampProject.business.responses.get.bootcamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetAllBootcampResponse {
    private int id;
    private String name;
    private int instructorId;
    private int bootcampStateId;
    private String startDate;
    private String endDate;
}
