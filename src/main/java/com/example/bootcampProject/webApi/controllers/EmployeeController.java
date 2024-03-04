package com.example.bootcampProject.webApi.controllers;

import com.example.bootcampProject.business.abstracts.EmployeeService;
import com.example.bootcampProject.business.requests.create.applicant.CreateApplicantRequest;
import com.example.bootcampProject.business.requests.create.employee.CreateEmployeeRequest;
import com.example.bootcampProject.business.requests.update.applicant.UpdateApplicantRequest;
import com.example.bootcampProject.business.requests.update.employee.UpdateEmployeeRequest;
import com.example.bootcampProject.core.utulities.paging.PageDto;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employee")
@AllArgsConstructor
public class EmployeeController extends BaseController{
    private EmployeeService employeeService;

    @GetMapping("/getbyposition/{position}")
    public ResponseEntity<?> getByPosition(@PathVariable String position){
        return handleDataResult(employeeService.getByPosition(position));
    }

    @PostMapping
    public ResponseEntity<?> add(@RequestBody @Valid CreateEmployeeRequest employeeRequest) {
        return handleDataResult(employeeService.add(employeeRequest));
    }

    @GetMapping("getall")
    public ResponseEntity<?> getAll() {
        return handleDataResult(employeeService.getAll());
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        return handleResult(employeeService.delete(id));
    }

    @PutMapping("update/{id}")
    public ResponseEntity<?> update(@RequestBody @Valid UpdateEmployeeRequest request, @PathVariable int id) {
        return handleDataResult(employeeService.update(request, id));
    }

    @GetMapping("sort")
    public  ResponseEntity<?> getAllPage(@RequestBody PageDto pageDto){
        return handleDataResult(employeeService.getAllPage(pageDto));
    }

}
