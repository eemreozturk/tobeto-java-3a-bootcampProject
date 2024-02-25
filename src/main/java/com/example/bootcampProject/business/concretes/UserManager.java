package com.example.bootcampProject.business.concretes;

import com.example.bootcampProject.business.abstracts.UserService;
import com.example.bootcampProject.business.requests.create.user.CreateUserRequest;
import com.example.bootcampProject.business.requests.update.user.UpdateUserRequest;
import com.example.bootcampProject.business.responses.create.user.CreateUserResponse;
import com.example.bootcampProject.business.responses.update.user.UpdateUserResponse;
import com.example.bootcampProject.business.responses.get.user.GetAllUserResponse;
import com.example.bootcampProject.business.responses.get.user.GetUserResponse;
import com.example.bootcampProject.core.utulities.mapping.ModelMapperService;
import com.example.bootcampProject.core.utulities.results.DataResult;
import com.example.bootcampProject.core.utulities.results.SuccessDataResult;
import com.example.bootcampProject.dataAccess.abstracts.UserRepository;
import com.example.bootcampProject.entities.concretes.User;
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
    public DataResult<GetAllUserResponse> getByEmail(String email) {
        User user = userRepository.findByEmail(email);
        GetAllUserResponse rresponse = modelMapperService.forResponse().map(user,GetAllUserResponse.class);
        return new SuccessDataResult<GetAllUserResponse>(rresponse,"Added Successfully") ;
    }

    @Override
    public void delete(int id) {
    this.userRepository.deleteById(id);
    }

    @Override
    public UpdateUserResponse update(UpdateUserRequest updateUserRequest, int id) {
        User user = userRepository.findById(id).orElseThrow();
        User updatedUser = modelMapperService.forRequest().map(updateUserRequest, User.class);
        UpdateUserResponse response = modelMapperService.forResponse().map(user, UpdateUserResponse.class);

        return new SuccessDataResult<UpdateUserResponse>(response, "Updated Successfully");
    }

    @Override
    public DataResult<CreateUserResponse> add(CreateUserRequest request) {
        LocalDate birthDate= LocalDate.parse(request.getDateOfBirth());
    User user=modelMapperService.forRequest().map(request,User.class);
        user.setCreatedDate(LocalDateTime.now());
        user.setDateOfBirth(birthDate);
        userRepository.save(user);
        CreateUserResponse response = modelMapperService.forResponse().map(user, CreateUserResponse.class);
        return new SuccessDataResult<CreateUserResponse>(response,"Added Successfully") ;
    }



    @Override
    public DataResult<List<GetAllUserResponse>> getAll() {
        List<User> users = userRepository.findAll();
         List<GetAllUserResponse> userResponses = users.stream().map(user -> modelMapperService.forResponse().map(user, GetAllUserResponse.class)).collect(Collectors.toList());

        return new SuccessDataResult<List<GetAllUserResponse>>(userResponses,"Listed Successfully") ;
    }

    @Override
    public DataResult<GetUserResponse> getById(int id) {
        User user = userRepository.findById(id);
        GetUserResponse response = modelMapperService.forResponse().map(user,GetUserResponse.class);
        return new SuccessDataResult<GetUserResponse>(response,"Get by id Successfully");
    }
}
