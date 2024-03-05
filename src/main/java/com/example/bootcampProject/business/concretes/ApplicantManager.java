package com.example.bootcampProject.business.concretes;

import com.example.bootcampProject.business.abstracts.ApplicantService;
import com.example.bootcampProject.business.constants.ApplicantMessages;
import com.example.bootcampProject.business.requests.create.applicant.CreateApplicantRequest;
import com.example.bootcampProject.business.requests.update.applicant.UpdateApplicantRequest;
import com.example.bootcampProject.business.responses.create.applicant.CreateApplicantResponse;
import com.example.bootcampProject.business.responses.get.applicant.GetAllApplicantResponse;
import com.example.bootcampProject.business.responses.update.applicant.UpdateApplicantResponse;
import com.example.bootcampProject.business.rules.ApplicantBusinessRules;
import com.example.bootcampProject.core.aspects.logging.Loggable;
import com.example.bootcampProject.core.exceptions.types.BusinessException;
import com.example.bootcampProject.core.utulities.paging.PageDto;
import com.example.bootcampProject.core.utulities.results.Result;
import com.example.bootcampProject.core.utulities.results.SuccessResult;
import com.example.bootcampProject.entities.concretes.Applicant;
import com.example.bootcampProject.entities.concretes.User;
import com.example.bootcampProject.core.utulities.mapping.ModelMapperService;
import com.example.bootcampProject.core.utulities.results.DataResult;
import com.example.bootcampProject.core.utulities.results.SuccessDataResult;
import com.example.bootcampProject.dataAccess.abstracts.ApplicantRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class ApplicantManager implements ApplicantService {
    private ModelMapperService modelMapperService;
    private ApplicantRepository applicantRepository;
    private ApplicantBusinessRules applicantBusinessRules;


    @Override
    @Loggable
    public DataResult<UpdateApplicantResponse> update(UpdateApplicantRequest updateApplicantRequest, int id) {

        Applicant applicant = applicantRepository.findById(id).orElseThrow();
        Applicant updatedApplicant = modelMapperService.forRequest().map(updateApplicantRequest, Applicant.class);
        UpdateApplicantResponse response = modelMapperService.forResponse().map(applicant, UpdateApplicantResponse.class);

        return new SuccessDataResult<UpdateApplicantResponse>(response, ApplicantMessages.ApplicantUpdated);

    }

    @Override
    @Loggable
    public Result delete(int id) {
        Applicant applicant = applicantRepository.getById(id);
        applicantRepository.delete(applicant);
        return new SuccessResult(ApplicantMessages.ApplicantDeleted);
    }


    @Override
    public DataResult<GetAllApplicantResponse> getByAbout(String about) {
        User applicant = applicantRepository.findByAbout(about);
        GetAllApplicantResponse response = modelMapperService.forResponse().map(applicant, GetAllApplicantResponse.class);
        return new SuccessDataResult<GetAllApplicantResponse>(response, ApplicantMessages.ApplicantGetByAbout);
    }

    @Override
    @Loggable
    public DataResult<CreateApplicantResponse> add(CreateApplicantRequest request) {
        applicantBusinessRules.checkIfAboutExists(request.getAbout());
        LocalDate birthDate = LocalDate.parse(request.getDateOfBirth());
        Applicant applicant = modelMapperService.forRequest().map(request, Applicant.class);
        applicant.setCreatedDate(LocalDateTime.now());
        applicant.setDateOfBirth(birthDate);
        applicantRepository.save(applicant);
        CreateApplicantResponse response = modelMapperService.forResponse().map(applicant, CreateApplicantResponse.class);

        return new SuccessDataResult<CreateApplicantResponse>(response, ApplicantMessages.ApplicantAdded);
    }


    @Override
    @Loggable
    public DataResult<List<GetAllApplicantResponse>> getAll() {
        List<Applicant> users = applicantRepository.findAll();
        List<GetAllApplicantResponse> userResponses = users.stream().map(applicant -> modelMapperService.forResponse().map(applicant, GetAllApplicantResponse.class)).collect(Collectors.toList());

        return new SuccessDataResult<List<GetAllApplicantResponse>>(userResponses, ApplicantMessages.ApplicantListed);
    }

    @Override
    public DataResult<List<GetAllApplicantResponse>> getAllPage(PageDto pageDto) {
        Sort sort = Sort.by(Sort.Direction.fromString(pageDto.getSortDirection()), pageDto.getSortBy());
        Pageable pageable = (Pageable) PageRequest.of(pageDto.getPageNumber(), pageDto.getPageSize(), sort);
        Page<Applicant> applicants = applicantRepository.findAll((org.springframework.data.domain.Pageable) pageable);
        List<GetAllApplicantResponse> responses = applicants.stream().map(X -> modelMapperService.forResponse().map(X, GetAllApplicantResponse.class)).toList();

        return new SuccessDataResult<List<GetAllApplicantResponse>>(responses);
    }

    @Override
    public void checkIfAboutExists(String about) {

    }


}
