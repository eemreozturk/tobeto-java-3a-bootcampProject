package com.example.bootcampProject.webApi.controllers;

import com.example.bootcampProject.business.abstracts.UserService;
import com.example.bootcampProject.business.requests.create.user.CreateUserRequest;
import com.example.bootcampProject.business.requests.update.user.UpdateUserRequest;
import com.example.bootcampProject.business.responses.update.user.UpdateUserResponse;
import com.example.bootcampProject.core.utulities.paging.PageDto;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UsersController extends BaseController{
    private UserService userService;

    @PostMapping()
    public ResponseEntity<?> add(@RequestBody @Valid CreateUserRequest request){
        return handleDataResult(userService.add(request));
    }
    @GetMapping("/getall")
    public ResponseEntity<?> getAll(){
       return handleDataResult(userService.getAll());
    }

@GetMapping("/getbyid/{id}")
    public ResponseEntity<?> getById(@PathVariable int id){
    return handleDataResult(userService.getById(id));
    }
@PutMapping
    public void update(@RequestBody @Valid UpdateUserRequest updateUserRequest, @PathVariable int id){
        this.userService.update(updateUserRequest,id);
}
@DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id){
       return  handleResult(userService.delete(id));
}

    @GetMapping("sort")
    public  ResponseEntity<?> getAllPage(@RequestBody PageDto pageDto){
        return handleDataResult(userService.getAllPage(pageDto));
    }

}
