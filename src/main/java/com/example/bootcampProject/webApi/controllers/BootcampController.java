package com.example.bootcampProject.webApi.controllers;

import com.example.bootcampProject.business.abstracts.BootcampService;
import com.example.bootcampProject.business.requests.create.bootcamp.CreateBootcampRequest;
import com.example.bootcampProject.business.requests.update.bootcamp.UpdateBootcampRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
@RestController
@RequestMapping("/api/bootcamp")
@AllArgsConstructor
public class BootcampController extends BaseController{
    private BootcampService bootcampService;

    @GetMapping("/getbyid/{id}")
    public ResponseEntity<?> getById(@PathVariable int id){
        return handleDataResult(bootcampService.getById(id));
    }

    @PostMapping
    public ResponseEntity<?> add(@RequestBody CreateBootcampRequest bootcampRequest) {
        return handleDataResult(bootcampService.add(bootcampRequest));
    }

    @GetMapping("getall")
    public ResponseEntity<?> getAll() {
        return handleDataResult(bootcampService.getAll());
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        return handleDataResult(bootcampService.delete(id));
    }

    @PutMapping("update/{id}")
    public ResponseEntity<?> update(@RequestBody UpdateBootcampRequest request, @PathVariable int id) {
        return handleDataResult(bootcampService.update(request, id));
    }

}
