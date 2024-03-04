package com.example.bootcampProject.business.rules;

import com.example.bootcampProject.core.exceptions.types.BusinessException;
import com.example.bootcampProject.dataAccess.abstracts.BootcampStateRepository;
import com.example.bootcampProject.entities.concretes.BootcampState;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class BootcampStateBusinessRules {
    private BootcampStateRepository bootcampStateRepository;
    public void checkIfNameExists(String name) {
        BootcampState bootcampState = bootcampStateRepository.findByName(name.trim());
        if (bootcampState != null) {
            throw new BusinessException("Name is used!");
        }

    }
}
