package com.example.bootcampProject.business.rules;

import com.example.bootcampProject.core.exceptions.types.BusinessException;
import com.example.bootcampProject.dataAccess.abstracts.InstructorRepository;
import com.example.bootcampProject.entities.concretes.Instructor;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class InstructorBusinessRules {
    private InstructorRepository instructorRepository;

    public void checkIfCompanyNameExists(String companyName) {
        Instructor instructor = instructorRepository.getByCompanyName(companyName.trim());
        if (instructor != null) {
            throw new BusinessException("Company Name is used!");
        }

    }
}
