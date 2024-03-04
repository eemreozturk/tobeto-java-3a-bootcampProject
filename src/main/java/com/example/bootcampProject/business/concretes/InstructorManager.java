package com.example.bootcampProject.business.concretes;

import com.example.bootcampProject.business.abstracts.InstructorService;
import com.example.bootcampProject.business.constants.InstructorMessages;
import com.example.bootcampProject.business.requests.create.instructor.CreateInstructorRequest;
import com.example.bootcampProject.business.requests.update.instructor.UpdateInstructorRequest;
import com.example.bootcampProject.business.responses.create.instructor.CreateInstructorResponse;
import com.example.bootcampProject.business.responses.get.instructor.GetAllInstructorResponse;
import com.example.bootcampProject.business.responses.update.instructor.UpdateInstructorResponse;
import com.example.bootcampProject.business.rules.InstructorBusinessRules;
import com.example.bootcampProject.core.exceptions.types.BusinessException;
import com.example.bootcampProject.core.utulities.paging.PageDto;
import com.example.bootcampProject.core.utulities.results.DataResult;
import com.example.bootcampProject.core.utulities.results.Result;
import com.example.bootcampProject.core.utulities.results.SuccessDataResult;
import com.example.bootcampProject.core.utulities.results.SuccessResult;
import com.example.bootcampProject.entities.concretes.Instructor;
import com.example.bootcampProject.entities.concretes.User;
import com.example.bootcampProject.core.utulities.mapping.ModelMapperService;
import com.example.bootcampProject.dataAccess.abstracts.InstructorRepository;
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
public class InstructorManager implements InstructorService {
    private InstructorRepository instructorRepository;
    private ModelMapperService modelMapperService;
    private InstructorBusinessRules instructorBusinessRules;
    @Override
    public DataResult<GetAllInstructorResponse> getByCompanyName(String companyName) {
        User instructor = instructorRepository.findByCompanyName(companyName);
        GetAllInstructorResponse response = modelMapperService.forResponse().map(instructor,GetAllInstructorResponse.class);
        return new SuccessDataResult<GetAllInstructorResponse>(response,InstructorMessages.InstructorGetByCompanyName);
    }

    @Override
    public DataResult<CreateInstructorResponse> add(CreateInstructorRequest request) {
        instructorBusinessRules.checkIfCompanyNameExists(request.getCompanyName());
        LocalDate birthDate= LocalDate.parse(request.getDateOfBirth());
        Instructor instructor = modelMapperService.forRequest().map(request, Instructor.class);
        instructor.setCreatedDate(LocalDateTime.now());
        instructor.setDateOfBirth(birthDate);
        instructorRepository.save(instructor);
        CreateInstructorResponse response = modelMapperService.forResponse().map(instructor, CreateInstructorResponse.class);

        return new SuccessDataResult<CreateInstructorResponse>(response, InstructorMessages.InstructorAdded);
    }

    @Override
    public DataResult<UpdateInstructorResponse> update(UpdateInstructorRequest updateInstructorRequest, int id) {

        Instructor instructor = instructorRepository.findById(id).orElseThrow();
        Instructor updatedInstructor = modelMapperService.forRequest().map(updateInstructorRequest, Instructor.class);
        UpdateInstructorResponse response = modelMapperService.forResponse().map(instructor, UpdateInstructorResponse.class);

        return new SuccessDataResult<UpdateInstructorResponse>(response, InstructorMessages.InstructorUpdated);
    }
    @Override
    public Result delete(int id) {
        Instructor instructor= instructorRepository.getById(id);
        instructorRepository.delete(instructor);
        return new SuccessResult(InstructorMessages.InstructorDeleted);
    }
    @Override
    public DataResult<List<GetAllInstructorResponse>> getAll() {
        List<Instructor> instructors = instructorRepository.findAll();
        List<GetAllInstructorResponse> userResponses = instructors.stream().map(instructor -> modelMapperService.forResponse().map(instructor, GetAllInstructorResponse.class)).collect(Collectors.toList());

        return new SuccessDataResult<List<GetAllInstructorResponse>>(userResponses,InstructorMessages.InstructorListed) ;
    }

    @Override
    public DataResult<List<GetAllInstructorResponse>> getAllPage(PageDto pageDto) {
        Sort sort=Sort.by(Sort.Direction.fromString(pageDto.getSortDirection()),pageDto.getSortBy());
        Pageable pageable = (Pageable) PageRequest.of(pageDto.getPageNumber(),pageDto.getPageSize(),sort);
        Page<Instructor> instructors= instructorRepository.findAll((org.springframework.data.domain.Pageable) pageable);
        List<GetAllInstructorResponse> responses=instructors.stream().map(instructor -> modelMapperService.forResponse().map(instructor,GetAllInstructorResponse.class)).toList();

        return new SuccessDataResult<List<GetAllInstructorResponse>>(responses) ;
    }

    @Override
    public void checkIfCompanyNameExists(String companyName) {


    }

}
