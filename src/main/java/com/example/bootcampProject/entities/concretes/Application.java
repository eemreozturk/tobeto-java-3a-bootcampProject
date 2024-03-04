package com.example.bootcampProject.entities.concretes;

import com.example.bootcampProject.core.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="application")
@EqualsAndHashCode(callSuper = true)
public class Application extends BaseEntity<Integer> {
    //applicant_id,bootcamp_id,applicationState_id

    @ManyToOne
    @JoinColumn(name="ApplicantId")
    private Applicant applicant;

    @ManyToOne
    @JoinColumn(name="BootcampId")
    private Bootcamp bootcamp;

    @ManyToOne
    @JoinColumn(name="ApplicationStateId")
    private ApplicationState applicationState;


}
