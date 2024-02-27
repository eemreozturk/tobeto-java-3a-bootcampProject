package com.example.bootcampProject.business.responses.update.blacklist;

import com.example.bootcampProject.entities.concretes.Applicant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateBlacklistResponse {

    private String reason;
    private LocalDate date;
    private Applicant applicantId;
}
