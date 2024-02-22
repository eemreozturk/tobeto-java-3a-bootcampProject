package com.example.bootcampProject.webApi.controllers;

import com.example.bootcampProject.business.abstracts.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/employee")
@AllArgsConstructor
public class EmployeeController extends BaseController{
    private EmployeeService employeeService;
}
