package com.example.bootcampProject.business.concretes;

import com.example.bootcampProject.business.abstracts.UserService;
import com.example.bootcampProject.business.requests.creat.user.CreatUserRequest;
import com.example.bootcampProject.business.responses.create.user.CreateUserResponse;
import com.example.bootcampProject.business.responses.create.user.UpdateUserRequest;
import com.example.bootcampProject.business.responses.get.user.GetAllUserResponse;
import com.example.bootcampProject.business.responses.get.user.GetUserResponse;
import com.example.bootcampProject.core.utulities.mapping.ModelMapperService;
import com.example.bootcampProject.dataAccess.abstracts.UserRepository;
import com.example.bootcampProject.core.entities.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class UserManager implements UserService{
    private UserRepository userRepository;
    private ModelMapperService modelMapperService;

    @Override
    public GetAllUserResponse getByEmail(String email) {
        User user = userRepository.findByEmail(email);
        GetAllUserResponse response = modelMapperService.forResponse().map(user,GetAllUserResponse.class);
        return response;
    }

    @Override
    public void delete(int id) {
    this.userRepository.deleteById(id);
    }

    @Override
    public UpdateUserRequest update(UpdateUserRequest updateUserRequest) {
        User user=modelMapperService.forRequest().map(updateUserRequest,User.class);
        userRepository.save(user);
        return null;
    }

    @Override
    public CreateUserResponse add(CreatUserRequest request) {
        LocalDate birthDate= LocalDate.parse(request.getDateOfBirth());
    User user=modelMapperService.forRequest().map(request,User.class);
        user.setCreatedDate(LocalDateTime.now());
        user.setDateOfBirth(birthDate);
        userRepository.save(user);
        CreateUserResponse response = modelMapperService.forResponse().map(user, CreateUserResponse.class);
        return response;
    }

    @Override
    public List<GetAllUserResponse> getAll() {
        List<User> users = userRepository.findAll();
         List<GetAllUserResponse> userResponses = users.stream().map(user -> modelMapperService.forResponse().map(user, GetAllUserResponse.class)).collect(Collectors.toList());

        return userResponses;
    }

    @Override
    public GetUserResponse getById(int id) {
        User user = userRepository.findById(id);
        GetUserResponse response = modelMapperService.forResponse().map(user,GetUserResponse.class);
        return response;
    }
}
