package com.example.bootcampProject.business.concretes;

import com.example.bootcampProject.business.abstracts.EmployeeService;
import com.example.bootcampProject.business.responses.get.user.GetAllUserResponse;
import com.example.bootcampProject.entities.concretes.User;
import com.example.bootcampProject.core.utulities.mapping.ModelMapperService;
import com.example.bootcampProject.dataAccess.abstracts.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeManager implements EmployeeService {
    private ModelMapperService modelMapperService;
    private EmployeeRepository employeeRepository;
    @Override
    public GetAllUserResponse getByPosition(String position) {
        User employee = employeeRepository.findByPosition(position);
        GetAllUserResponse response = modelMapperService.forResponse().map(employee,GetAllUserResponse.class);
        return response;
    }
}
