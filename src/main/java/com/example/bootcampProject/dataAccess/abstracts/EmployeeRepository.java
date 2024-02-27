package com.example.bootcampProject.dataAccess.abstracts;

import com.example.bootcampProject.entities.concretes.Employee;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    Employee findByPosition(String position);
    Employee getByPosition(String position);
}
