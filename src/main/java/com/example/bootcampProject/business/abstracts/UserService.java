package com.example.bootcampProject.business.abstracts;

import com.example.bootcampProject.business.requests.create.user.CreateUserRequest;
import com.example.bootcampProject.business.requests.update.user.UpdateUserRequest;
import com.example.bootcampProject.business.responses.create.user.CreateUserResponse;
import com.example.bootcampProject.business.responses.update.user.UpdateUserResponse;
import com.example.bootcampProject.business.responses.get.user.GetAllUserResponse;
import com.example.bootcampProject.business.responses.get.user.GetUserResponse;
import com.example.bootcampProject.core.utulities.paging.PageDto;
import com.example.bootcampProject.core.utulities.results.DataResult;
import com.example.bootcampProject.core.utulities.results.Result;

import java.util.List;

public interface UserService {
    DataResult<UpdateUserResponse> update(UpdateUserRequest updateUserRequest, int id);

    DataResult<CreateUserResponse> add(CreateUserRequest request);

    Result delete(int id);
    DataResult<List<GetAllUserResponse>> getAll();
    DataResult<GetUserResponse> getById(int id);

    DataResult<GetAllUserResponse> getByEmail(String email) ;
    DataResult<List<GetAllUserResponse>> getAllPage(PageDto pageDto);

    void checkIfEmailExists(String email);
}
