package com.example.bootcampProject.business.concretes;

import com.example.bootcampProject.business.abstracts.ApplicationService;
import com.example.bootcampProject.business.responses.get.application.GetAllApplicationResponse;
import com.example.bootcampProject.business.responses.get.application.GetApplicationResponse;
import com.example.bootcampProject.core.utulities.mapping.ModelMapperService;
import com.example.bootcampProject.core.utulities.results.DataResult;
import com.example.bootcampProject.core.utulities.results.SuccessDataResult;
import com.example.bootcampProject.dataAccess.abstracts.ApplicationRepository;
import com.example.bootcampProject.entities.concretes.Application;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ApplicationManager implements ApplicationService {
    private ModelMapperService modelMapperService;
    private ApplicationRepository applicationRepository;
    @Override
    public DataResult<GetApplicationResponse> getById(int id) {
        Application application = applicationRepository.findById(id);
        GetAllApplicationResponse response = modelMapperService.forResponse().map(application,GetAllApplicationResponse.class);
        return new SuccessDataResult<GetAllApplicationResponse>(response,"Listed Successfully") ;
    }
}
