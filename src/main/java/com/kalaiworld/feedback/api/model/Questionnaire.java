package com.kalaiworld.feedback.api.model;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.Set;

@Entity(name = "questionnaire")
@Data
public class Questionnaire {

    @Id
    private String questionnaireId;
    private Boolean isDefault;
    private String templateName;
    private String companyName;
    private int responseLimit;
    private String position;
    private LocalDate interviewDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "questionnaireId", orphanRemoval = true)
    private Set<Question> questions;

}
