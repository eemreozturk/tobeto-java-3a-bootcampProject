package com.example.bootcampProject.business.abstracts;

import com.example.bootcampProject.business.requests.creat.user.CreatUserRequest;
import com.example.bootcampProject.business.responses.create.user.CreateUserResponse;
import com.example.bootcampProject.business.responses.create.user.UpdateUserRequest;
import com.example.bootcampProject.business.responses.get.user.GetAllUserResponse;
import com.example.bootcampProject.business.responses.get.user.GetUserResponse;

import java.util.List;

public interface UserService {
    CreateUserResponse add(CreatUserRequest request);
    UpdateUserRequest update(UpdateUserRequest updateUserRequest);
    void delete(int id);
    List<GetAllUserResponse> getAll();
    GetUserResponse getById(int id);

    GetAllUserResponse getByEmail(String email) ;

}
