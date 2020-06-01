package com.kalaiworld.feedback.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

@Entity(name = "questionnaire")
@Data
@ToString(exclude = {"questions"})
public class Questionnaire implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Boolean isDefault;
    private String templateName;
    private String companyName;
    private int responseLimit;
    private String position;
    private LocalDate interviewDate;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "questionnaire", orphanRemoval = true)
    private Set<Question> questions;

}
