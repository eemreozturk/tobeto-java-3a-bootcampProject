package com.example.bootcampProject.business.rules;

import com.example.bootcampProject.core.exceptions.types.BusinessException;
import com.example.bootcampProject.dataAccess.abstracts.EmployeeRepository;
import com.example.bootcampProject.entities.concretes.Employee;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class EmployeeBusinessRules {
    private EmployeeRepository employeeRepository;

    public void checkIfPositionExists(String position) {
        Employee employee = employeeRepository.getByPosition(position.trim());
        if (employee != null) {
            throw new BusinessException("Position is used!");
        }

    }
}
