package com.example.bootcampProject.business.concretes;

import com.example.bootcampProject.business.abstracts.BootcampStateService;
import com.example.bootcampProject.business.constants.BootcampStateMessages;
import com.example.bootcampProject.business.requests.create.bootcampState.CreateBootcampStateRequest;
import com.example.bootcampProject.business.requests.update.bootcampState.UpdateBootcampStateRequest;
import com.example.bootcampProject.business.responses.create.bootcampState.CreateBootcampStateResponse;
import com.example.bootcampProject.business.responses.get.bootcampState.GetAllBootcampStateResponse;
import com.example.bootcampProject.business.responses.update.bootcampState.UpdateBootcampStateResponse;
import com.example.bootcampProject.core.utulities.mapping.ModelMapperService;
import com.example.bootcampProject.core.utulities.paging.PageDto;
import com.example.bootcampProject.core.utulities.results.DataResult;
import com.example.bootcampProject.core.utulities.results.Result;
import com.example.bootcampProject.core.utulities.results.SuccessDataResult;
import com.example.bootcampProject.core.utulities.results.SuccessResult;
import com.example.bootcampProject.dataAccess.abstracts.BootcampStateRepository;
import com.example.bootcampProject.entities.concretes.BootcampState;
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
public class BootcampStateManager implements BootcampStateService {
    private ModelMapperService modelMapperService;
    private BootcampStateRepository bootcampStateRepository;

    @Override
    public DataResult<GetAllBootcampStateResponse> getById(int id) {
        BootcampState bootcampState = bootcampStateRepository.findById(id);
        GetAllBootcampStateResponse response = modelMapperService.forResponse().map(bootcampState,GetAllBootcampStateResponse.class);
        return new SuccessDataResult<GetAllBootcampStateResponse>(response, BootcampStateMessages.BootcampStateGetById) ;
    }

    @Override
    public DataResult<List<GetAllBootcampStateResponse>> getAll() {
        List<BootcampState> bootcampStates = bootcampStateRepository.findAll();
        List<GetAllBootcampStateResponse> bootcampStateResponses = bootcampStates.stream().map(bootcampState -> modelMapperService.forResponse().map(bootcampState, GetAllBootcampStateResponse.class)).collect(Collectors.toList());

        return new SuccessDataResult<List<GetAllBootcampStateResponse>>(bootcampStateResponses,BootcampStateMessages.BootcampStateListed) ;
    }

    @Override
    public DataResult<CreateBootcampStateResponse> add(CreateBootcampStateRequest request) {
        BootcampState bootcampState = modelMapperService.forRequest().map(request, BootcampState.class);
        bootcampStateRepository.save(bootcampState);
        CreateBootcampStateResponse response = modelMapperService.forResponse().map(bootcampState, CreateBootcampStateResponse.class);

        return new SuccessDataResult<CreateBootcampStateResponse>(response, BootcampStateMessages.BootcampStateAdded);
    }

    @Override
    public DataResult<UpdateBootcampStateResponse> update(UpdateBootcampStateRequest updateBootcampStateRequest, int id) {
        BootcampState bootcampState = bootcampStateRepository.findById(id);
        BootcampState updatedBootcampState = modelMapperService.forRequest().map(updateBootcampStateRequest, BootcampState.class);
        UpdateBootcampStateResponse response = modelMapperService.forResponse().map(bootcampState, UpdateBootcampStateResponse.class);

        return new SuccessDataResult<UpdateBootcampStateResponse>(response, BootcampStateMessages.BootcampStateUpdated);
    }

    @Override
    public Result delete(int id) {
        BootcampState bootcampState= bootcampStateRepository.getById(id);
        bootcampStateRepository.delete(bootcampState);
        return new SuccessResult(BootcampStateMessages.BootcampStateDeleted);
    }
    @Override
    public DataResult<List<GetAllBootcampStateResponse>> getAllPage(PageDto pageDto) {
        Sort sort=Sort.by(Sort.Direction.fromString(pageDto.getSortDirection()),pageDto.getSortBy());
        Pageable pageable = (Pageable) PageRequest.of(pageDto.getPageNumber(),pageDto.getPageSize(),sort);
        Page<BootcampState> bootcampStates= bootcampStateRepository.findAll((org.springframework.data.domain.Pageable) pageable);
        List<GetAllBootcampStateResponse> responses=bootcampStates.stream().map(bootcampState -> modelMapperService.forResponse().map(bootcampState,GetAllBootcampStateResponse.class)).toList();

        return new SuccessDataResult<List<GetAllBootcampStateResponse>>(responses) ;
    }

}
