package com.example.bootcampProject.business.concretes;

import com.example.bootcampProject.business.abstracts.ApplicationStateService;
import com.example.bootcampProject.business.requests.create.applicationState.CreateApplicationStateRequest;
import com.example.bootcampProject.business.responses.create.applicationState.CreateApplicationStateResponse;
import com.example.bootcampProject.business.responses.update.application.UpdateApplicationResponse;
import com.example.bootcampProject.business.responses.create.user.CreateUserResponse;
import com.example.bootcampProject.business.responses.get.applicationState.GetAllApplicationStateResponse;
import com.example.bootcampProject.business.responses.update.applicationState.UpdateApplicationStateResponse;
import com.example.bootcampProject.core.utulities.mapping.ModelMapperService;
import com.example.bootcampProject.core.utulities.results.DataResult;
import com.example.bootcampProject.core.utulities.results.Result;
import com.example.bootcampProject.core.utulities.results.SuccessDataResult;
import com.example.bootcampProject.dataAccess.abstracts.ApplicationStateRepository;
import com.example.bootcampProject.entities.concretes.ApplicationState;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public DataResult<List<GetAllApplicationStateResponse>> getAll() {
        List<ApplicationState> applicationStates = applicationStateRepository.findAll();
        List<GetAllApplicationStateResponse> applicationStateResponses = applicationStates.stream().map(applicationState -> modelMapperService.forResponse().map(applicationState, GetAllApplicationStateResponse.class)).toList();

        return new SuccessDataResult<List<GetAllApplicationStateResponse>>(applicationStateResponses, "Listed Successfully");
    }

    @Override
    public DataResult<CreateApplicationStateResponse> add(CreateApplicationStateRequest request) {
        ApplicationState applicationState = modelMapperService.forRequest().map(request, ApplicationState.class);
        applicationStateRepository.save(applicationState);
        CreateUserResponse response = modelMapperService.forResponse().map(applicationState, CreateApplicationStateResponse.class);

        return new SuccessDataResult<CreateApplicationStateResponse>(response, "Added Successfully");
    }

    @Override
    public DataResult<UpdateApplicationStateResponse> update(UpdateApplicationStateResponse updateApplicationStateResponse, int id) {
        ApplicationState applicationState = applicationStateRepository.findById(id).orElseThrow();
        ApplicationState updatedApplicationState = modelMapperService.forRequest().map(updateApplicationStateResponse, ApplicationState.class);
        UpdateApplicationResponse response = modelMapperService.forResponse().map(applicationState, UpdateApplicationStateResponse.class);

        return new SuccessDataResult<UpdateApplicationStateResponse>(response, "Updated Successfully");
    }

    @Override
    public Result delete(int id) {
        this.applicationStateRepository.deleteById(id);
    }
}
