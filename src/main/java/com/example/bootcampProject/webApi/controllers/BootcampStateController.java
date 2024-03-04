package com.example.bootcampProject.webApi.controllers;

import com.example.bootcampProject.business.abstracts.BootcampStateService;
import com.example.bootcampProject.business.requests.create.bootcampState.CreateBootcampStateRequest;
import com.example.bootcampProject.business.requests.update.bootcampState.UpdateBootcampStateRequest;
import com.example.bootcampProject.core.utulities.paging.PageDto;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bootcampState")
@AllArgsConstructor
public class BootcampStateController extends BaseController{
   private BootcampStateService bootcampStateService;

    @GetMapping("/getbyid/{id}")
    public ResponseEntity<?> getById(@PathVariable int id){
        return handleDataResult(bootcampStateService.getById(id));
    }

    @PostMapping
    public ResponseEntity<?> add(@RequestBody @Valid CreateBootcampStateRequest bootcampStateRequest) {
        return handleDataResult(bootcampStateService.add(bootcampStateRequest));
    }

    @GetMapping("getall")
    public ResponseEntity<?> getAll() {
        return handleDataResult(bootcampStateService.getAll());
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        return handleResult(bootcampStateService.delete(id));
    }

    @PutMapping("update/{id}")
    public ResponseEntity<?> update(@RequestBody @Valid UpdateBootcampStateRequest request, @PathVariable int id) {
        return handleDataResult(bootcampStateService.update(request, id));
    }

    @GetMapping("sort")
    public  ResponseEntity<?> getAllPage(@RequestBody PageDto pageDto){
        return handleDataResult(bootcampStateService.getAllPage(pageDto));
    }

}
