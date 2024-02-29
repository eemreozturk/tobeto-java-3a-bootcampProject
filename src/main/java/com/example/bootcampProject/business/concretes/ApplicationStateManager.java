package com.example.bootcampProject.business.concretes;

import com.example.bootcampProject.business.abstracts.ApplicationStateService;
import com.example.bootcampProject.business.constants.ApplicationStateMessages;
import com.example.bootcampProject.business.requests.create.applicationState.CreateApplicationStateRequest;
import com.example.bootcampProject.business.requests.update.applicationState.UpdateApplicationStateRequest;
import com.example.bootcampProject.business.responses.create.applicationState.CreateApplicationStateResponse;
import com.example.bootcampProject.business.responses.get.applicationState.GetAllApplicationStateResponse;
import com.example.bootcampProject.business.responses.update.applicationState.UpdateApplicationStateResponse;
import com.example.bootcampProject.core.utulities.mapping.ModelMapperService;
import com.example.bootcampProject.core.utulities.paging.PageDto;
import com.example.bootcampProject.core.utulities.results.DataResult;
import com.example.bootcampProject.core.utulities.results.Result;
import com.example.bootcampProject.core.utulities.results.SuccessDataResult;
import com.example.bootcampProject.core.utulities.results.SuccessResult;
import com.example.bootcampProject.dataAccess.abstracts.ApplicationStateRepository;
import com.example.bootcampProject.entities.concretes.ApplicationState;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
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
        return new SuccessDataResult<GetAllApplicationStateResponse>(response, ApplicationStateMessages.ApplicationStateGetById) ;
    }

    @Override
    public DataResult<List<GetAllApplicationStateResponse>> getAll() {
        List<ApplicationState> applicationStates = applicationStateRepository.findAll();
        List<GetAllApplicationStateResponse> applicationStateResponses = applicationStates.stream().map(applicationState -> modelMapperService.forResponse().map(applicationState, GetAllApplicationStateResponse.class)).toList();

        return new SuccessDataResult<List<GetAllApplicationStateResponse>>(applicationStateResponses, ApplicationStateMessages.ApplicationStateListed);
    }

    @Override
    public DataResult<CreateApplicationStateResponse> add(CreateApplicationStateRequest request) {
        ApplicationState applicationState = modelMapperService.forRequest().map(request, ApplicationState.class);
        applicationStateRepository.save(applicationState);
        CreateApplicationStateResponse response = modelMapperService.forResponse().map(applicationState, CreateApplicationStateResponse.class);

        return new SuccessDataResult<CreateApplicationStateResponse>(response, ApplicationStateMessages.ApplicationStateAdded);
    }

    @Override
    public DataResult<UpdateApplicationStateResponse> update(UpdateApplicationStateRequest updateApplicationStateRequest, int id) {
        ApplicationState applicationState = applicationStateRepository.findById(id);
        ApplicationState updatedApplicationState = modelMapperService.forRequest().map(updateApplicationStateRequest, ApplicationState.class);
        UpdateApplicationStateResponse response = modelMapperService.forResponse().map(applicationState, UpdateApplicationStateResponse.class);

        return new SuccessDataResult<UpdateApplicationStateResponse>(response, ApplicationStateMessages.ApplicationStateUpdated);
    }

    @Override
    public Result delete(int id) {
        ApplicationState applicationState= applicationStateRepository.getById(id);
        applicationStateRepository.delete(applicationState);
        return new SuccessResult(ApplicationStateMessages.ApplicationStateDeleted);
    }
    @Override
    public DataResult<List<GetAllApplicationStateResponse>> getAllPage(PageDto pageDto) {
        Sort sort=Sort.by(Sort.Direction.fromString(pageDto.getSortDirection()),pageDto.getSortBy());
        Pageable pageable = (Pageable) PageRequest.of(pageDto.getPageNumber(),pageDto.getPageSize(),sort);
        Page<ApplicationState> applicationStates= applicationStateRepository.findAll((org.springframework.data.domain.Pageable) pageable);
        List<GetAllApplicationStateResponse> responses=applicationStates.stream().map(applicationState -> modelMapperService.forResponse().map(applicationState,GetAllApplicationStateResponse.class)).toList();

        return new SuccessDataResult<List<GetAllApplicationStateResponse>>(responses) ;
    }

}
