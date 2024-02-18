package com.example.bootcampProject.business.abstracts;

import com.example.bootcampProject.business.responses.get.user.GetAllUserResponse;

public interface EmployeeService {
    GetAllUserResponse getByPosition(String position);
}
