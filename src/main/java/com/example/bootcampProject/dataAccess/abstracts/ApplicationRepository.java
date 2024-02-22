package com.example.bootcampProject.dataAccess.abstracts;

import com.example.bootcampProject.entities.concretes.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationRepository extends JpaRepository<User,Integer> {
    User findById(int id);
}
