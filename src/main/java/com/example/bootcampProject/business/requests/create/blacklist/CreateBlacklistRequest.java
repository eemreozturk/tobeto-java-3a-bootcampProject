package com.example.bootcampProject.business.requests.create.blacklist;

import com.example.bootcampProject.entities.concretes.Applicant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateBlacklistRequest {
    private String reason;
    private LocalDate date;
    private Applicant applicantId;
}
