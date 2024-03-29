package com.example.bootcampProject.webApi.controllers;

import com.example.bootcampProject.business.abstracts.InstructorService;
import com.example.bootcampProject.business.requests.create.employee.CreateEmployeeRequest;
import com.example.bootcampProject.business.requests.create.instructor.CreateInstructorRequest;
import com.example.bootcampProject.business.requests.update.employee.UpdateEmployeeRequest;
import com.example.bootcampProject.business.requests.update.instructor.UpdateInstructorRequest;
import com.example.bootcampProject.core.utulities.paging.PageDto;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/instructor")
@AllArgsConstructor
public class InstructorController extends BaseController{
    private InstructorService instructorService;

    @GetMapping("/getbycompanyname/{companyName}")
    public ResponseEntity<?> getByCompanyName(@PathVariable String companyName){
        return handleDataResult(instructorService.getByCompanyName(companyName));
    }

    @PostMapping
    public ResponseEntity<?> add(@RequestBody @Valid CreateInstructorRequest instructorRequest) {
        return handleDataResult(instructorService.add(instructorRequest));
    }

    @GetMapping("getall")
    public ResponseEntity<?> getAll() {
        return handleDataResult(instructorService.getAll());
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        return handleResult(instructorService.delete(id));
    }

    @PutMapping("update/{id}")
    public ResponseEntity<?> update(@RequestBody @Valid UpdateInstructorRequest request, @PathVariable int id) {
        return handleDataResult(instructorService.update(request, id));
    }

    @GetMapping("sort")
    public  ResponseEntity<?> getAllPage(@RequestBody PageDto pageDto){
        return handleDataResult(instructorService.getAllPage(pageDto));
    }

}
