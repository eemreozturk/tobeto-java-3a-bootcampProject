package com.example.bootcampProject.webApi.controllers;

import com.example.bootcampProject.business.abstracts.UserService;
import com.example.bootcampProject.business.requests.create.user.CreateUserRequest;
import com.example.bootcampProject.business.responses.update.user.UpdateUserResponse;
import com.example.bootcampProject.core.utulities.paging.PageDto;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UsersController extends BaseController{
    private UserService userService;

    @PostMapping()
    public ResponseEntity<?> add(@RequestBody CreateUserRequest request){
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
    public void update(@RequestBody UpdateUserResponse updateUserRequest){
        this.userService.update(updateUserRequest);
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
