package com.example.bootcampProject.business.concretes;

import com.example.bootcampProject.business.abstracts.ApplicationStateService;
import com.example.bootcampProject.business.responses.get.application.GetAllApplicationResponse;
import com.example.bootcampProject.business.responses.get.applicationState.GetAllApplicationStateResponse;
import com.example.bootcampProject.core.utulities.mapping.ModelMapperService;
import com.example.bootcampProject.core.utulities.results.DataResult;
import com.example.bootcampProject.core.utulities.results.SuccessDataResult;
import com.example.bootcampProject.dataAccess.abstracts.ApplicationStateRepository;
import com.example.bootcampProject.entities.concretes.Application;
import com.example.bootcampProject.entities.concretes.ApplicationState;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ApplicationStateManager implements ApplicationStateService {
    private ModelMapperService modelMapperService;
    private ApplicationStateRepository applicationStateRepository;
    @Override
    public DataResult<GetAllApplicationStateResponse> getById(int id) {
        ApplicationState applicationState = applicationStateRepository.findById(id);
        GetAllApplicationStateResponse response = modelMapperService.forResponse().map(applicationState,GetAllApplicationStateResponse.class);
        return new SuccessDataResult<GetAllApplicationStateResponse>(response,"Listed Successfully") ;
    }
}
