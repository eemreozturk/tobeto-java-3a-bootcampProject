package com.example.bootcampProject.dataAccess.abstracts;


import com.example.bootcampProject.entities.concretes.User;
import com.example.bootcampProject.entities.concretes.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstructorRepository extends JpaRepository<Instructor,Integer> {
    User findByCompanyName(String companyName);
}
