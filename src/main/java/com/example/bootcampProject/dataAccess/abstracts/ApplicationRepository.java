package com.example.bootcampProject.dataAccess.abstracts;

import com.example.bootcampProject.entities.concretes.Application;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationRepository extends JpaRepository<Application,Integer> {
    Application findById(int id);
}
