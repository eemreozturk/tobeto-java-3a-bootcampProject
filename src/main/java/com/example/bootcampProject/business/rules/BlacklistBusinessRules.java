package com.example.bootcampProject.business.rules;

import com.example.bootcampProject.core.exceptions.types.BusinessException;
import com.example.bootcampProject.dataAccess.abstracts.BlacklistRepository;
import com.example.bootcampProject.entities.concretes.Blacklist;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class BlacklistBusinessRules {
    private BlacklistRepository blacklistRepository;
    public void checkIfReasonExists(String reason) {
        Blacklist blacklist = blacklistRepository.findByReason(reason.trim());
        if (blacklist != null) {
            throw new BusinessException("Reason is used!");
        }

    }
}
