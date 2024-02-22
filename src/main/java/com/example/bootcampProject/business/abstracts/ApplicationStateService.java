package com.example.bootcampProject.business.abstracts;

import com.example.bootcampProject.business.responses.get.application.GetApplicationResponse;

public interface ApplicationStateService {
    GetApplicationResponse getById(int id);
}
