package com.example.bootcampProject.business.abstracts;

import com.example.bootcampProject.business.responses.get.user.GetAllUserResponse;
import com.example.bootcampProject.core.utulities.results.DataResult;

public interface InstructorService {
    GetAllUserResponse getByCompanyName(String companyName) ;
}
