package com.example.bootcampProject.dataAccess.abstracts;

import com.example.bootcampProject.entities.concretes.BootcampState;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BootcampStateRepository extends JpaRepository<BootcampState,Integer> {
    BootcampState findById(int id);
}
