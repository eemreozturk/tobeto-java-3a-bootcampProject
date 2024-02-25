package com.example.bootcampProject.business.abstracts;

import com.example.bootcampProject.business.requests.create.bootcampState.CreateBootcampStateRequest;
import com.example.bootcampProject.business.requests.update.bootcampState.UpdateBootcampStateRequest;
import com.example.bootcampProject.business.responses.create.bootcampState.CreateBootcampStateResponse;
import com.example.bootcampProject.business.responses.get.bootcampState.GetAllBootcampStateResponse;
import com.example.bootcampProject.business.responses.update.bootcampState.UpdateBootcampStateResponse;
import com.example.bootcampProject.core.utulities.results.DataResult;
import com.example.bootcampProject.core.utulities.results.Result;

import java.util.List;

public interface BootcampStateService {
    DataResult<GetAllBootcampStateResponse> getById(int id);
    DataResult<List<GetAllBootcampStateResponse>> getAll();

    DataResult<CreateBootcampStateResponse> add(CreateBootcampStateRequest request);
    DataResult<UpdateBootcampStateResponse> update(UpdateBootcampStateRequest updateBootcampStateResponse, int id);
    Result delete(int id);
}
