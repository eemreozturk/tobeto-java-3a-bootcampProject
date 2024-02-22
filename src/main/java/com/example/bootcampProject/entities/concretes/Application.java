package com.example.bootcampProject.entities.concretes;

import com.example.bootcampProject.core.entities.ApplicationBaseEntitiy;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="application")
public class Application extends ApplicationBaseEntitiy {
    //applicant_id,bootcamp_id,applicationState_id

    @OneToOne
    @JoinColumn(name="ApplicantId")
    private Applicant applicant;

    @OneToOne
    @JoinColumn(name="BootcampId")
    private Bootcamp bootcamp;

    @OneToOne
    @JoinColumn(name="ApplicationStateId")
    private ApplicationState applicationState;

}
