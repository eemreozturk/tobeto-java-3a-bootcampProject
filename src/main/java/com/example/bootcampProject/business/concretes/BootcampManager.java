package com.example.bootcampProject.business.concretes;

import com.example.bootcampProject.business.abstracts.BootcampService;
import com.example.bootcampProject.business.responses.get.bootcamp.GetAllBootcampResponse;
import com.example.bootcampProject.business.responses.get.bootcamp.GetBootcampResponse;
import com.example.bootcampProject.core.utulities.mapping.ModelMapperService;
import com.example.bootcampProject.core.utulities.results.DataResult;
import com.example.bootcampProject.core.utulities.results.SuccessDataResult;
import com.example.bootcampProject.dataAccess.abstracts.BootcampRepository;
import com.example.bootcampProject.entities.concretes.Bootcamp;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

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
    }
}
