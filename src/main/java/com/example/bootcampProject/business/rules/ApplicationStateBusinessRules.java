package com.example.bootcampProject.business.rules;

import com.example.bootcampProject.core.exceptions.types.BusinessException;
import com.example.bootcampProject.dataAccess.abstracts.ApplicationStateRepository;
import com.example.bootcampProject.entities.concretes.ApplicationState;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ApplicationStateBusinessRules {
    private ApplicationStateRepository applicationStateRepository;
    public void checkIfIdExists(int id) {
        ApplicationState applicationState = applicationStateRepository.findById(id);
        if (applicationState != null) {
            throw new BusinessException("Id is used!");
        }

    }
}
