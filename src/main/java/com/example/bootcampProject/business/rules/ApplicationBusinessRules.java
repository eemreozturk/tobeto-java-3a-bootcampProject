package com.example.bootcampProject.business.rules;

import com.example.bootcampProject.core.exceptions.types.BusinessException;
import com.example.bootcampProject.dataAccess.abstracts.ApplicationRepository;
import com.example.bootcampProject.entities.concretes.Application;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@AllArgsConstructor
@Service
public class ApplicationBusinessRules {
    private ApplicationRepository applicationRepository;
    public void checkIfIdExists(int id) {
        Application application = applicationRepository.findById(id);
        if (application != null) {
            throw new BusinessException("Id is used!");
        }

    }
}
