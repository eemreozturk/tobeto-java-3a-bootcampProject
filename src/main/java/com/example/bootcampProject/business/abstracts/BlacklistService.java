package com.example.bootcampProject.business.abstracts;

import com.example.bootcampProject.business.requests.create.blacklist.CreateBlacklistRequest;
import com.example.bootcampProject.business.requests.update.blacklist.UpdateBlacklistRequest;
import com.example.bootcampProject.business.responses.create.blacklist.CreateBlacklistResponse;
import com.example.bootcampProject.business.responses.get.blacklist.GetAllBlacklistResponse;
import com.example.bootcampProject.business.responses.get.blacklist.GetBlacklistResponse;
import com.example.bootcampProject.business.responses.update.blacklist.UpdateBlacklistResponse;
import com.example.bootcampProject.core.utulities.paging.PageDto;
import com.example.bootcampProject.core.utulities.results.DataResult;
import com.example.bootcampProject.core.utulities.results.Result;

import java.util.List;

public interface BlacklistService {
    DataResult<GetBlacklistResponse> getById(int id);
    DataResult<CreateBlacklistResponse> add(CreateBlacklistRequest request);
    DataResult<UpdateBlacklistResponse> update(UpdateBlacklistRequest updateBlacklistRequest, int id);
    Result delete(int id);
    DataResult<List<GetAllBlacklistResponse>> getAll();
    DataResult<List<GetAllBlacklistResponse>> getAllPage(PageDto pageDto);

}
