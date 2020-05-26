package com.kalaiworld.feedback.api.model;


import lombok.Data;

import javax.persistence.*;

@Entity(name = "question")
@Data
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String description;
    private String type;
    private String options;
    @ManyToOne
    @JoinColumn(name = "questionnaireId", nullable = false)
    private Questionnaire questionnaire;
}

