package com.example.bootcampProject.business.concretes;

import com.example.bootcampProject.business.abstracts.BootcampService;
import com.example.bootcampProject.business.requests.create.bootcamp.CreateBootcampRequest;
import com.example.bootcampProject.business.requests.update.bootcamp.UpdateBootcampRequest;
import com.example.bootcampProject.business.responses.create.bootcamp.CreateBootcampResponse;
import com.example.bootcampProject.business.responses.update.bootcamp.UpdateBootcampResponse;
import com.example.bootcampProject.business.responses.create.user.CreateUserResponse;
import com.example.bootcampProject.business.responses.get.bootcamp.GetAllBootcampResponse;
import com.example.bootcampProject.business.responses.get.bootcamp.GetBootcampResponse;
import com.example.bootcampProject.core.utulities.mapping.ModelMapperService;
import com.example.bootcampProject.core.utulities.results.DataResult;
import com.example.bootcampProject.core.utulities.results.Result;
import com.example.bootcampProject.core.utulities.results.SuccessDataResult;
import com.example.bootcampProject.dataAccess.abstracts.BootcampRepository;
import com.example.bootcampProject.entities.concretes.Bootcamp;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BootcampManager implements BootcampService {
    private ModelMapperService modelMapperService;
    private BootcampRepository bootcampRepository;

    @Override
    public DataResult<GetBootcampResponse> getById(int id) {
        Bootcamp bootcamp = bootcampRepository.findById(id);
        GetAllBootcampResponse response = modelMapperService.forResponse().map(bootcamp,GetAllBootcampResponse.class);
        return new SuccessDataResult<GetAllBootcampResponse>(response,"Listed Successfully") ;
    }

    @Override
    public DataResult<List<GetAllBootcampResponse>> getAll() {
        List<Bootcamp> bootcamps = bootcampRepository.findAll();
        List<GetAllBootcampResponse> bootcampResponses = bootcamps.stream().map(bootcamp -> modelMapperService.forResponse().map(bootcamp, GetAllBootcampResponse.class)).collect(Collectors.toList());

        return new SuccessDataResult<List<GetAllBootcampResponse>>(bootcampResponses,"Listed Successfully") ;
    }

    @Override
    public DataResult<CreateBootcampResponse> add(CreateBootcampRequest request) {
        Bootcamp bootcamp = modelMapperService.forRequest().map(request, Bootcamp.class);
        bootcampRepository.save(bootcamp);
        CreateUserResponse response = modelMapperService.forResponse().map(bootcamp, CreateBootcampResponse.class);

        return new SuccessDataResult<CreateBootcampResponse>(response, "Added Successfully");
    }

    @Override
    public DataResult<UpdateBootcampResponse> update(UpdateBootcampRequest updateBootcampRequest, int id) {
        Bootcamp bootcamp = bootcampRepository.findById(id).orElseThrow();
        Bootcamp updatedBootcamp = modelMapperService.forRequest().map(updateBootcampRequest, Bootcamp.class);
        UpdateBootcampResponse response = modelMapperService.forResponse().map(bootcamp, UpdateBootcampResponse.class);

        return new SuccessDataResult<UpdateBootcampResponse>(response, "Updated Successfully");
    }

    @Override
    public Result delete(int id) {
        this.bootcampRepository.deleteById(id);
    }
}
}
