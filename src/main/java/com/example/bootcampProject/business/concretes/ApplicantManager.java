package com.example.bootcampProject.business.concretes;

import com.example.bootcampProject.business.abstracts.ApplicantService;
import com.example.bootcampProject.business.responses.get.user.GetAllUserResponse;
import com.example.bootcampProject.entities.concretes.User;
import com.example.bootcampProject.core.utulities.mapping.ModelMapperService;
import com.example.bootcampProject.core.utulities.results.DataResult;
import com.example.bootcampProject.core.utulities.results.SuccessDataResult;
import com.example.bootcampProject.dataAccess.abstracts.ApplicantRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class ApplicantManager implements ApplicantService  {
    private ModelMapperService modelMapperService;
    private ApplicantRepository applicantRepository;
    @Override
    public DataResult<GetAllUserResponse> getByAbout(String about) {
        User applicant = applicantRepository.findByAbout(about);
        GetAllUserResponse response = modelMapperService.forResponse().map(applicant,GetAllUserResponse.class);
        return new SuccessDataResult<GetAllUserResponse>(response,"Added Successfully") ;
    }
}
