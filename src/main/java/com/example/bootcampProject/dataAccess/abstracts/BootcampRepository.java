package com.example.bootcampProject.dataAccess.abstracts;

import com.example.bootcampProject.entities.concretes.Bootcamp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BootcampRepository extends JpaRepository<Bootcamp,Integer> {
    Bootcamp findById(int id);
}
