package com.example.bootcampProject.business.abstracts;

import com.example.bootcampProject.business.requests.create.applicationState.CreateApplicationStateRequest;
import com.example.bootcampProject.business.requests.update.applicationState.UpdateApplicationStateRequest;
import com.example.bootcampProject.business.responses.create.applicationState.CreateApplicationStateResponse;
import com.example.bootcampProject.business.responses.get.applicationState.GetAllApplicationStateResponse;
import com.example.bootcampProject.business.responses.update.applicationState.UpdateApplicationStateResponse;
import com.example.bootcampProject.core.utulities.results.DataResult;
import com.example.bootcampProject.core.utulities.results.Result;

import java.util.List;

public interface ApplicationStateService {
    DataResult<GetAllApplicationStateResponse> getById(int id);
    DataResult<List<GetAllApplicationStateResponse>> getAll();

    DataResult<CreateApplicationStateResponse> add(CreateApplicationStateRequest request);
    DataResult<UpdateApplicationStateResponse> update(UpdateApplicationStateRequest updateApplicationStateResponse, int id);
    Result delete(int id);
}
