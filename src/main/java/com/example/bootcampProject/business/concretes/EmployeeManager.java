package com.example.bootcampProject.business.concretes;

import com.example.bootcampProject.business.abstracts.EmployeeService;
import com.example.bootcampProject.business.constants.EmployeeMessages;
import com.example.bootcampProject.business.requests.create.employee.CreateEmployeeRequest;
import com.example.bootcampProject.business.requests.update.employee.UpdateEmployeeRequest;
import com.example.bootcampProject.business.responses.create.employee.CreateEmployeeResponse;
import com.example.bootcampProject.business.responses.get.employee.GetAllEmployeeResponse;
import com.example.bootcampProject.business.responses.update.employee.UpdateEmployeeResponse;
import com.example.bootcampProject.core.exceptions.types.BusinessException;
import com.example.bootcampProject.core.utulities.paging.PageDto;
import com.example.bootcampProject.core.utulities.results.DataResult;
import com.example.bootcampProject.core.utulities.results.Result;
import com.example.bootcampProject.core.utulities.results.SuccessDataResult;
import com.example.bootcampProject.core.utulities.results.SuccessResult;
import com.example.bootcampProject.entities.concretes.Employee;
import com.example.bootcampProject.core.utulities.mapping.ModelMapperService;
import com.example.bootcampProject.dataAccess.abstracts.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
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
    public DataResult<GetAllEmployeeResponse> getByPosition(String position) {
        Employee employee = employeeRepository.findByPosition(position);
        GetAllEmployeeResponse response = modelMapperService.forResponse().map(employee,GetAllEmployeeResponse.class);
        return new SuccessDataResult<GetAllEmployeeResponse>(response, EmployeeMessages.EmployeeGetByPosition);
    }

    @Override
    public DataResult<CreateEmployeeResponse> add(CreateEmployeeRequest request) {
        checkIfPositionExists(request.getPosition());
        LocalDate birthDate= LocalDate.parse(request.getDateOfBirth());
        Employee employee = modelMapperService.forRequest().map(request, Employee.class);
        employee.setCreatedDate(LocalDateTime.now());
        employee.setDateOfBirth(birthDate);
        employeeRepository.save(employee);
        CreateEmployeeResponse response = modelMapperService.forResponse().map(employee, CreateEmployeeResponse.class);

        return new SuccessDataResult<CreateEmployeeResponse>(response, EmployeeMessages.EmployeeAdded);
    }

    @Override
    public DataResult<UpdateEmployeeResponse> update(UpdateEmployeeRequest updateEmployeeRequest, int id) {


        Employee employee = employeeRepository.findById(id).orElseThrow();
        Employee updatedEmployee = modelMapperService.forRequest().map(updateEmployeeRequest, Employee.class);
        UpdateEmployeeResponse response = modelMapperService.forResponse().map(employee, UpdateEmployeeResponse.class);

        return new SuccessDataResult<UpdateEmployeeResponse>(response, EmployeeMessages.EmployeeUpdated);
    }

    @Override
    public Result delete(int id) {
        Employee employee= employeeRepository.getById(id);
        employeeRepository.delete(employee);
        return new SuccessResult(EmployeeMessages.EmployeeDeleted);
    }
    @Override
    public DataResult<List<GetAllEmployeeResponse>> getAll() {
        List<Employee> employies = employeeRepository.findAll();
        List<GetAllEmployeeResponse> userResponses = employies.stream().map(employee -> modelMapperService.forResponse().map(employee, GetAllEmployeeResponse.class)).collect(Collectors.toList());

        return new SuccessDataResult<List<GetAllEmployeeResponse>>(userResponses,EmployeeMessages.EmployeeListed) ;
    }

    @Override
    public DataResult<List<GetAllEmployeeResponse>> getAllPage(PageDto pageDto) {
        Sort sort=Sort.by(Sort.Direction.fromString(pageDto.getSortDirection()),pageDto.getSortBy());
        Pageable pageable = (Pageable) PageRequest.of(pageDto.getPageNumber(),pageDto.getPageSize(),sort);
        Page<Employee> employees= employeeRepository.findAll((org.springframework.data.domain.Pageable) pageable);
        List<GetAllEmployeeResponse> responses=employees.stream().map(employee -> modelMapperService.forResponse().map(employee,GetAllEmployeeResponse.class)).toList();

        return new SuccessDataResult<List<GetAllEmployeeResponse>>(responses) ;
    }
    @Override
    public void checkIfPositionExists(String position) {
        Employee employee = employeeRepository.getByPosition(position.trim());
        if (employee != null) {
            throw new BusinessException("Position is used!");
        }

    }

}
