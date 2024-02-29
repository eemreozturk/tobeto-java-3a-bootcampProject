package com.example.bootcampProject.dataAccess.abstracts;

import com.example.bootcampProject.entities.concretes.Applicant;

import com.example.bootcampProject.entities.concretes.Application;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;

public interface ApplicantRepository extends JpaRepository<Applicant,Integer> {


    Applicant findByAbout(String about);
    Applicant getByAbout(String about);
}
