package com.example.bootcampProject.business.abstracts;

import com.example.bootcampProject.business.requests.create.instructor.CreateInstructorRequest;
import com.example.bootcampProject.business.requests.create.user.CreateUserRequest;
import com.example.bootcampProject.business.requests.update.instructor.UpdateInstructorRequest;
import com.example.bootcampProject.business.responses.create.instructor.CreateInstructorResponse;
import com.example.bootcampProject.business.responses.create.user.CreateUserResponse;
import com.example.bootcampProject.business.responses.get.instructor.GetAllInstructorResponse;
import com.example.bootcampProject.business.responses.update.instructor.UpdateInstructorResponse;
import com.example.bootcampProject.business.responses.update.user.UpdateUserResponse;
import com.example.bootcampProject.business.responses.get.user.GetAllUserResponse;
import com.example.bootcampProject.core.utulities.paging.PageDto;
import com.example.bootcampProject.core.utulities.results.DataResult;
import com.example.bootcampProject.core.utulities.results.Result;

import java.util.List;

public interface InstructorService {
    DataResult<GetAllInstructorResponse> getByCompanyName(String companyName) ;
    DataResult<CreateInstructorResponse> add(CreateInstructorRequest request);

    DataResult<UpdateInstructorResponse> update(UpdateInstructorRequest updateInstructorRequest, int id);

    Result delete(int id);
    DataResult<List<GetAllInstructorResponse>> getAll();
    DataResult<List<GetAllInstructorResponse>> getAllPage(PageDto pageDto);

    void checkIfCompanyNameExists(String companyName);
}
