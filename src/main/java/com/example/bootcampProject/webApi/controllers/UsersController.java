package com.example.bootcampProject.webApi.controllers;

import com.example.bootcampProject.business.abstracts.UserService;
import com.example.bootcampProject.business.requests.creat.user.CreatUserRequest;
import com.example.bootcampProject.business.responses.create.user.CreateUserResponse;
import com.example.bootcampProject.business.responses.create.user.UpdateUserRequest;
import com.example.bootcampProject.business.responses.get.user.GetAllUserResponse;
import com.example.bootcampProject.business.responses.get.user.GetUserResponse;
import com.example.bootcampProject.core.entities.User;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UsersController {
    private UserService userService;

    @PostMapping()
    public CreateUserResponse add(@RequestBody CreatUserRequest request){
       return userService.add(request);

    }
    @GetMapping("getall")
    public List<GetAllUserResponse> getAll(){
        return userService.getAll();
    }

@GetMapping("getbyid/{id}")
    public GetUserResponse getById(@PathVariable int id){
    return userService.getById(id);
    }
@PutMapping
    public void update(@RequestBody UpdateUserRequest updateUserRequest){
        this.userService.update(updateUserRequest);
}
@DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        this.userService.delete(id);
}

}
