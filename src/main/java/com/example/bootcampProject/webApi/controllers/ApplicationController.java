package com.example.bootcampProject.webApi.controllers;

import com.example.bootcampProject.business.abstracts.ApplicationService;
import com.example.bootcampProject.business.requests.create.application.CreateApplicationRequest;
import com.example.bootcampProject.business.requests.update.applicationState.UpdateApplicationStateRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/application")
@AllArgsConstructor
public class ApplicationController extends BaseController {
    private ApplicationService applicationService;

    @GetMapping("/getbyid/{id}")
    public ResponseEntity<?> getById(@PathVariable int id){
        return handleDataResult(applicationService.getById(id));
    }

    @PostMapping
    public ResponseEntity<?> add(@RequestBody CreateApplicationRequest applicationRequest) {
        return handleDataResult(applicationService.add(applicationRequest));
    }

    @GetMapping("getall")
    public ResponseEntity<?> getAll() {
        return handleDataResult(applicationService.getAll());
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        return handleDataResult(applicationService.delete(id));
    }

    @PutMapping("update/{id}")
    public ResponseEntity<?> update(@RequestBody UpdateApplicationStateRequest request, @PathVariable int id) {
        return handleDataResult(applicationService.update(request, id));
    }


}
