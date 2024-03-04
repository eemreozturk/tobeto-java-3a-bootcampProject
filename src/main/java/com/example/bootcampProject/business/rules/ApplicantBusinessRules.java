package com.example.bootcampProject.business.rules;

import com.example.bootcampProject.core.exceptions.types.BusinessException;
import com.example.bootcampProject.dataAccess.abstracts.ApplicantRepository;
import com.example.bootcampProject.entities.concretes.Applicant;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ApplicantBusinessRules {
    private ApplicantRepository applicantRepository;

    public void checkIfAboutExists(String about) {
        Applicant applicant = applicantRepository.getByAbout(about.trim());
        if (applicant != null) {
            throw new BusinessException("About is used!");
        }

    }
}
