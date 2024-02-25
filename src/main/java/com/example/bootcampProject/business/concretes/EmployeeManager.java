package com.example.bootcampProject.business.concretes;

import com.example.bootcampProject.business.abstracts.EmployeeService;
import com.example.bootcampProject.business.requests.create.employee.CreateEmployeeRequest;
import com.example.bootcampProject.business.requests.update.employee.UpdateEmployeeRequest;
import com.example.bootcampProject.business.responses.create.employee.CreateEmployeeResponse;
import com.example.bootcampProject.business.responses.get.employee.GetAllEmployeeResponse;
import com.example.bootcampProject.business.responses.update.employee.UpdateEmployeeResponse;
import com.example.bootcampProject.core.utulities.results.DataResult;
import com.example.bootcampProject.core.utulities.results.Result;
import com.example.bootcampProject.core.utulities.results.SuccessDataResult;
import com.example.bootcampProject.entities.concretes.Employee;
import com.example.bootcampProject.entities.concretes.User;
import com.example.bootcampProject.core.utulities.mapping.ModelMapperService;
import com.example.bootcampProject.dataAccess.abstracts.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeManager implements EmployeeService {
    private ModelMapperService modelMapperService;
    private EmployeeRepository employeeRepository;
    @Override
    public GetAllEmployeeResponse getByPosition(String position) {
        User employee = employeeRepository.findByPosition(position);
        GetAllEmployeeResponse response = modelMapperService.forResponse().map(employee,GetAllEmployeeResponse.class);
        return response;
    }

    @Override
    public DataResult<CreateEmployeeResponse> add(CreateEmployeeRequest request) {
        LocalDate birthDate= LocalDate.parse(request.getDateOfBirth());
        Employee employee = modelMapperService.forRequest().map(request, Employee.class);
        employee.setCreatedDate(LocalDateTime.now());
        employee.setDateOfBirth(birthDate);
        EmployeeRepository.save(employee);
        CreateEmployeeResponse response = modelMapperService.forResponse().map(employee, CreateEmployeeResponse.class);

        return new SuccessDataResult<CreateEmployeeResponse>(response, "Added Successfully");
    }

    @Override
    public DataResult<UpdateEmployeeResponse> update(UpdateEmployeeRequest updateEmployeeRequest, int id) {


        Employee employee = employeeRepository.findById(id).orElseThrow();
        Employee employee = modelMapperService.forRequest().map(updateUserResponse, Employee.class);
        UpdateEmployeeResponse response = modelMapperService.forResponse().map(employee, UpdateEmployeeResponse.class);

        return new SuccessDataResult<UpdateEmployeeResponse>(response, "Updated Successfully");
    }

    @Override
    public Result delete(int id) {
        this.employeeRepository.deleteById(id);
    }

    @Override
    public DataResult<List<GetAllEmployeeResponse>> getAll() {
        List<Employee> employies = employeeRepository.findAll();
        List<GetAllEmployeeResponse> userResponses = employies.stream().map(employee -> modelMapperService.forResponse().map(employee, GetAllEmployeeResponse.class)).collect(Collectors.toList());

        return new SuccessDataResult<List<GetAllEmployeeResponse>>(userResponses,"Listed Successfully") ;
    }
}
