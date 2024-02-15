package com.example.bootcampProject.dataAccess.abstracts;

import com.example.bootcampProject.entities.concretes.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <User,Integer>{

}
