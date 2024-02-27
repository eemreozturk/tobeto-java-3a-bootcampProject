package com.example.bootcampProject.business.abstracts;

import com.example.bootcampProject.business.requests.create.user.CreateUserRequest;
import com.example.bootcampProject.business.responses.create.user.CreateUserResponse;
import com.example.bootcampProject.business.responses.get.employee.GetAllEmployeeResponse;
import com.example.bootcampProject.business.responses.update.user.UpdateUserResponse;
import com.example.bootcampProject.business.responses.get.user.GetAllUserResponse;
import com.example.bootcampProject.core.utulities.paging.PageDto;
import com.example.bootcampProject.core.utulities.results.DataResult;
import com.example.bootcampProject.core.utulities.results.Result;

import java.util.List;

public interface EmployeeService {
    DataResult<GetAllUserResponse> getByPosition(String position);
    DataResult<CreateUserResponse> add(CreateUserRequest request);
    DataResult<UpdateUserResponse> update(UpdateUserResponse updateUserRequest, int id);
    Result delete(int id);
    DataResult<List<GetAllUserResponse>> getAll();
    DataResult<List<GetAllEmployeeResponse>> getAllPage(PageDto pageDto);
}
