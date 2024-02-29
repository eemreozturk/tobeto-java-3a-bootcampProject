package com.example.bootcampProject.business.abstracts;

import com.example.bootcampProject.business.requests.create.employee.CreateEmployeeRequest;
import com.example.bootcampProject.business.requests.update.employee.UpdateEmployeeRequest;
import com.example.bootcampProject.business.responses.create.employee.CreateEmployeeResponse;
import com.example.bootcampProject.business.responses.get.employee.GetAllEmployeeResponse;
import com.example.bootcampProject.business.responses.update.employee.UpdateEmployeeResponse;
import com.example.bootcampProject.core.utulities.paging.PageDto;
import com.example.bootcampProject.core.utulities.results.DataResult;
import com.example.bootcampProject.core.utulities.results.Result;

import java.util.List;

public interface EmployeeService {
    DataResult<GetAllEmployeeResponse> getByPosition(String position);
    DataResult<CreateEmployeeResponse> add(CreateEmployeeRequest request);


    DataResult<UpdateEmployeeResponse> update(UpdateEmployeeRequest updateEmployeeRequest, int id);

    Result delete(int id);
    DataResult<List<GetAllEmployeeResponse>> getAll();
    DataResult<List<GetAllEmployeeResponse>> getAllPage(PageDto pageDto);

    void checkIfPositionExists(String position);
}
