package com.example.bootcampProject.business.requests.update.blacklist;

import com.example.bootcampProject.entities.concretes.Applicant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateBlacklistRequest {
    private String reason;
    private LocalDate date;
    private Applicant applicantId;
}
