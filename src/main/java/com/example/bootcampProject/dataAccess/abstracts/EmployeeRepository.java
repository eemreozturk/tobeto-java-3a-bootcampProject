package com.example.bootcampProject.dataAccess.abstracts;

import com.example.bootcampProject.core.entities.User;
import com.example.bootcampProject.entities.concretes.Employee;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    User findByPosition(String position);
}
