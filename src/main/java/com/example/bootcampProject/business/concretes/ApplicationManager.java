package com.example.bootcampProject.business.concretes;

import com.example.bootcampProject.business.abstracts.ApplicationService;
import com.example.bootcampProject.business.constants.ApplicationMessages;
import com.example.bootcampProject.business.requests.create.application.CreateApplicationRequest;
import com.example.bootcampProject.business.responses.create.application.CreateApplicationResponse;
import com.example.bootcampProject.business.responses.update.application.UpdateApplicationResponse;
import com.example.bootcampProject.business.responses.create.user.CreateUserResponse;
import com.example.bootcampProject.business.responses.get.application.GetAllApplicationResponse;
import com.example.bootcampProject.business.responses.get.application.GetApplicationResponse;
import com.example.bootcampProject.core.utulities.mapping.ModelMapperService;
import com.example.bootcampProject.core.utulities.paging.PageDto;
import com.example.bootcampProject.core.utulities.results.DataResult;
import com.example.bootcampProject.core.utulities.results.Result;
import com.example.bootcampProject.core.utulities.results.SuccessDataResult;
import com.example.bootcampProject.core.utulities.results.SuccessResult;
import com.example.bootcampProject.dataAccess.abstracts.ApplicantRepository;
import com.example.bootcampProject.dataAccess.abstracts.ApplicationRepository;
import com.example.bootcampProject.entities.concretes.Application;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ApplicationManager implements ApplicationService {
    private ModelMapperService modelMapperService;
    private ApplicationRepository applicationRepository;
    @Override
    public DataResult<GetApplicationResponse> getById(int id) {
        Application application = applicationRepository.findById(id);
        GetAllApplicationResponse response = modelMapperService.forResponse().map(application,GetAllApplicationResponse.class);
        return new SuccessDataResult<GetAllApplicationResponse>(response, ApplicationMessages.ApplicationGetById) ;
    }

    @Override
    public DataResult<CreateApplicationResponse> add(CreateApplicationRequest request) {
        Application application = modelMapperService.forRequest().map(request, Application.class);
        applicationRepository.save(application);
        CreateUserResponse response = modelMapperService.forResponse().map(application, CreateApplicationResponse.class);

        return new SuccessDataResult<CreateApplicationResponse>(response, ApplicationMessages.ApplicationAdded);
    }

    @Override
    public DataResult<UpdateApplicationResponse> update(UpdateApplicationResponse updateApplicationResponse, int id) {

        Application application = applicationRepository.findById(id).orElseThrow();
        Application updatedApplication = modelMapperService.forRequest().map(updateApplicationResponse, Application.class);
        UpdateApplicationResponse response = modelMapperService.forResponse().map(application, UpdateApplicationResponse.class);

        return new SuccessDataResult<UpdateApplicationResponse>(response, ApplicationMessages.ApplicationUpdated);
    }
    @Override
    public Result delete(int id) {
        Application application = ApplicantRepository.getById(id);
        ApplicantRepository.delete(application);
        return new SuccessResult(ApplicationMessages.ApplicationDeleted);
    }
    @Override
    public DataResult<List<GetAllApplicationResponse>> getAll() {
        List<Application> applications = applicationRepository.findAll();
        List<GetAllApplicationResponse> applicationResponses = applications.stream().map(application -> modelMapperService.forResponse().map(application, GetAllApplicationResponse.class)).collect(Collectors.toList());

        return new SuccessDataResult<List<GetAllApplicationResponse>>(applicationResponses,ApplicationMessages.ApplicationListed) ;
    }

    @Override
    public DataResult<List<GetAllApplicationResponse>> getAllPage(PageDto pageDto) {
        Sort sort=Sort.by(Sort.Direction.fromString(pageDto.getSortDirection()),pageDto.getSortBy());
        Pageable pageable = PageRequest.of(pageDto.getPageNumber(),pageDto.getPageSize(),sort);
        Page<Application> applications= ApplicantRepository.findAll(pageable);
        List<GetAllApplicationResponse> responses=applications.stream().map(application -> modelMapperService.forResponse().map(application,GetAllApplicationResponse.class)).toList();

        return new SuccessDataResult<List<GetAllApplicationResponse>>(responses) ;
    }

}
