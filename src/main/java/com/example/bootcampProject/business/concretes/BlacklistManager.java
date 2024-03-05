package com.example.bootcampProject.business.concretes;

import com.example.bootcampProject.business.abstracts.BlacklistService;
import com.example.bootcampProject.business.constants.BlacklistMessages;
import com.example.bootcampProject.business.requests.create.blacklist.CreateBlacklistRequest;
import com.example.bootcampProject.business.requests.update.blacklist.UpdateBlacklistRequest;
import com.example.bootcampProject.business.responses.create.blacklist.CreateBlacklistResponse;
import com.example.bootcampProject.business.responses.get.blacklist.GetAllBlacklistResponse;
import com.example.bootcampProject.business.responses.get.blacklist.GetBlacklistResponse;
import com.example.bootcampProject.business.responses.update.blacklist.UpdateBlacklistResponse;
import com.example.bootcampProject.business.rules.BlacklistBusinessRules;
import com.example.bootcampProject.core.aspects.logging.Loggable;
import com.example.bootcampProject.core.utulities.mapping.ModelMapperService;
import com.example.bootcampProject.core.utulities.paging.PageDto;
import com.example.bootcampProject.core.utulities.results.*;
import com.example.bootcampProject.dataAccess.abstracts.BlacklistRepository;
import com.example.bootcampProject.entities.concretes.Blacklist;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BlacklistManager implements BlacklistService {

    private ModelMapperService modelMapperService;
    private BlacklistRepository blacklistRepository;
    private BlacklistBusinessRules blacklistBusinessRules;

    @Override
    public DataResult<GetBlacklistResponse> getById(int id) {
        Blacklist blacklist = blacklistRepository.findById(id);
        GetBlacklistResponse response = modelMapperService.forResponse().map(blacklist,GetBlacklistResponse.class);
        return new SuccessDataResult<GetBlacklistResponse>(response, BlacklistMessages.BlacklistGetById) ;
    }

    @Override
    @Loggable
    public DataResult<CreateBlacklistResponse> add(CreateBlacklistRequest request) {
        blacklistBusinessRules.checkIfReasonExists(request.getReason());
        Blacklist blacklist = modelMapperService.forRequest().map(request, Blacklist.class);
        blacklist.setCreatedDate(LocalDateTime.now());
        blacklistRepository.save(blacklist);
        CreateBlacklistResponse response = modelMapperService.forResponse().map(blacklist, CreateBlacklistResponse.class);

        return new SuccessDataResult<CreateBlacklistResponse>(response, BlacklistMessages.BlacklistAdded);
    }

    @Override
    @Loggable
    public DataResult<UpdateBlacklistResponse> update(UpdateBlacklistRequest updateBlacklistRequest, int id) {
        Blacklist blacklist = blacklistRepository.findById(id);
        Blacklist updateBlacklist = modelMapperService.forRequest().map(updateBlacklistRequest, Blacklist.class);
        UpdateBlacklistResponse response = modelMapperService.forResponse().map(blacklist, UpdateBlacklistResponse.class);

        return new SuccessDataResult<UpdateBlacklistResponse>(response, BlacklistMessages.BlacklistUpdated);
    }

    @Override
    @Loggable
    public Result delete(int id) {
        Blacklist blacklist = blacklistRepository.getById(id);
        blacklistRepository.delete(blacklist);
        return new SuccessResult(BlacklistMessages.BlacklistDeleted);
    }

    @Override
    @Loggable
    public DataResult<List<GetAllBlacklistResponse>> getAll() {
        List<Blacklist> blacklists = blacklistRepository.findAll();
        List<GetAllBlacklistResponse> blacklistResponses = blacklists.stream().map(blacklist -> modelMapperService.forResponse().map(blacklist, GetAllBlacklistResponse.class)).collect(Collectors.toList());

        return new SuccessDataResult<List<GetAllBlacklistResponse>>(blacklistResponses,BlacklistMessages.BlacklistListed) ;
    }

    @Override
    public DataResult<List<GetAllBlacklistResponse>> getAllPage(PageDto pageDto) {
        Sort sort=Sort.by(Sort.Direction.fromString(pageDto.getSortDirection()),pageDto.getSortBy());
        Pageable pageable = (Pageable) PageRequest.of(pageDto.getPageNumber(),pageDto.getPageSize(),sort);
        Page<Blacklist> blacklists= blacklistRepository.findAll((org.springframework.data.domain.Pageable) pageable);
        List<GetAllBlacklistResponse> responses=blacklists.stream().map(blacklist -> modelMapperService.forResponse().map(blacklist,GetAllBlacklistResponse.class)).toList();

        return new SuccessDataResult<List<GetAllBlacklistResponse>>(responses) ;
    }

}
