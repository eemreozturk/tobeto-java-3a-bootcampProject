package com.example.bootcampProject.business.requests.update.blacklist;

import com.example.bootcampProject.entities.concretes.Applicant;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateBlacklistRequest {
    @NotEmpty(message = "Blacklist reason can't be empty.")
    private String reason;
    @NotEmpty(message = "Blacklist date can't be empty.")
    private LocalDate date;
    private Applicant applicantId;
}
