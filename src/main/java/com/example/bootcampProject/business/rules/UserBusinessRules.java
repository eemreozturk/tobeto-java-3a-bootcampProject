package com.example.bootcampProject.business.rules;

import com.example.bootcampProject.core.exceptions.types.BusinessException;
import com.example.bootcampProject.dataAccess.abstracts.UserRepository;
import com.example.bootcampProject.entities.concretes.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserBusinessRules {
    private UserRepository userRepository;
    public void checkIfEmailExists(String email) {
        User user = userRepository.getByEmail(email.trim());
        if(user != null){
            throw new BusinessException("Email is used!");
        }
    }
}
