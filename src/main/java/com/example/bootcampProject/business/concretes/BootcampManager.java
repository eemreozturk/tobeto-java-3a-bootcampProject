package com.example.bootcampProject.business.concretes;

import com.example.bootcampProject.business.abstracts.BootcampService;
import com.example.bootcampProject.business.constants.BootcampMessages;
import com.example.bootcampProject.business.requests.create.bootcamp.CreateBootcampRequest;
import com.example.bootcampProject.business.requests.update.bootcamp.UpdateBootcampRequest;
import com.example.bootcampProject.business.responses.create.bootcamp.CreateBootcampResponse;
import com.example.bootcampProject.business.responses.update.bootcamp.UpdateBootcampResponse;
import com.example.bootcampProject.business.responses.create.user.CreateUserResponse;
import com.example.bootcampProject.business.responses.get.bootcamp.GetAllBootcampResponse;
import com.example.bootcampProject.business.rules.BootcampBusinessRules;
import com.example.bootcampProject.core.utulities.mapping.ModelMapperService;
import com.example.bootcampProject.core.utulities.paging.PageDto;
import com.example.bootcampProject.core.utulities.results.DataResult;
import com.example.bootcampProject.core.utulities.results.Result;
import com.example.bootcampProject.core.utulities.results.SuccessDataResult;
import com.example.bootcampProject.core.utulities.results.SuccessResult;
import com.example.bootcampProject.dataAccess.abstracts.BootcampRepository;
import com.example.bootcampProject.entities.concretes.Bootcamp;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BootcampManager implements BootcampService {
    private ModelMapperService modelMapperService;
    private BootcampRepository bootcampRepository;
    private BootcampBusinessRules bootcampBusinessRules;

    @Override
    public SuccessDataResult<GetAllBootcampResponse> getById(int id) {
        Bootcamp bootcamp = bootcampRepository.findById(id);
        GetAllBootcampResponse response = modelMapperService.forResponse().map(bootcamp,GetAllBootcampResponse.class);
        return new SuccessDataResult<GetAllBootcampResponse>(response, BootcampMessages.BootcampGetById) ;
    }

    @Override
    public DataResult<List<GetAllBootcampResponse>> getAll() {
        List<Bootcamp> bootcamps = bootcampRepository.findAll();
        List<GetAllBootcampResponse> bootcampResponses = bootcamps.stream().map(bootcamp -> modelMapperService.forResponse().map(bootcamp, GetAllBootcampResponse.class)).collect(Collectors.toList());

        return new SuccessDataResult<List<GetAllBootcampResponse>>(bootcampResponses,BootcampMessages.BootcampListed) ;
    }

    @Override
    public DataResult<CreateBootcampResponse> add(CreateBootcampRequest request) {
        bootcampBusinessRules.checkIfNameExists(request.getName());
        Bootcamp bootcamp = modelMapperService.forRequest().map(request, Bootcamp.class);
        bootcampRepository.save(bootcamp);
        CreateBootcampResponse response = modelMapperService.forResponse().map(bootcamp, CreateBootcampResponse.class);

        return new SuccessDataResult<CreateBootcampResponse>(response, BootcampMessages.BootcampAdded);
    }

    @Override
    public DataResult<UpdateBootcampResponse> update(UpdateBootcampRequest updateBootcampRequest, int id) {
        Bootcamp bootcamp = bootcampRepository.findById(id);
        Bootcamp updatedBootcamp = modelMapperService.forRequest().map(updateBootcampRequest, Bootcamp.class);
        UpdateBootcampResponse response = modelMapperService.forResponse().map(bootcamp, UpdateBootcampResponse.class);

        return new SuccessDataResult<UpdateBootcampResponse>(response, BootcampMessages.BootcampUpdated);
    }

    @Override
    public Result delete(int id) {
        Bootcamp bootcamp= bootcampRepository.getById(id);
        bootcampRepository.delete(bootcamp);
        return new SuccessResult(BootcampMessages.BootcampDeleted);
    }
    @Override
    public DataResult<List<GetAllBootcampResponse>> getAllPage(PageDto pageDto) {
        Sort sort=Sort.by(Sort.Direction.fromString(pageDto.getSortDirection()),pageDto.getSortBy());
        Pageable pageable = (Pageable) PageRequest.of(pageDto.getPageNumber(),pageDto.getPageSize(),sort);
        Page<Bootcamp> bootcamps= bootcampRepository.findAll((org.springframework.data.domain.Pageable) pageable);
        List<GetAllBootcampResponse> responses=bootcamps.stream().map(bootcamp -> modelMapperService.forResponse().map(bootcamp,GetAllBootcampResponse.class)).toList();

        return new SuccessDataResult<List<GetAllBootcampResponse>>(responses) ;
    }

}

