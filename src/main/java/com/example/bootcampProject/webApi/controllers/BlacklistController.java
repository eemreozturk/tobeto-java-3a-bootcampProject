package com.example.bootcampProject.webApi.controllers;

import com.example.bootcampProject.business.abstracts.BlacklistService;
import com.example.bootcampProject.business.requests.create.blacklist.CreateBlacklistRequest;
import com.example.bootcampProject.business.requests.update.blacklist.UpdateBlacklistRequest;
import com.example.bootcampProject.core.utulities.paging.PageDto;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/blacklist")
@AllArgsConstructor
public class BlacklistController extends BaseController {
    private BlacklistService blacklistService;

    @GetMapping("/getbyid/{id}")
    public ResponseEntity<?> getById(@PathVariable int id){
        return handleDataResult(blacklistService.getById(id));
    }

    @PostMapping
    public ResponseEntity<?> add(@RequestBody CreateBlacklistRequest blacklistRequest) {
        return handleDataResult(blacklistService.add(blacklistRequest));
    }

    @GetMapping("getall")
    public ResponseEntity<?> getAll() {
        return handleDataResult(blacklistService.getAll());
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        return handleResult(blacklistService.delete(id));
    }

    @PutMapping("update/{id}")
    public ResponseEntity<?> update(@RequestBody UpdateBlacklistRequest request, @PathVariable int id) {
        return handleDataResult(blacklistService.update(request, id));
    }

    @GetMapping("sort")
    public  ResponseEntity<?> getAllPage(@RequestBody PageDto pageDto){
        return handleDataResult(blacklistService.getAllPage(pageDto));
    }
}
