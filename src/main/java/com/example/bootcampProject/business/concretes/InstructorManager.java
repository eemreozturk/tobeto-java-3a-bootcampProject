package com.example.bootcampProject.business.concretes;

import com.example.bootcampProject.business.abstracts.InstructorService;
import com.example.bootcampProject.business.responses.get.user.GetAllUserResponse;
import com.example.bootcampProject.core.entities.User;
import com.example.bootcampProject.core.utulities.mapping.ModelMapperService;
import com.example.bootcampProject.dataAccess.abstracts.InstructorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class InstructorManager implements InstructorService {
    private InstructorRepository instructorRepository;
    private ModelMapperService modelMapperService;
    @Override
    public GetAllUserResponse getByCompanyName(String companyName) {
        User instructor = instructorRepository.findByCompanyName(companyName);
        GetAllUserResponse response = modelMapperService.forResponse().map(instructor,GetAllUserResponse.class);
        return response;
    }
}
