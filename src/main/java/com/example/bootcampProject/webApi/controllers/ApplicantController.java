package com.example.bootcampProject.webApi.controllers;

import com.example.bootcampProject.business.abstracts.ApplicantService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/applicant")
@AllArgsConstructor
public class ApplicantController extends BaseController{
    private ApplicantService applicantService;

    @GetMapping("/getbyabout")
    public ResponseEntity<?> getByAbout{
        return handleDataResult(applicantService.getByAbout(String about));
    }

}
