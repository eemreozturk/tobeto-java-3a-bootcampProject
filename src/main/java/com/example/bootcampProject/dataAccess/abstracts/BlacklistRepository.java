package com.example.bootcampProject.dataAccess.abstracts;

import com.example.bootcampProject.entities.concretes.Blacklist;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;

public interface BlacklistRepository extends JpaRepository<Blacklist,Integer> {
    Blacklist findById(int id);
    Blacklist findByReason(String reason);


}
