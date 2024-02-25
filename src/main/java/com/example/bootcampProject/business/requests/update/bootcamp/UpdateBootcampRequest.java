package com.example.bootcampProject.business.requests.update.bootcamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateBootcampRequest {
    private int id;
    private String name;
    private int instructorId;
    private int bootcampStateId;
    private String startDate;
    private String endDate;
}
