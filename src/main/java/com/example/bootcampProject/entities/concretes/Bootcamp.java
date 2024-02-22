package com.example.bootcampProject.entities.concretes;

import com.example.bootcampProject.core.entities.BootcampBaseEntitiy;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

import java.time.LocalDate;

public class Bootcamp extends BootcampBaseEntitiy {
    //instructor_id,startDate,endDate,bootcampState_id

    @OneToOne
    @JoinColumn(name="InstructorId")
    private Instructor instructor;

    @OneToOne
    @JoinColumn(name="BootcampStateId")
    private BootcampState bootcampState;

    @Column(name = "startDate")
    private LocalDate startDate;

    @Column(name = "endDate")
    private LocalDate endDate;
}
