package com.example.bootcampProject.dataAccess.abstracts;

import com.example.bootcampProject.entities.concretes.Applicant;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicantRepository extends JpaRepository<Applicant,Integer> {
}
