package com.example.bootcampProject.business.responses.get.blacklist;

import com.example.bootcampProject.entities.concretes.Applicant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetBlacklistResponse {
    private String reason;
    private LocalDate date;
    private Applicant applicantId;

    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
    private LocalDateTime deletedDate;
}
