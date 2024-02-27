package com.example.bootcampProject.business.abstracts;

import com.example.bootcampProject.business.requests.create.bootcamp.CreateBootcampRequest;
import com.example.bootcampProject.business.requests.update.bootcamp.UpdateBootcampRequest;
import com.example.bootcampProject.business.responses.create.bootcamp.CreateBootcampResponse;
import com.example.bootcampProject.business.responses.update.bootcamp.UpdateBootcampResponse;
import com.example.bootcampProject.business.responses.get.bootcamp.GetAllBootcampResponse;
import com.example.bootcampProject.business.responses.get.bootcamp.GetBootcampResponse;
import com.example.bootcampProject.core.utulities.paging.PageDto;
import com.example.bootcampProject.core.utulities.results.DataResult;
import com.example.bootcampProject.core.utulities.results.Result;

import java.util.List;

public interface BootcampService {
    DataResult<GetBootcampResponse> getById(int id);
    DataResult<List<GetAllBootcampResponse>> getAll();

    DataResult<CreateBootcampResponse> add(CreateBootcampRequest request);
    DataResult<UpdateBootcampResponse> update(UpdateBootcampRequest updateBootcampRequest, int id);
    Result delete(int id);
    DataResult<List<GetAllBootcampResponse>> getAllPage(PageDto pageDto);
}
