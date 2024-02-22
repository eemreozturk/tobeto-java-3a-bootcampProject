package com.example.bootcampProject.business.concretes;

import com.example.bootcampProject.business.abstracts.BootcampStateService;
import com.example.bootcampProject.business.responses.get.bootcampState.GetAllBootcampStateResponse;
import com.example.bootcampProject.core.utulities.mapping.ModelMapperService;
import com.example.bootcampProject.core.utulities.results.DataResult;
import com.example.bootcampProject.core.utulities.results.SuccessDataResult;
import com.example.bootcampProject.dataAccess.abstracts.BootcampStateRepository;
import com.example.bootcampProject.entities.concretes.BootcampState;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

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
}
