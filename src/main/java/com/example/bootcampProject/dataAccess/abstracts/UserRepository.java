package com.example.bootcampProject.dataAccess.abstracts;

import com.example.bootcampProject.core.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <User,Integer>{
    User findById(int id);

    User findByEmail(String email);
}
