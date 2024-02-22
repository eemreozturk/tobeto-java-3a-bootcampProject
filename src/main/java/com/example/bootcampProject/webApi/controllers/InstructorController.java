package com.example.bootcampProject.webApi.controllers;

import com.example.bootcampProject.business.abstracts.InstructorService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/instructor")
@AllArgsConstructor
public class InstructorController extends BaseController{
    private InstructorService instructorService;
}
