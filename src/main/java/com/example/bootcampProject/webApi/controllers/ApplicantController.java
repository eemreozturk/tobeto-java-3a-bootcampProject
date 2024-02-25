package com.example.bootcampProject.webApi.controllers;

import com.example.bootcampProject.business.abstracts.ApplicantService;
import com.example.bootcampProject.business.requests.create.applicant.CreateApplicantRequest;
import com.example.bootcampProject.business.requests.update.applicant.UpdateApplicantRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/applicant")
@AllArgsConstructor
public class ApplicantController extends BaseController{
    private ApplicantService applicantService;

    @GetMapping("/getbyabout/{about}")
    public ResponseEntity<?> getByAbout(@PathVariable String about){
        return handleDataResult(applicantService.getByAbout(about));
    }

    @PostMapping
    public ResponseEntity<?> add(@RequestBody CreateApplicantRequest applicantRequest) {
        return handleDataResult(applicantService.add(applicantRequest));
    }

    @GetMapping("getall")
    public ResponseEntity<?> getAll() {
        return handleDataResult(applicantService.getAll());
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        return handleDataResult(applicantService.delete(id));
    }

    @PutMapping("update/{id}")
    public ResponseEntity<?> update(@RequestBody UpdateApplicantRequest request, @PathVariable int id) {
        return handleDataResult(applicantService.update(request, id));
    }



}
