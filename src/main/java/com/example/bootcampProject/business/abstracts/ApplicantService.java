package com.example.bootcampProject.business.abstracts;

import com.example.bootcampProject.business.requests.create.applicant.CreateApplicantRequest;
import com.example.bootcampProject.business.requests.create.user.CreateUserRequest;
import com.example.bootcampProject.business.requests.update.applicant.UpdateApplicantRequest;
import com.example.bootcampProject.business.requests.update.user.UpdateUserRequest;
import com.example.bootcampProject.business.responses.create.applicant.CreateApplicantResponse;
import com.example.bootcampProject.business.responses.create.user.CreateUserResponse;
import com.example.bootcampProject.business.responses.get.applicant.GetAllApplicantResponse;
import com.example.bootcampProject.business.responses.update.applicant.UpdateApplicantResponse;
import com.example.bootcampProject.business.responses.update.user.UpdateUserResponse;
import com.example.bootcampProject.business.responses.get.user.GetAllUserResponse;
import com.example.bootcampProject.core.utulities.paging.PageDto;
import com.example.bootcampProject.core.utulities.results.DataResult;
import com.example.bootcampProject.core.utulities.results.Result;

import java.util.List;

public interface ApplicantService {
    DataResult<GetAllApplicantResponse> getByAbout(String about);
    DataResult<CreateApplicantResponse> add(CreateApplicantRequest request);
    DataResult<UpdateApplicantResponse> update(UpdateApplicantRequest updateApplicantRequest, int id);
    Result delete(int id);
    DataResult<List<GetAllApplicantResponse>> getAll();
    DataResult<List<GetAllApplicantResponse>> getAllPage(PageDto pageDto);

    void checkIfAboutExists(String about);
}
