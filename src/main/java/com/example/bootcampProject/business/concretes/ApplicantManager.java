package com.example.bootcampProject.business.concretes;

import com.example.bootcampProject.business.abstracts.ApplicantService;
import com.example.bootcampProject.business.requests.create.user.CreateUserRequest;
import com.example.bootcampProject.business.requests.update.applicant.UpdateApplicantRequest;
import com.example.bootcampProject.business.responses.create.applicant.CreateApplicantResponse;
import com.example.bootcampProject.business.responses.create.user.CreateUserResponse;
import com.example.bootcampProject.business.responses.get.applicant.GetAllApplicantResponse;
import com.example.bootcampProject.business.responses.update.applicant.UpdateApplicantResponse;
import com.example.bootcampProject.core.utulities.results.Result;
import com.example.bootcampProject.entities.concretes.Applicant;
import com.example.bootcampProject.entities.concretes.User;
import com.example.bootcampProject.core.utulities.mapping.ModelMapperService;
import com.example.bootcampProject.core.utulities.results.DataResult;
import com.example.bootcampProject.core.utulities.results.SuccessDataResult;
import com.example.bootcampProject.dataAccess.abstracts.ApplicantRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class ApplicantManager implements ApplicantService  {
    private ModelMapperService modelMapperService;
    private ApplicantRepository applicantRepository;


    @Override
    public DataResult<UpdateApplicantResponse> update(UpdateApplicantRequest updateApplicantRequest, int id) {

        Applicant applicant = applicantRepository.findById(id).orElseThrow();
        Applicant updatedApplicant = modelMapperService.forRequest().map(updateApplicantRequest, Applicant.class);
        UpdateApplicantResponse response = modelMapperService.forResponse().map(applicant, UpdateApplicantResponse.class);

        return new SuccessDataResult<UpdateApplicantResponse>(response, "Updated Successfully");

    }

    @Override
    public Result delete(int id) {
        this.applicantRepository.deleteById(id);
    }


    @Override
    public DataResult<GetAllApplicantResponse> getByAbout(String about) {
        User applicant = applicantRepository.findByAbout(about);
        GetAllApplicantResponse response = modelMapperService.forResponse().map(applicant,GetAllApplicantResponse.class);
        return new SuccessDataResult<GetAllApplicantResponse>(response,"Added Successfully") ;
    }

    @Override
    public DataResult<CreateUserResponse> add(CreateUserRequest request) {
        LocalDate birthDate= LocalDate.parse(request.getDateOfBirth());
        Applicant applicant = modelMapperService.forRequest().map(request, Applicant.class);
        applicant.setCreatedDate(LocalDateTime.now());
        applicant.setDateOfBirth(birthDate);
        applicantRepository.save(applicant);
        CreateApplicantResponse response = modelMapperService.forResponse().map(applicant, CreateApplicantResponse.class);

        return new SuccessDataResult<CreateApplicantResponse>(response, "Added Successfully");
    }



    @Override
    public DataResult<List<GetAllApplicantResponse>> getAll() {
        List<Applicant> users = applicantRepository.findAll();
        List<GetAllApplicantResponse> userResponses = users.stream().map(applicant -> modelMapperService.forResponse().map(applicant, GetAllApplicantResponse.class)).collect(Collectors.toList());

        return new SuccessDataResult<List<GetAllApplicantResponse>>(userResponses,"Listed Successfully") ;
    }

}
