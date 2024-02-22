package com.example.bootcampProject.business.abstracts;

import com.example.bootcampProject.business.responses.get.application.GetApplicationResponse;

public interface BootcampStateService {
    GetApplicationResponse getById(int id);
}
