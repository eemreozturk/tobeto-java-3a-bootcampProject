package com.example.bootcampProject.business.rules;

import com.example.bootcampProject.core.exceptions.types.BusinessException;
import com.example.bootcampProject.dataAccess.abstracts.BootcampRepository;
import com.example.bootcampProject.entities.concretes.Bootcamp;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class BootcampBusinessRules {
    private BootcampRepository bootcampRepository;
    public void checkIfNameExists(String name) {
        Bootcamp bootcamp = bootcampRepository.findByName(name.trim());
        if (bootcamp != null) {
            throw new BusinessException("Name is used!");
        }

    }
}
