package com.example.bootcampProject.webApi.controllers;

import com.example.bootcampProject.business.abstracts.ApplicationStateService;
import com.example.bootcampProject.business.requests.create.applicationState.CreateApplicationStateRequest;
import com.example.bootcampProject.business.requests.update.applicationState.UpdateApplicationStateRequest;
import com.example.bootcampProject.core.utulities.paging.PageDto;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/applicationState")
@AllArgsConstructor
public class ApplicationStateController extends BaseController{
 private ApplicationStateService applicationStateService;

    @GetMapping("/getbyid/{id}")
    public ResponseEntity<?> getById(@PathVariable int id){
        return handleDataResult(applicationStateService.getById(id));
    }

    @PostMapping
    public ResponseEntity<?> add(@RequestBody CreateApplicationStateRequest applicationStateRequest) {
        return handleDataResult(applicationStateService.add(applicationStateRequest));
    }

    @GetMapping("getall")
    public ResponseEntity<?> getAll() {
        return handleResult(applicationStateService.getAll());
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        return handleDataResult(applicationStateService.delete(id));
    }

    @PutMapping("update/{id}")
    public ResponseEntity<?> update(@RequestBody UpdateApplicationStateRequest request, @PathVariable int id) {
        return handleDataResult(applicationStateService.update(request, id));
    }

    @GetMapping("sort")
    public  ResponseEntity<?> getAllPage(@RequestBody PageDto pageDto){
        return handleDataResult(applicationStateService.getAllPage(pageDto));
    }
}
