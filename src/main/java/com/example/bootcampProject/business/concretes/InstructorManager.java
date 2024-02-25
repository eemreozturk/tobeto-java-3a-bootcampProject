package com.example.bootcampProject.business.concretes;

import com.example.bootcampProject.business.abstracts.InstructorService;
import com.example.bootcampProject.business.requests.create.instructor.CreateInstructorRequest;
import com.example.bootcampProject.business.requests.create.user.CreateUserRequest;
import com.example.bootcampProject.business.requests.update.instructor.UpdateInstructorRequest;
import com.example.bootcampProject.business.responses.create.instructor.CreateInstructorResponse;
import com.example.bootcampProject.business.responses.create.user.CreateUserResponse;
import com.example.bootcampProject.business.responses.get.instructor.GetAllInstructorResponse;
import com.example.bootcampProject.business.responses.update.instructor.UpdateInstructorResponse;
import com.example.bootcampProject.business.responses.update.user.UpdateUserResponse;
import com.example.bootcampProject.business.responses.get.user.GetAllUserResponse;
import com.example.bootcampProject.core.utulities.results.DataResult;
import com.example.bootcampProject.core.utulities.results.Result;
import com.example.bootcampProject.core.utulities.results.SuccessDataResult;
import com.example.bootcampProject.entities.concretes.Instructor;
import com.example.bootcampProject.entities.concretes.User;
import com.example.bootcampProject.core.utulities.mapping.ModelMapperService;
import com.example.bootcampProject.dataAccess.abstracts.InstructorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class InstructorManager implements InstructorService {
    private InstructorRepository instructorRepository;
    private ModelMapperService modelMapperService;
    @Override
    public GetAllInstructorResponse getByCompanyName(String companyName) {
        User instructor = instructorRepository.findByCompanyName(companyName);
        GetAllInstructorResponse response = modelMapperService.forResponse().map(instructor,GetAllInstructorResponse.class);
        return response;
    }

    @Override
    public DataResult<CreateInstructorResponse> add(CreateInstructorRequest request) {
        LocalDate birthDate= LocalDate.parse(request.getDateOfBirth());
        Instructor instructor = modelMapperService.forRequest().map(request, Instructor.class);
        instructor.setCreatedDate(LocalDateTime.now());
        instructor.setDateOfBirth(birthDate);
        instructorRepository.save(instructor);
        CreateInstructorResponse response = modelMapperService.forResponse().map(instructor, CreateInstructorResponse.class);

        return new SuccessDataResult<CreateInstructorResponse>(response, "Added Successfully");
    }

    @Override
    public DataResult<UpdateInstructorResponse> update(UpdateInstructorRequest updateInstructorRequest, int id) {

        Instructor instructor = instructorRepository.findById(id).orElseThrow();
        Instructor instructor = modelMapperService.forRequest().map(updateInstructorRequest, Instructor.class);
        UpdateInstructorResponse response = modelMapperService.forResponse().map(instructor, UpdateInstructorResponse.class);

        return new SuccessDataResult<UpdateInstructorResponse>(response, "Updated Successfully");
    }

    @Override
    public Result delete(int id) {
        this.instructorRepository.deleteById(id);
    }

    @Override
    public DataResult<List<GetAllInstructorResponse>> getAll() {
        List<Instructor> instructors = instructorRepository.findAll();
        List<GetAllInstructorResponse> userResponses = instructors.stream().map(instructor -> modelMapperService.forResponse().map(instructor, GetAllInstructorResponse.class)).collect(Collectors.toList());

        return new SuccessDataResult<List<GetAllInstructorResponse>>(userResponses,"Listed Successfully") ;
    }
}
