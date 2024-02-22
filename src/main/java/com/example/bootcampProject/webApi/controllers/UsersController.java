package com.example.bootcampProject.webApi.controllers;

import com.example.bootcampProject.business.abstracts.UserService;
import com.example.bootcampProject.business.requests.creat.user.CreatUserRequest;
import com.example.bootcampProject.business.responses.create.user.UpdateUserResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UsersController extends BaseController{
    private UserService userService;

    @PostMapping()
    public ResponseEntity<?> add(@RequestBody CreatUserRequest request){
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
    public void delete(@PathVariable int id){
        this.userService.delete(id);
}

}
