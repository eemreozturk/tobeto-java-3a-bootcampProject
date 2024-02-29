package com.example.bootcampProject.business.concretes;

import com.example.bootcampProject.business.abstracts.UserService;
import com.example.bootcampProject.business.constants.UserMessages;
import com.example.bootcampProject.business.requests.create.user.CreateUserRequest;
import com.example.bootcampProject.business.requests.update.user.UpdateUserRequest;
import com.example.bootcampProject.business.responses.create.user.CreateUserResponse;
import com.example.bootcampProject.business.responses.update.user.UpdateUserResponse;
import com.example.bootcampProject.business.responses.get.user.GetAllUserResponse;
import com.example.bootcampProject.business.responses.get.user.GetUserResponse;
import com.example.bootcampProject.core.exceptions.types.BusinessException;
import com.example.bootcampProject.core.utulities.mapping.ModelMapperService;
import com.example.bootcampProject.core.utulities.paging.PageDto;
import com.example.bootcampProject.core.utulities.results.DataResult;
import com.example.bootcampProject.core.utulities.results.Result;
import com.example.bootcampProject.core.utulities.results.SuccessDataResult;
import com.example.bootcampProject.core.utulities.results.SuccessResult;
import com.example.bootcampProject.dataAccess.abstracts.UserRepository;
import com.example.bootcampProject.entities.concretes.User;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
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
        return new SuccessDataResult<GetAllUserResponse>(rresponse, UserMessages.UserGetByEmail) ;
    }
    @Override
    public Result delete(int id) {
        User user= userRepository.getById(id);
        userRepository.delete(user);
        return new SuccessResult(UserMessages.UserDeleted);
    }
    @Override
    public DataResult<UpdateUserResponse> update(UpdateUserRequest updateUserRequest, int id) {
        User user = userRepository.findById(id);
        User updatedUser = modelMapperService.forRequest().map(updateUserRequest, User.class);
        UpdateUserResponse response = modelMapperService.forResponse().map(user, UpdateUserResponse.class);

        return new SuccessDataResult<UpdateUserResponse>(response, UserMessages.UserUpdated);
    }

    @Override
    public DataResult<CreateUserResponse> add(CreateUserRequest request) {
        checkIfEmailExists(request.getEmail());
        LocalDate birthDate= LocalDate.parse(request.getDateOfBirth());
    User user=modelMapperService.forRequest().map(request,User.class);
        user.setCreatedDate(LocalDateTime.now());
        user.setDateOfBirth(birthDate);
        userRepository.save(user);
        CreateUserResponse response = modelMapperService.forResponse().map(user, CreateUserResponse.class);
        return new SuccessDataResult<CreateUserResponse>(response,UserMessages.UserAdded) ;
    }



    @Override
    public DataResult<List<GetAllUserResponse>> getAll() {
        List<User> users = userRepository.findAll();
         List<GetAllUserResponse> userResponses = users.stream().map(user -> modelMapperService.forResponse().map(user, GetAllUserResponse.class)).collect(Collectors.toList());

        return new SuccessDataResult<List<GetAllUserResponse>>(userResponses,UserMessages.UserListed) ;
    }

    @Override
    public DataResult<GetUserResponse> getById(int id) {
        User user = userRepository.findById(id);
        GetUserResponse response = modelMapperService.forResponse().map(user,GetUserResponse.class);
        return new SuccessDataResult<GetUserResponse>(response,UserMessages.UserGetById);
    }

    @Override
    public DataResult<List<GetAllUserResponse>> getAllPage(PageDto pageDto) {
        Sort sort=Sort.by(Sort.Direction.fromString(pageDto.getSortDirection()),pageDto.getSortBy());
        Pageable pageable = (Pageable) PageRequest.of(pageDto.getPageNumber(),pageDto.getPageSize(),sort);
        Page<User> users= userRepository.findAll((org.springframework.data.domain.Pageable) pageable);
        List<GetAllUserResponse> responses=users.stream().map(user -> modelMapperService.forResponse().map(user,GetAllUserResponse.class)).toList();

        return new SuccessDataResult<List<GetAllUserResponse>>(responses) ;
    }

    @Override
    public void checkIfEmailExists(String email) {
        User user = userRepository.getByEmail(email.trim());
        if(user != null){
            throw new BusinessException("Email is used!");
        }
    }

}
