package com.example.bootcampProject.business.abstracts;

import com.example.bootcampProject.business.requests.create.application.CreateApplicationRequest;
import com.example.bootcampProject.business.responses.create.application.CreateApplicationResponse;
import com.example.bootcampProject.business.responses.update.application.UpdateApplicationResponse;
import com.example.bootcampProject.business.responses.get.application.GetAllApplicationResponse;
import com.example.bootcampProject.business.responses.get.application.GetApplicationResponse;
import com.example.bootcampProject.core.utulities.paging.PageDto;
import com.example.bootcampProject.core.utulities.results.DataResult;
import com.example.bootcampProject.core.utulities.results.Result;

import java.util.List;

public interface ApplicationService {
    DataResult<GetApplicationResponse> getById(int id);
    DataResult<CreateApplicationResponse> add(CreateApplicationRequest request);
    DataResult<UpdateApplicationResponse> update(UpdateApplicationResponse updateApplicationResponse, int id);
    Result delete(int id);
    DataResult<List<GetAllApplicationResponse>> getAll();
    DataResult<List<GetAllApplicationResponse>> getAllPage(PageDto pageDto);
}
