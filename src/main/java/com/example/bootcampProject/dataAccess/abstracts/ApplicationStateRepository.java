package com.example.bootcampProject.dataAccess.abstracts;

import com.example.bootcampProject.entities.concretes.ApplicationState;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationStateRepository extends JpaRepository<ApplicationState,Integer> {
    ApplicationState findById(int id);
}
