package com.example.bootcampProject.entities.concretes;

import com.example.bootcampProject.core.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="bootcamp")
@EqualsAndHashCode(callSuper = true)
public class Bootcamp extends BaseEntity<Integer> {
    //instructor_id,startDate,endDate,bootcampState_id


    @OneToOne
    @JoinColumn(name="InstructorId")
    private Instructor instructor;

    @Column(name = "Name")
    private String name;

    @ManyToOne
    @JoinColumn(name="BootcampStateId")
    private BootcampState bootcampState;

    @Column(name = "startDate")
    private LocalDate startDate;

    @Column(name = "endDate")
    private LocalDate endDate;
}
