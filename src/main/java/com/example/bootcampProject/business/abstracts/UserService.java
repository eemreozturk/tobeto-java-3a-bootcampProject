package com.example.bootcampProject.business.abstracts;

import com.example.bootcampProject.business.requests.creat.user.CreatUserRequest;
import com.example.bootcampProject.business.responses.create.user.CreateUserResponse;
import com.example.bootcampProject.business.responses.create.user.UpdateUserResponse;
import com.example.bootcampProject.business.responses.get.user.GetAllUserResponse;
import com.example.bootcampProject.business.responses.get.user.GetUserResponse;
import com.example.bootcampProject.core.utulities.results.DataResult;

import java.util.List;

public interface UserService {
    DataResult<CreateUserResponse> add(CreatUserRequest request);
    UpdateUserResponse update(UpdateUserResponse updateUserRequest);
    void delete(int id);
    DataResult<List<GetAllUserResponse>> getAll();
    DataResult<GetUserResponse> getById(int id);

    DataResult<GetAllUserResponse> getByEmail(String email) ;

}
