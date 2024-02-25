package com.example.bootcampProject.business.concretes;

import com.example.bootcampProject.business.abstracts.BootcampStateService;
import com.example.bootcampProject.business.requests.create.bootcampState.CreateBootcampStateRequest;
import com.example.bootcampProject.business.requests.update.bootcampState.UpdateBootcampStateRequest;
import com.example.bootcampProject.business.responses.create.bootcampState.CreateBootcampStateResponse;
import com.example.bootcampProject.business.responses.get.bootcampState.GetAllBootcampStateResponse;
import com.example.bootcampProject.business.responses.update.bootcampState.UpdateBootcampStateResponse;
import com.example.bootcampProject.core.utulities.mapping.ModelMapperService;
import com.example.bootcampProject.core.utulities.results.DataResult;
import com.example.bootcampProject.core.utulities.results.Result;
import com.example.bootcampProject.core.utulities.results.SuccessDataResult;
import com.example.bootcampProject.dataAccess.abstracts.BootcampStateRepository;
import com.example.bootcampProject.entities.concretes.BootcampState;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BootcampStateManager implements BootcampStateService {
    private ModelMapperService modelMapperService;
    private BootcampStateRepository bootcampStateRepository;

    @Override
    public DataResult<GetAllBootcampStateResponse> getById(int id) {
        BootcampState bootcampState = bootcampStateRepository.findById(id);
        GetAllBootcampStateResponse response = modelMapperService.forResponse().map(bootcampState,GetAllBootcampStateResponse.class);
        return new SuccessDataResult<GetAllBootcampStateResponse>(response,"Listed Successfully") ;
    }

    @Override
    public DataResult<List<GetAllBootcampStateResponse>> getAll() {
        List<BootcampState> bootcampStates = bootcampStateRepository.findAll();
        List<GetAllBootcampStateResponse> bootcampStateResponses = bootcampStates.stream().map(bootcampState -> modelMapperService.forResponse().map(bootcampState, GetAllBootcampStateResponse.class)).collect(Collectors.toList());

        return new SuccessDataResult<List<GetAllBootcampStateResponse>>(bootcampStateResponses,"Listed Successfully") ;
    }

    @Override
    public DataResult<CreateBootcampStateResponse> add(CreateBootcampStateRequest request) {
        BootcampState bootcampState = modelMapperService.forRequest().map(request, BootcampState.class);
        bootcampStateRepository.save(bootcampState);
        CreateBootcampStateResponse response = modelMapperService.forResponse().map(bootcampState, CreateBootcampStateResponse.class);

        return new SuccessDataResult<CreateBootcampStateResponse>(response, "Added Successfully");
    }

    @Override
    public DataResult<UpdateBootcampStateResponse> update(UpdateBootcampStateRequest updateBootcampStateRequest, int id) {
        BootcampState bootcampState = bootcampStateRepository.findById(id).orElseThrow();
        BootcampState updatedBootcampState = modelMapperService.forRequest().map(updateBootcampStateRequest, BootcampState.class);
        UpdateBootcampStateResponse response = modelMapperService.forResponse().map(bootcampState, UpdateBootcampStateResponse.class);

        return new SuccessDataResult<UpdateBootcampStateResponse>(response, "Updated Successfully");
    }

    @Override
    public Result delete(int id) {
        this.bootcampStateRepository.deleteById(id);
    }
}
